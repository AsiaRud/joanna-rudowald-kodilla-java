package com.kodilla.testing.library;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BookDirectoryTestSuite {

    private List<Book> generateListOfNBooks(int booksQuantity) {
        List<Book> resultList = new ArrayList<>();
        for (int n = 0; n < booksQuantity; n++) {
            Book theBook = new Book("Title" + n, "Author" + n, 1970 + n);
            resultList.add(theBook);
        }
        return resultList;
    }

    @Mock
    private LibraryDatabase libraryDatabaseMock;
    private BookLibrary bookLibrary;
    private LibraryUser testUser;

    @BeforeEach
    void setUp() {
        bookLibrary = new BookLibrary(libraryDatabaseMock);
        testUser = new LibraryUser("Jane", "12345678901", "Doe");
    }


    @Test
    public void testListBooksWithConditionsReturnList() {

        //Given
        List<Book> resultListOfBooks = List.of(
                new Book("Secrets of Alamo", "John Smith", 2008),
                new Book("Secretaries and Directors", "Dilbert Michigan", 2012),
                new Book("Secret life of programmers", "Steve Wolkowitz", 2016),
                new Book("Secrets of Java", "Ian Tenewitch", 2010)
        );

        when(libraryDatabaseMock.listBooksWithCondition("Secret")).thenReturn(resultListOfBooks);

        //When
        List<Book> theListOfBooks = bookLibrary.listBooksWithCondition("Secret");

        //Then
        assertEquals(4, theListOfBooks.size());
    }

    @Test
    public void testListBooksWithConditionMoreThan20() {

        //Given
        List<Book> resultListOf0Books = new ArrayList<>();
        List<Book> resultListOf15Books = generateListOfNBooks(15);
        List<Book> resultListOf40Books = generateListOfNBooks(40);

        when(libraryDatabaseMock.listBooksWithCondition(anyString())).thenReturn(resultListOf15Books);
        when(libraryDatabaseMock.listBooksWithCondition("ZeroBooks")).thenReturn(resultListOf0Books);
        when(libraryDatabaseMock.listBooksWithCondition("FortyBooks")).thenReturn(resultListOf40Books);

        //When
        List<Book> theListOfBooks0 = bookLibrary.listBooksWithCondition("ZeroBooks");
        List<Book> theListOfBooks15 = bookLibrary.listBooksWithCondition("Any title");
        List<Book> theListOfBooks40 = bookLibrary.listBooksWithCondition("FortyBooks");

        //Then
        assertEquals(0, theListOfBooks0.size());
        assertEquals(15, theListOfBooks15.size());
        assertEquals(0, theListOfBooks40.size());

    }

    @Test
    public void testListBooksWithConditionFragmentShorterThan3() {

        //When
        List<Book> theListOfBooks10 = bookLibrary.listBooksWithCondition("An");

        //Then
        assertEquals(0, theListOfBooks10.size());
        verify(libraryDatabaseMock, times(0)).listBooksWithCondition(anyString());
    }

    @Test
    public void listBooksInHandsOfUserWith0Books() {

        //Given
        when(libraryDatabaseMock.listBooksInHandsOf(testUser)).thenReturn(new ArrayList<>());

        //When
        List<Book> books = bookLibrary.listBooksInHandsOf(testUser);

        //then
        assertEquals(0, books.size());
        verify(libraryDatabaseMock, times(1)).listBooksInHandsOf(testUser);

    }

    @Test
    public void listBooksInHandsOfUserWith1Book() {

        //Given
        List<Book> listWith1Book = List.of(new Book("Secrets of Alamo", "John Smith", 2008));

        when(libraryDatabaseMock.listBooksInHandsOf(testUser)).thenReturn(listWith1Book);

        //When
        List<Book> resultList = bookLibrary.listBooksInHandsOf(testUser);

        //Then
        assertEquals(1, resultList.size());
        assertEquals("Secrets of Alamo", resultList.get(0).getTitle());
        assertEquals("John Smith", resultList.get(0).getAuthor());
        assertEquals(2008, resultList.get(0).getPublicationYear());

        verify(libraryDatabaseMock, times(1)).listBooksInHandsOf(testUser);
    }

    @Test
    public void listBooksInHandsOfUserWith5Books() {

        //Given
        List<Book> listWith5Books = List.of(
                new Book("Secrets of Alamo", "John Smith", 2008),
                new Book("Secretaries and Directors", "Dilbert Michigan", 2012),
                new Book("Secret life of programmers", "Steve Wolkowitz", 2016),
                new Book ("Secrets of Java", "Ian Tenewitch", 2010),
                new Book("Thinking in Java", "Bruce Eckel", 2006)
        );
        when(libraryDatabaseMock.listBooksInHandsOf(testUser)).thenReturn(listWith5Books);

        //When
        List<Book> resultList = bookLibrary.listBooksInHandsOf(testUser);

        //Then
        assertEquals(5, resultList.size());
        assertEquals("Secrets of Alamo", resultList.get(0).getTitle());
        assertEquals("Steve Wolkowitz", resultList.get(2).getAuthor());
        assertEquals(2006, resultList.get(4).getPublicationYear());
        verify(libraryDatabaseMock, times(1)).listBooksInHandsOf(testUser);

    }
}
