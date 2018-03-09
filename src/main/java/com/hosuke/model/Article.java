package com.hosuke.model;

/**
 * @Author Hosuke
 *
 * 对应 t_article 表
 * id       文章id
 * categoryId 分类id
 * userId   发表用户id
 * title    文章标题
 * content  文章内容
 * putDate  文章发布日期
 * clicks   点击次数
 * remark   评论
 * picture  图片
 * isDraft  是否草稿 默认0
 */
public class Article {
    private Integer id;
    private Integer categoryId;
    private Integer userId;
    private String title;
    private String content;
    private String markDown;
    private String pubDate;
    private Integer clicks;
    private String remark;
    private String picture;
    private Integer isDraft;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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

    @Override
    public String toString() {
        return "Article{" +
                "id=" + id +
                ", categoryId=" + categoryId +
                ", userId=" + userId +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", markDown='" + markDown + '\'' +
                ", pubDate=" + pubDate +
                ", clicks=" + clicks +
                ", remark='" + remark + '\'' +
                ", picture='" + picture + '\'' +
                ", isDraft=" + isDraft +
                '}';
    }
}
