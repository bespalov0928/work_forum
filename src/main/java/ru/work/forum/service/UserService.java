package ru.work.forum.service;

import org.springframework.stereotype.Service;
import ru.work.forum.model.Authority;
import ru.work.forum.model.User;
import ru.work.forum.store.AuthorityRepository;
import ru.work.forum.store.UserRepository;

@Service
public class UserService {
    private final UserRepository users;
//    private final RoleRepository roles;
    private final AuthorityRepository authorities;

    public UserService(UserRepository users, AuthorityRepository authorities) {
        this.users = users;
//        this.roles = roles;
        this.authorities = authorities;
    }

    public void saveUser(User user, String roleName) {
        User userFind = findByName(user.getUsername());
        if (userFind == null) {
            users.save(user);
            userFind = user;
        }
//        Role role = roles.findByName(roleName);
        Authority authority = authorities.findByAuthority(roleName);
//        userFind.setRole(role);
        userFind.setAuthority(authority);
        users.save(userFind);
    }

    public User findByName(String username) {
        User user = users.findByUsername(username);
        return user;

    }

}