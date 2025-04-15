package com.kodilla.testing.library;

import java.util.Objects;

public class LibraryUser {
    private String firstName;
    private String lastName;
    private String peselID;

    public LibraryUser(String firstName, String peselID, String lastName) {
        this.firstName = firstName;
        this.peselID = peselID;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getPeselID() {
        return peselID;
    }

    public void setPeselID(String peselID) {
        this.peselID = peselID;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return
                false;
        LibraryUser that = (LibraryUser) o;
        return Objects.equals(firstName, that.firstName) &&
                Objects.equals(lastName, that.lastName) &&
                Objects.equals(peselID, that.peselID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, peselID);
    }
}
