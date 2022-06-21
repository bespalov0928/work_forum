package ru.work.forum.service;

import org.springframework.stereotype.Service;
import ru.work.forum.model.Post;
import ru.work.forum.store.PostRepository;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@Service
public class PostService {
    private final PostRepository posts;

    public PostService(PostRepository posts) {
        this.posts = posts;
    }

    public List<Post> getAll() {
        List<Post> rsl = new ArrayList<>();
        posts.findAll().forEach(rsl::add);
        return rsl;
    }

    public void add(Post post, String[] idArr) {
        if (idArr != null) {
            Post postOld = posts.findById(Integer.valueOf(idArr[0])).get();
            postOld.setName(post.getName());
            postOld.setDescription(post.getDescription());
            postOld.setDiscussion(post.getDiscussion());
            posts.save(postOld);
            return;
        }
        Post postNew = Post.of(post.getName());
        postNew.setDescription(post.getDescription());
        postNew.setCreated(Calendar.getInstance());
        postNew.setDiscussion(post.getDiscussion());
        posts.save(postNew);
    }

    public Post findById(int id) {
        Post rsl = null;
        rsl = posts.findById(id).get();
        return rsl;
    }

}
