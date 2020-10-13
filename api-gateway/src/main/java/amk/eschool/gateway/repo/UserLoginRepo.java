package amk.eschool.gateway.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import amk.eschool.gateway.entity.UserLoginInfo;

@Repository
public interface UserLoginRepo extends JpaRepository<UserLoginInfo, Long>{

	@Query("SELECT u FROM UserLoginInfo u WHERE u.userName= ?1")
	public UserLoginInfo findByUserName(String userName);
}
