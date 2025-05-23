package com.kodilla.stream;

import com.kodilla.stream.book.Book;
import com.kodilla.stream.book.BookDirectory;
import com.kodilla.stream.forumuser.Forum;
import com.kodilla.stream.forumuser.ForumUser;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamMain {

    public static void main(String[] args) {

        Forum forum = new Forum();

        Map<Integer, ForumUser> mapOfMaleForumUsersWithCondition = forum.getUserList().stream()
                .filter(forumUser -> forumUser.getUserGender() == 'M')
                .filter(forumUser -> forumUser.getUserBirthday().isBefore(LocalDate.now().minusYears(20)))
                .filter(forumUser -> forumUser.getPostsCount() >= 1)
                .collect(Collectors.toMap(ForumUser::getUserID, forumUser -> forumUser));

        mapOfMaleForumUsersWithCondition.entrySet().stream()
                .map(entry -> entry.getKey() + ": " + entry.getValue())
                .forEach(System.out::println);

    }
}