package kiosk.data;

import org.springframework.data.repository.CrudRepository;
import kiosk.User;

public interface UserRepository extends CrudRepository<User, Long> {

    User findByUsername(String username);

}