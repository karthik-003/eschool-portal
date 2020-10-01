package amk.eschool.users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import amk.eschool.users.repo.UserRepo;

@Service
public class UsersService {

	@Autowired
	UserRepo repo;
}
