package jaxb;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/exchangerates/rates")
public class Exchange {

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("{table}/{code}/{topCount}")
	public String getAns(@PathParam("table") String table, @PathParam("code") String code,
			@PathParam("topCount") String topCount) {
		InfoNBP info = new InfoNBP();
		return info.getAns(table, code, topCount);
	}

	@GET
	@Produces(MediaType.TEXT_HTML)
	@Path("{table}/{code}/{topCount}")
	public String getAnsHTML(@PathParam("table") String table, @PathParam("code") String code,
			@PathParam("topCount") String topCount) {
		InfoNBP info = new InfoNBP();
		String ans = info.getAns(table, code, topCount);
		return "<html><body><h1>" + ans + "</h1></body></html>";

	}

	@GET
	@Produces(MediaType.TEXT_XML)
	@Path("{table}/{code}/{topCount}")
	public String getAnsXML(@PathParam("table") String table, @PathParam("code") String code,
			@PathParam("topCount") String topCount) {
		InfoNBP info = new InfoNBP();
		String ans = info.getAns(table, code, topCount);
		return "<?xml version=\"1.0\"?>" + "<ans>" + ans + "</ans>";
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("{table}/{code}/{topCount}")
	public String getAnsJSON(@PathParam("table") String table, @PathParam("code") String code,
			@PathParam("topCount") String topCount) {
		final JsonObjectBuilder jsonBuilder = Json.createObjectBuilder();
		InfoNBP info = new InfoNBP();
		String ans = info.getAns(table, code, topCount);
		jsonBuilder.add("ans", ans);
		JsonObject json = jsonBuilder.build();
		return json.toString();
	}

}