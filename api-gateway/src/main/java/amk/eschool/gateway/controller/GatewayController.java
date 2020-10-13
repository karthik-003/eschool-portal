package amk.eschool.gateway.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import amk.eschool.gateway.model.AuthenticationRequest;
import amk.eschool.gateway.model.AuthenticationResponse;
import amk.eschool.gateway.service.UserLoginService;

@RestController
public class GatewayController {

	Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	UserLoginService service;
	
	@PostMapping("/eschool/login")
	public ResponseEntity<Object> userLogin(@RequestBody AuthenticationRequest request) throws Exception{
		logger.info("GatewayController::userLogin()--> "+request.getUserName());
		AuthenticationResponse response = service.authenticate(request);
		return ResponseEntity.ok(response);
	}
	
}
