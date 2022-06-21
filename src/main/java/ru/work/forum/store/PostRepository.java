package ru.work.forum.store;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import ru.work.forum.model.Post;

public interface PostRepository extends CrudRepository<Post, Integer> {

}
