package amk.eschool.users.model;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import amk.eschool.users.utils.CommonUtils;

@Entity
@Table(name="login_info")
public class UserLoginInfo implements UserDetails{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1194203485811285221L;

	@Id
	private long id;
	@Column(name="user_name")
	private String userName;
	@Column(name="password")
	private String password;
	@Column(name="role")
	private Integer role;
	
	@OneToOne(mappedBy = "loginInfo")
	private User userInfo;
	
	public UserLoginInfo() {
		// TODO Auto-generated constructor stub
	}
	public UserLoginInfo(User usr) {
		// TODO Auto-generated constructor stub
		this.id = usr.getUserId();
		this.userName = usr.getCtctInfo().getEmail();
		this.role = usr.getType();
		this.password = CommonUtils.generateCommonLangPassword();
	}
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		// TODO Auto-generated method stub
		return null;
	}

	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}


	public long getId() {
		return id;
	}


	public String getUserName() {
		return userName;
	}


	public User getUserInfo() {
		return userInfo;
	}


	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return this.password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return this.userName;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	public Integer getRole() {
		return role;
	}

	public void setRole(Integer role) {
		this.role = role;
	}

	
}
