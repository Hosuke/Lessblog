package com.hosuke.entity;

import com.hosuke.service.MarkdownConverter;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {

    public interface CreateValidationGroup {}
    public interface ChangeEmailValidationGroup {}
    public interface ChangePasswordValidationGroup {}
    public interface ProfileInfoValidationGroup {}

    private Long Id;

    private String username;

    private String email;


    private String password;

    private boolean enabled;

    private LocalDateTime registrationDate;

    private List<Role> roles = new ArrayList<>();

    private List<Comment> comments = new ArrayList<>();

    private String aboutText;

    private String websiteLink;

    private String smallAvatarLink;

    private String bigAvatarLink;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public LocalDateTime getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(LocalDateTime registrationDate) {
        this.registrationDate = registrationDate;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public String getAboutText() {
        return aboutText;
    }

    public String getAboutTextHtml() {
        return StringUtils.isEmpty(aboutText) ? "" : MarkdownConverter.toHtml(aboutText);
    }

    public void setAboutText(String aboutText) {
        this.aboutText = aboutText;
    }

    public String getWebsiteLink() {
        return websiteLink;
    }

    public String getWebsiteLinkTitle() {
        return StringUtils.isEmpty(websiteLink) ? "" :
                StringUtils.trimTrailingCharacter(websiteLink.replace("https://", "").replace("http://", "").replace("www.", ""), '/');
    }

    public void setWebsiteLink(String websiteLink) {
        this.websiteLink = websiteLink;
    }

    public String getSmallAvatarLink() {
        return smallAvatarLink;
    }

    public void setSmallAvatarLink(String smallAvatarLink) {
        this.smallAvatarLink = smallAvatarLink;
    }

    public String getBigAvatarLink() {
        return bigAvatarLink;
    }

    public void setBigAvatarLink(String bigAvatarLink) {
        this.bigAvatarLink = bigAvatarLink;
    }

    public boolean hasRole(String role) {
        role = role.toUpperCase();

        if (!role.startsWith("ROLE_"))
            role = "ROLE_" + role;

        final String finalRole = role;
        return getRoles().stream().anyMatch(r -> r.getName().equals(finalRole));
    }

    @Override
    public String toString() {
        return "User{" +
                "Id=" + Id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", enabled=" + enabled +
                ", roles=" + roles +
                '}';
    }
}
