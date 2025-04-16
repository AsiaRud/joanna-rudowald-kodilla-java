package com.kodilla.testing.forum.statistics;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class ForumStatisticsTestSuite {

    private ForumStatistics forumStatistics;

    @Mock
    private Statistics statisticsMock;

    @BeforeEach
    void setUp() {
        forumStatistics = new ForumStatistics();
    }

    @Test
    public void testCalculateAdvStatistics(){
        //Given
        List<String>usersList = List.of("user1", "user2", "user3", "user4", "user5", "user6");
        when(statisticsMock.userNames()).thenReturn(usersList);
        when(statisticsMock.commentsCount()).thenReturn(3);
        when(statisticsMock.postCount()).thenReturn(12);

        //When
        Statistics statistics = forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(6, forumStatistics.getUsersCount());
        assertEquals(3, forumStatistics.getNumberOfComments());
        assertEquals(12, forumStatistics.getNumberOfPosts());
        assertEquals(0.5, forumStatistics.getAverageCommentsPerUser(), 0.01);
        assertEquals(2, forumStatistics.getAveragePostsPerUser(), 0.01);
        assertEquals(0.25, forumStatistics.getAverageCommentsPerPost(), 0.01);

        verify(statisticsMock, times(1)).userNames();
        verify(statisticsMock, times(1)).commentsCount();
        verify(statisticsMock, times(1)).postCount();
    }

    @Test
    public void testCalculateAdvStatisticsWhen0Posts() {
        //Given
        List<String>usersList = List.of("user1", "user2", "user3", "user4", "user5", "user6");
        when(statisticsMock.userNames()).thenReturn(usersList);
        when(statisticsMock.commentsCount()).thenReturn(3);
        when(statisticsMock.postCount()).thenReturn(0);

        //When
        Statistics statistics = forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(6, forumStatistics.getUsersCount());
        assertEquals(3, forumStatistics.getNumberOfComments());
        assertEquals(0, forumStatistics.getNumberOfPosts());
        assertEquals(0.5, forumStatistics.getAverageCommentsPerUser(), 0.01);
        assertEquals(0, forumStatistics.getAveragePostsPerUser(), 0.01);
        assertEquals(0, forumStatistics.getAverageCommentsPerPost(), 0.01);

        verify(statisticsMock, times(1)).userNames();
        verify(statisticsMock, times(1)).commentsCount();
        verify(statisticsMock, times(1)).postCount();
    }

    @Test
    public void testCalculateAdvStatisticsWhen1000Posts() {
        //Given
        List<String>usersList = List.of("user1", "user2", "user3", "user4", "user5");
        when(statisticsMock.userNames()).thenReturn(usersList);
        when(statisticsMock.commentsCount()).thenReturn(10);
        when(statisticsMock.postCount()).thenReturn(1000);

        //When
        Statistics statistics = forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(5, forumStatistics.getUsersCount());
        assertEquals(10, forumStatistics.getNumberOfComments());
        assertEquals(1000, forumStatistics.getNumberOfPosts());
        assertEquals(2, forumStatistics.getAverageCommentsPerUser(), 0.01);
        assertEquals(200, forumStatistics.getAveragePostsPerUser(), 0.01);
        assertEquals(0.01, forumStatistics.getAverageCommentsPerPost(), 0.01);

        verify(statisticsMock, times(1)).userNames();
        verify(statisticsMock, times(1)).commentsCount();
        verify(statisticsMock, times(1)).postCount();
    }

    @Test
    public void testCalculateAdvStatisticsWhen0Comments() {
        //Given
        List<String>usersList = List.of("user1", "user2", "user3", "user4", "user5");
        when(statisticsMock.userNames()).thenReturn(usersList);
        when(statisticsMock.commentsCount()).thenReturn(0);
        when(statisticsMock.postCount()).thenReturn(0);

        //When
        Statistics statistics = forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(5, forumStatistics.getUsersCount());
        assertEquals(0, forumStatistics.getNumberOfComments());
        assertEquals(0, forumStatistics.getNumberOfPosts());
        assertEquals(0, forumStatistics.getAverageCommentsPerUser(), 0.01);
        assertEquals(0, forumStatistics.getAveragePostsPerUser(), 0.01);
        assertEquals(0, forumStatistics.getAverageCommentsPerPost(), 0.01);

        verify(statisticsMock, times(1)).userNames();
        verify(statisticsMock, times(1)).commentsCount();
        verify(statisticsMock, times(1)).postCount();
    }

    @Test
    public void testCalculateAdvStatisticsWhenPostsMoreThanComments() {
        //Given
        List<String>usersList = List.of("user1", "user2", "user3", "user4", "user5", "user6", "user7", "user8");
        when(statisticsMock.userNames()).thenReturn(usersList);
        when(statisticsMock.commentsCount()).thenReturn(16);
        when(statisticsMock.postCount()).thenReturn(80);

        //When
        Statistics statistics = forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(8, forumStatistics.getUsersCount());
        assertEquals(16, forumStatistics.getNumberOfComments());
        assertEquals(80, forumStatistics.getNumberOfPosts());
        assertEquals(2, forumStatistics.getAverageCommentsPerUser(), 0.01);
        assertEquals(10, forumStatistics.getAveragePostsPerUser(), 0.01);
        assertEquals(0.2, forumStatistics.getAverageCommentsPerPost(), 0.01);

        verify(statisticsMock, times(1)).userNames();
        verify(statisticsMock, times(1)).commentsCount();
        verify(statisticsMock, times(1)).postCount();
    }

    @Test
    public void testCalculateAdvStatisticsWhenPostsLessThanComments() {
        //Given
        List<String>usersList = List.of("user1", "user2", "user3");
        when(statisticsMock.userNames()).thenReturn(usersList);
        when(statisticsMock.commentsCount()).thenReturn(54);
        when(statisticsMock.postCount()).thenReturn(17);

        //When
        Statistics statistics = forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(3, forumStatistics.getUsersCount());
        assertEquals(54, forumStatistics.getNumberOfComments());
        assertEquals(17, forumStatistics.getNumberOfPosts());
        assertEquals(18, forumStatistics.getAverageCommentsPerUser(), 0.01);
        assertEquals(5.66, forumStatistics.getAveragePostsPerUser(),0.01);
        assertEquals(3.17, forumStatistics.getAverageCommentsPerPost(),0.01);

        verify(statisticsMock, times(1)).userNames();
        verify(statisticsMock, times(1)).commentsCount();
        verify(statisticsMock, times(1)).postCount();
    }

    @Test
    public void testCalculateAdvStatisticsWhen0Users() {
        //Given
        when(statisticsMock.userNames()).thenReturn(new ArrayList<>());
        when(statisticsMock.commentsCount()).thenReturn(13);
        when(statisticsMock.postCount()).thenReturn(87);

        //When
        Statistics statistics = forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(0, forumStatistics.getUsersCount());
        assertEquals(13, forumStatistics.getNumberOfComments());
        assertEquals(87, forumStatistics.getNumberOfPosts());
        assertEquals(0, forumStatistics.getAverageCommentsPerUser(), 0.01);
        assertEquals(0, forumStatistics.getAveragePostsPerUser(), 0.01);
        assertEquals(0.14, forumStatistics.getAverageCommentsPerPost(),0.01);

        verify(statisticsMock, times(1)).userNames();
        verify(statisticsMock, times(1)).commentsCount();
        verify(statisticsMock, times(1)).postCount();
    }

    @Test
    public void testCalculateAdvStatisticsWhen100Users() {
        //Given
        List<String>usersList = new ArrayList<>();
        for (int i = 1; i <= 100; i++) {
            usersList.add("user" + i);
        }
        when(statisticsMock.userNames()).thenReturn(usersList);
        when(statisticsMock.commentsCount()).thenReturn(13);
        when(statisticsMock.postCount()).thenReturn(87);

        //When
        Statistics statistics = forumStatistics.calculateAdvStatistics(statisticsMock);

        //Then
        assertEquals(100, forumStatistics.getUsersCount());
        assertEquals(13, forumStatistics.getNumberOfComments());
        assertEquals(87, forumStatistics.getNumberOfPosts());
        assertEquals(0.13, forumStatistics.getAverageCommentsPerUser(), 0.01);
        assertEquals(0.87, forumStatistics.getAveragePostsPerUser(), 0.01);
        assertEquals(0.14, forumStatistics.getAverageCommentsPerPost(),0.01);

        verify(statisticsMock, times(1)).userNames();
        verify(statisticsMock, times(1)).commentsCount();
        verify(statisticsMock, times(1)).postCount();
    }
}
