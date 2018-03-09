package com.hosuke.model.dto;

/**
 * @Author Hosuke
 *
 * ArticleLiteDto 是 用来 在 首页中 显示 文章的 基本情况的 比如 标题 发布日期 有些blog 还会显示内容简介.
 * 可以减少对数据库的读取访问量.在首页中显示不需要显示文章的内容和markdown内容.
 */
public class ArticleLiteDto {
    private Integer id;
    private String title;
    private String pubDate;
    private Integer clicks;
    private String remark;
    private UserDto user;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPubDate() {
        return pubDate;
    }

    public void setPubDate(String pubDate) {
        this.pubDate = pubDate;
    }

    public Integer getClicks() {
        return clicks;
    }

    public void setClicks(Integer clicks) {
        this.clicks = clicks;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "ArticleLiteDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", pubDate='" + pubDate + '\'' +
                ", clicks=" + clicks +
                ", remark='" + remark + '\'' +
                ", user=" + user +
                '}';
    }
}
