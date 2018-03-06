package com.hosuke.mapper;

import com.hosuke.entity.User;

public interface UserMapper {

    User findByUsernameIgnoreCase(String username);

    User findByEmailIgnoreCase(String email);

    User findByUsernameOrEmail(User user);

    default User findByUsernameOrEmail(String username, String email) {
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);
        return findByUsernameOrEmail(user);
    }
}
