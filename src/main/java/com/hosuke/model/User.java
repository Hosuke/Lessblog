package com.hosuke.model;
/**
 * @Author Hosuke
 *
 * 对应 t_user 表
 * id   用户id
 * state    用户类型state,0代表普通用户，1代表管理员
 * username 用户名
 * password 用户密码
 * nickname 用户昵称
 * email    用户邮箱
 * website  用户网站
 * imageName用户头像名称
 */
public class User {
    private Integer id;
    private Integer state;
    private String username;
    private String password;
    private String nickname;
    private String email;
    private String website;
    private String imagePath;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", state=" + state +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", nickname='" + nickname + '\'' +
                ", email='" + email + '\'' +
                ", website='" + website + '\'' +
                ", imagePath='" + imagePath + '\'' +
                '}';
    }
}