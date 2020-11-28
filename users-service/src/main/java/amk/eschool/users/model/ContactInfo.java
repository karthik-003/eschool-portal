package amk.eschool.users.model;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class ContactInfo {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	long ctctId;
	
	@Column(name="email")
	String email;
	@Column(name="phone")
	String phone;
	@Embedded
	Address address;
	
	@OneToOne(mappedBy = "ctctInfo")
	User user;
	
	public ContactInfo() {
		// TODO Auto-generated constructor stub
	}
	
	
	public long getCtctId() {
		return ctctId;
	}


	public void setCtctId(long ctctId) {
		this.ctctId = ctctId;
	}


	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	@Override
	public String toString() {
		return "ContactInfo [email=" + email + ", phone=" + phone + ", address=" + address + "]";
	}
	
	
}
