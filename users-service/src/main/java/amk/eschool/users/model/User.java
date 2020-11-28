package amk.eschool.users.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name="user_info")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	long userId;
	
	String fullName;
	String gender;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="contact_id",referencedColumnName = "ctctId")
    ContactInfo ctctInfo;
	
	@Column(name="age")
	int age;
	@Column(name="date_of_birth")
	@JsonFormat(pattern="dd-MM-yyyy")
	Date dateOfBirth;
	
	@Column(name="status")
	int status;
	@Column(name="user_type")
	int type;
	
	@Column(name="created_dt")
	Date dateCreated;
	@Column(name="last_updated_dt")
	Date dateUpdated;
	@Column(name="created_by")
	long createdBy;
	@Column(name="udpated_by")
	long updatedBy;
	
	@OneToOne
	@JoinColumn(name="userId",referencedColumnName = "id")
	UserLoginInfo loginInfo;
	
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public String getFullName() {
		return fullName;
	}
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public ContactInfo getCtctInfo() {
		return ctctInfo;
	}
	public void setCtctInfo(ContactInfo ctctInfo) {
		this.ctctInfo = ctctInfo;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public Date getDateUpdated() {
		return dateUpdated;
	}
	public void setDateUpdated(Date dateUpdated) {
		this.dateUpdated = dateUpdated;
	}
	public long getCreatedBy() {
		return createdBy;
	}
	public void setCreatedBy(long createdBy) {
		this.createdBy = createdBy;
	}
	public long getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(long updatedBy) {
		this.updatedBy = updatedBy;
	}
	
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type = type;
	}
	public UserLoginInfo getLoginInfo() {
		return loginInfo;
	}
	public void setLoginInfo(UserLoginInfo loginInfo) {
		this.loginInfo = loginInfo;
	}
	@Override
	public String toString() {
		return "User [userId=" + userId + ", fullName=" + fullName + ", gender=" + gender + ", ctctInfo=" + ctctInfo
				+ ", age=" + age + ", dateOfBirth=" + dateOfBirth + ", status=" + status + ", dateCreated="
				+ dateCreated + ", dateUpdated=" + dateUpdated + ", createdBy=" + createdBy + ", updatedBy=" + updatedBy
				+ "]";
	}
	
	
}
