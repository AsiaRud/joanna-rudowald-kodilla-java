package com.kodilla.stream.forumuser;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public final class Forum {

    private final List<ForumUser> theUserList = new ArrayList<>();

    public Forum() {
        theUserList.add(new ForumUser(1, "Ala", 'F', LocalDate.of(1993, 5, 21), 41));
        theUserList.add(new ForumUser(2, "Adam", 'M', LocalDate.of(2004, 12, 1), 0));
        theUserList.add(new ForumUser(3, "Pawel", 'M', LocalDate.of(2010, 3, 9), 105));
        theUserList.add(new ForumUser(4, "Gosia", 'F', LocalDate.of(2001, 6, 13), 3));
        theUserList.add(new ForumUser(5, "Agata", 'F', LocalDate.of(1997, 7, 5), 0));
        theUserList.add(new ForumUser(6, "Dawid", 'M', LocalDate.of(2005, 10, 18), 20));
        theUserList.add(new ForumUser(7, "Sebastian", 'M', LocalDate.of(2004, 1, 30), 81));
        theUserList.add(new ForumUser(8, "Robert", 'M', LocalDate.of(1999, 2, 28), 15));
        theUserList.add(new ForumUser(9, " Maria", 'F', LocalDate.of(2003, 11, 20), 102));
        theUserList.add(new ForumUser(10, " Patrycja", 'F', LocalDate.of(1981, 06, 10), 0));
        theUserList.add(new ForumUser(11, " Aneta", 'F', LocalDate.of(2003, 11, 20), 102));
        theUserList.add(new ForumUser(12, " Michal", 'M', LocalDate.of(2005, 4, 17), 30));
        theUserList.add(new ForumUser(13, " Lukas", 'M', LocalDate.of(1990, 11, 11), 102));
        theUserList.add(new ForumUser(14, " Tomek", 'M', LocalDate.of(2003, 1, 6), 1));
        theUserList.add(new ForumUser(15, " Dorota", 'F', LocalDate.of(2010, 9, 20), 80));
    }



    public List<ForumUser> getUserList() {
        return new ArrayList<>(theUserList);
    }


}
