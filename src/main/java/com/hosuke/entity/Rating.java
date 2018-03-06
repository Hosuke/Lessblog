package com.hosuke.entity;

public abstract class Rating {

    public static final short LIKE_VALUE = 1;
    public static final short DISLIKE_VALUE = -1;

    protected User user;

    protected short value;

    public Rating(User user, short value) {
        this.user = user;
        this.value = value;
    }

    public Rating() {

    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public short getValue() {
        return value;
    }

    public void setValue(short value) {
        this.value = value;
    }
}
