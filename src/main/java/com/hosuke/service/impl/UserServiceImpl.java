package com.hosuke.service.impl;

import com.hosuke.entity.Role;
import com.hosuke.entity.User;
import com.hosuke.mapper.RoleMapper;
import com.hosuke.mapper.UserMapper;
import com.hosuke.service.Exception.AuthException;
import com.hosuke.service.UploadedAvatarInfo;
import com.hosuke.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RoleMapper roleMapper;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = userMapper.findByUsernameOrEmail(s, s);

        if (user == null)
            throw new UsernameNotFoundException("no such user");

        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Role role : user.getRoles()) {
            authorities.add(new SimpleGrantedAuthority(role.getName()));
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                user.isEnabled(), true, true, true, authorities);
    }

    @Override
    public User findByEmail(String email) {
        return userMapper.findByEmailIgnoreCase(email);
    }

    @Override
    public User findByUsername(String username) {
        return userMapper.findByUsernameIgnoreCase(username);
    }

    @Override
    public boolean usernameExists(String username) {
        return findByUsername(username) != null;
    }

    @Override
    public boolean emailExists(String email) {
        return findByEmail(email) != null;
    }

    @Override
    public void register(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));

        user.getRoles().add(roleMapper.findByName("ROLE_USER"));

        user.setEnabled(true);

        // TODO: may make a utils
//        user.setRegistrationDate(LocalDateTime.now());
        user.setRegistrationDate(Date.from(LocalDateTime.now().atZone(ZoneId.systemDefault()).toInstant()));

        userMapper.insert(user);
    }

    @Override
    public void changeEmail(String newEmail, String currentPassword) throws AuthException {
        User user = currentUser();
        if (!passwordEncoder.matches(currentPassword, user.getPassword()))
            throw new AuthException("password does not match");

        user.setEmail(newEmail);

        userMapper.updateByPrimaryKey(user);
    }

    @Override
    public void changePassword(String newPassword, String currentPassword) throws AuthException {
        User user = currentUser();

        if (!passwordEncoder.matches(currentPassword, user.getPassword()))
            throw new AuthException("password does not match");

        user.setPassword(passwordEncoder.encode(newPassword));

        userMapper.updateByPrimaryKey(user);
    }

    @Override
    public void changeProfileInfo(User newProfileInfo) {
        User user = currentUser();

        user.setAboutText(newProfileInfo.getAboutText());

        user.setWebsiteLink(newProfileInfo.getWebsiteLink());

        userMapper.updateByPrimaryKey(user);
    }

    @Override
    public void changeAvatar(UploadedAvatarInfo uploadedAvatarInfo) {
        User user = currentUser();

        user.setBigAvatarLink(uploadedAvatarInfo.bigImageLink);

        user.setSmallAvatarLink(uploadedAvatarInfo.smallImageLink);

        userMapper.updateByPrimaryKey(user);
    }

    @Override
    public void removeAvatar() {
        User user = currentUser();

        user.setBigAvatarLink(null);

        user.setSmallAvatarLink(null);

        userMapper.updateByPrimaryKey(user);
    }

    @Override
    public void authenticate(User user) {
        UserDetails userDetails = loadUserByUsername(user.getUsername());

        Authentication auth = new UsernamePasswordAuthenticationToken(userDetails, null, userDetails.getAuthorities());
        SecurityContextHolder.getContext().setAuthentication(auth);
    }

    @Override
    public boolean isAuthenticated() {
        SecurityContext securityContext = SecurityContextHolder.getContext();

        Authentication auth = securityContext.getAuthentication();

        return auth != null && !(auth instanceof AnonymousAuthenticationToken) && auth.isAuthenticated();
    }

    @Override
    public boolean isAdmin() {
        User user = currentUser();

        return user != null && user.hasRole("ROLE_ADMIN");
    }

    @Override
    public User currentUser() {
        if (!isAuthenticated())
            return null;

        SecurityContext securityContext = SecurityContextHolder.getContext();

        Authentication auth = securityContext.getAuthentication();

        return userMapper.findByUsernameIgnoreCase(auth.getName());
    }

    public PasswordEncoder getPasswordEncoder() {
        return passwordEncoder;
    }

    public void setPasswordEncoder(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }
}
