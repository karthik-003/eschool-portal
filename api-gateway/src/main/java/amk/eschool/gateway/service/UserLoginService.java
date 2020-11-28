package amk.eschool.gateway.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import amk.eschool.gateway.entity.UserLoginInfo;
import amk.eschool.gateway.model.AuthenticationRequest;
import amk.eschool.gateway.model.AuthenticationResponse;
import amk.eschool.gateway.repo.UserLoginRepo;
import amk.eschool.gateway.util.JwtUtil;

@Service
public class UserLoginService implements UserDetailsService{

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@Autowired
	private UserLoginRepo loginRepo;
	
	@Autowired
	private JwtUtil jwtUtil;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		logger.info("UserLoginService::loadUserByUsername()--> "+username);
		
		return loginRepo.findByUserName(username);
	}
	
	public AuthenticationResponse authenticate(AuthenticationRequest request) throws Exception {
		try {
			authenticationManager.authenticate(
					new UsernamePasswordAuthenticationToken(request.getUserName(), request.getPassword())
			);
		}
		catch (BadCredentialsException e) {
			throw new Exception("Incorrect username or password", e);
		}
		
		final UserDetails usrDetails = loadUserByUsername(request.getUserName());
		logger.info(usrDetails.toString());
		final String jwt = jwtUtil.generateToken(usrDetails);
		return new AuthenticationResponse(jwt);
	}

}
