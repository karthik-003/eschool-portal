package amk.eschool.gateway.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import amk.eschool.gateway.entity.UserLoginInfo;

public interface UserLoginRepo extends JpaRepository<UserLoginInfo, Long>{

}
