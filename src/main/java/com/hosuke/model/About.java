package com.hosuke.model;

/**
 * @Author Hosuke
 */
public class About {
    private String markDown;
    private String content;
    private Integer id;

    public String getMarkDown() {
        return markDown;
    }

    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "About{" +
                "markDown='" + markDown + '\'' +
                ", content='" + content + '\'' +
                ", id=" + id +
                '}';
    }

    public String getContent() {
        return content;
    }

    public void setMarkDown(String markDown) {
        this.markDown = markDown;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}