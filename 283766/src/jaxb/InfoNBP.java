package jaxb;

import java.io.StringReader;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class InfoNBP {

	private Client client;
	private WebTarget webTarget;

	InfoNBP() {
		client = ClientBuilder.newClient();
	}

	public String getAns(String table, String code, String topCount) {
		client = ClientBuilder.newClient();
		webTarget = client.target("http://api.nbp.pl/api/exchangerates/rates/").path(table).path(code).path("last")
				.path(topCount.toString());

		double avg = -1.0;
		ExchangeRatesSeries exchangeRatesSeries = new ExchangeRatesSeries();
		try {
			JAXBContext context = JAXBContext.newInstance(ExchangeRatesSeries.class);
			Unmarshaller unmarshaller = context.createUnmarshaller();
			StringReader reader = new StringReader(webTarget.request().accept(MediaType.TEXT_XML).get(String.class));
			exchangeRatesSeries = (ExchangeRatesSeries) unmarshaller.unmarshal(reader);
			avg = table.equals("C") ? exchangeRatesSeries.getAverage(true) : exchangeRatesSeries.getAverage(false);
		} catch (JAXBException e) {
			e.printStackTrace();
		}
		return "" + avg;
	}

}
