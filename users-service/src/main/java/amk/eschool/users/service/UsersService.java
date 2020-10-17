package amk.eschool.users.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import amk.eschool.users.model.User;
import amk.eschool.users.model.UserLoginInfo;
import amk.eschool.users.model.UserStatus;
import amk.eschool.users.repo.UserLoginRepo;
import amk.eschool.users.repo.UserRepo;
import amk.eschool.users.utils.JwtUtil;

@Service
public class UsersService implements UserDetailsService{

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	UserRepo repo;
	
	@Autowired
	UserLoginRepo loginRepo;

	@Autowired
	JwtUtil jwtUtil;
	
	@Override
	public UserLoginInfo loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		return loginRepo.findByUserName(username);
	}
	
	@Transactional
	public void addUser(int userType,User usr) {
		usr.setType(userType);
		setDefaults(usr);
		logger.info("UsersService::addUser()--> userType: "+userType);
		logger.info("UsersService::addUser()--> usr: "+usr);
		repo.save(usr);
		createLoginInfo(usr);
		
	}

	private void setDefaults(User usr) {
		// TODO Auto-generated method stub
		UserLoginInfo loggedInUser = loadUserByUsername(jwtUtil.extractUsername(JwtUtil.getAccessToken()));
		usr.setAge(getAge(usr.getDateOfBirth()));
		usr.setDateCreated(new Date());
		usr.setCreatedBy(loggedInUser.getId());
		usr.setStatus(UserStatus.PENDING_APPROVAL);
	}
	
	private int getAge(Date dob) {
		int age = 0;
		LocalDate dateOfBirth = new java.sql.Date(dob.getTime()).toLocalDate();
		LocalDate currentDate = new java.sql.Date(new Date().getTime()).toLocalDate();
		if ((dateOfBirth != null) && (currentDate != null)) {
            age =  Period.between(dateOfBirth, currentDate).getYears();
        } 
		return age;
	}
	
	private void createLoginInfo(User usr){
		UserLoginInfo loginInfo = new UserLoginInfo(usr);
		loginRepo.save(loginInfo);
	}
}
