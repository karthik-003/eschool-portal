package amk.eschool.users.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import amk.eschool.users.model.UserLoginInfo;

@Repository
public interface UserLoginRepo extends JpaRepository<UserLoginInfo, Long>{

	@Query("select u from UserLoginInfo u where u.userName=?1")
	public UserLoginInfo findByUserName(String userName);
}

