package amk.eschool.users.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Address {

	@Column(name="addr_1")
	String addrLine1;
	@Column(name="addr_2")
	String addrLine2;
	@Column(name="landmark")
	String landMark;
	@Column(name="city")
	String city;
	@Column(name="state")
	String state;
	@Column(name="zipCode")
	String zipCode;
	
	public Address() {
		// TODO Auto-generated constructor stub
	}

	public String getAddrLine1() {
		return addrLine1;
	}

	public void setAddrLine1(String addrLine1) {
		this.addrLine1 = addrLine1;
	}

	public String getAddrLine2() {
		return addrLine2;
	}

	public void setAddrLine2(String addrLine2) {
		this.addrLine2 = addrLine2;
	}

	public String getLandMark() {
		return landMark;
	}

	public void setLandMark(String landMark) {
		this.landMark = landMark;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	@Override
	public String toString() {
		return "Address [addrLine1=" + addrLine1 + ", addrLine2=" + addrLine2 + ", landMark=" + landMark + ", city="
				+ city + ", state=" + state + ", zipCode=" + zipCode + "]";
	}
	
	
}
