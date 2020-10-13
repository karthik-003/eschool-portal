package amk.eschool.gateway.model;

public class AuthenticationResponse {

	String jwt;

	public String getJwt() {
		return jwt;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}
	
	public AuthenticationResponse() {
		// TODO Auto-generated constructor stub
	}
	
	public AuthenticationResponse(String jwt) {
		// TODO Auto-generated constructor stub
		this.jwt = jwt;
	}
}
