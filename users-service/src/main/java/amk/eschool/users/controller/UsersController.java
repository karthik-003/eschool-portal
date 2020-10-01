package amk.eschool.users.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import amk.eschool.users.service.UsersService;

@RestController
@RequestMapping("/users")
public class UsersController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	UsersService usrService;
	
	@GetMapping("/{userId}")
	public ResponseEntity<Object> getUserInfo(@PathVariable("userId") long userId) {
		logger.info("getUserInfo().."+userId);
		return ResponseEntity.ok().build();
	}
}
