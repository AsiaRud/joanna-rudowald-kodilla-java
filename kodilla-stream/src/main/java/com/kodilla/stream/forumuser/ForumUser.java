package com.kodilla.stream.forumuser;

import java.time.LocalDate;

public final class ForumUser {

    private final int userID;
    private final String userName;
    private final char userGender;
    private final LocalDate userBirthday;
    private final int postsCount;

    public ForumUser(int userID, String userName, char userGender, LocalDate userBirthday, int postsCount) {
        this.userID = userID;
        this.userName = userName;
        this.userGender = userGender;
        this.userBirthday = userBirthday;
        this.postsCount = postsCount;
    }

    public int getUserID() {
        return userID;
    }

    public String getUserName() {
        return userName;
    }

    public char getUserGender() {
        return userGender;
    }

    public LocalDate getUserBirthday() {
        return userBirthday;
    }

    public int getPostsCount() {
        return postsCount;
    }

    @Override
    public String toString() {
        return "ForumUser{" +
                "userID=" + userID +
                ", userName='" + userName + '\'' +
                ", userGender=" + userGender +
                ", userBirthday=" + userBirthday +
                ", postsCount=" + postsCount +
                '}';
    }
}
