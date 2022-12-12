package kiy3035.abc.repository;

import kiy3035.abc.domain.User1;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    User1 save(User1 user);
    Optional<User1> findById(Long idx);
    Optional<User1> findByName(String user_name);
    List<User1> findAll();

}
