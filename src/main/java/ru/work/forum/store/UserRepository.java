package ru.work.forum.store;

import org.springframework.data.repository.CrudRepository;
import ru.work.forum.model.User;

public interface UserRepository extends CrudRepository<User, Integer> {

    User findByUsername(String username);

}
