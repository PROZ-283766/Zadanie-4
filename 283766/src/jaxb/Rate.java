package jaxb;

import javax.xml.bind.annotation.XmlElement;

public class Rate {
	private Double Ask;
	private Double Bid;
	private Double Mid;

	@XmlElement(name = "Ask")
	public void setAsk(Double ask) {
		Ask = ask;
	}

	public Double getAsk() {
		return Ask;
	}

	@XmlElement(name = "Bid")
	public void setBid(Double bid) {
		Bid = bid;
	}

	public Double getBid() {
		return Bid;
	}

	@XmlElement(name = "Mid")
	public void setMid(Double mid) {
		Mid = mid;
	}

	public Double getMid() {
		return Mid;
	}
}
