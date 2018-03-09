package com.hosuke.model.dto;

import com.hosuke.model.Category;

/**
 * @Author Hosuke
 * id  文章id
 * title    文章标题
 * content  文章内容
 * putDate  文章发布日期
 * clicks   点击次数
 * remark   评论
 * picture  图片
 * isDraft  是否草稿 默认0
 * category 分类
 * user     用户
 */
public class ArticleDto {
    private Integer id;
    private String title;
    private  String content;
    private  String markDown;
    private String pubDate;
    private Integer clicks;
    private String remark;
    private String picture;
    private Integer isDraft;
    private Category category;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getMarkDown() {
        return markDown;
    }

    public void setMarkDown(String markDown) {
        this.markDown = markDown;
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

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Integer getIsDraft() {
        return isDraft;
    }

    public void setIsDraft(Integer isDraft) {
        this.isDraft = isDraft;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "ArticleDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", markDown='" + markDown + '\'' +
                ", pubDate='" + pubDate + '\'' +
                ", clicks=" + clicks +
                ", remark='" + remark + '\'' +
                ", picture='" + picture + '\'' +
                ", isDraft=" + isDraft +
                ", category=" + category +
                ", user=" + user +
                '}';
    }
}
