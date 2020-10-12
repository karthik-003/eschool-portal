package amk.eschool.users.model;

public enum UserType {

	PRINCIPAL("1"),
	ADMIN("2"),
	TEACHER("3"),
	PARENT("4"),
	STUDENT("5");
	
	
	public String userType;
	
	UserType(String type){
		this.userType = type;
	}
	
	public String getUserType() {
		return this.userType;
	}
}
