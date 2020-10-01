package amk.eschool.users.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import amk.eschool.users.model.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{

}
