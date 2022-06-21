package ru.work.forum.store;

import org.springframework.data.repository.CrudRepository;
import ru.work.forum.model.Authority;

public interface AuthorityRepository extends CrudRepository<Authority, Integer> {
    Authority findByAuthority(String authority);
}
