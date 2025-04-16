package com.kodilla.testing.forum.statistics;

public class ForumStatistics {
    private int usersCount;
    private int numberOfPosts;
    private int numberOfComments;
    private double averagePostsPerUser;
    private double averageCommentsPerUser;
    private double averageCommentsPerPost;

    public Statistics calculateAdvStatistics(Statistics statistics) {
        usersCount = statistics.userNames().size();
        numberOfPosts = statistics.postCount();
        numberOfComments = statistics.commentsCount();
        averageCommentsPerUser = usersCount > 0 ? numberOfComments / (double) usersCount : 0;
        averagePostsPerUser = usersCount > 0 ? numberOfPosts / (double) usersCount : 0;
        averageCommentsPerPost = numberOfPosts > 0 ? numberOfComments / (double) numberOfPosts : 0;

        return statistics;
    }

    public String showStatistics() {
        StringBuilder statistics = new StringBuilder();
        statistics.append("Users Count: " + usersCount + "\n");
        statistics.append("Posts Count: " + numberOfPosts + "\n");
        statistics.append("Comments Count: " + numberOfComments + "\n");
        statistics.append("Posts Per User: " + averagePostsPerUser + "\n");
        statistics.append("Comments Per User: " + averageCommentsPerUser + "\n");
        statistics.append("Comments Per Post: " + averageCommentsPerPost + "\n");
        return statistics.toString();
    }


    public int getUsersCount() {
        return usersCount;
    }

    public int getNumberOfPosts() {
        return numberOfPosts;
    }

    public double getAveragePostsPerUser() {
        return averagePostsPerUser;
    }

    public int getNumberOfComments() {
        return numberOfComments;
    }

    public double getAverageCommentsPerUser() {
        return averageCommentsPerUser;
    }


    public double getAverageCommentsPerPost() {
        return averageCommentsPerPost;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof ForumStatistics that)) return false;

        return usersCount == that.usersCount && numberOfPosts == that.numberOfPosts && numberOfComments == that.numberOfComments && Double.compare(averagePostsPerUser, that.averagePostsPerUser) == 0 && Double.compare(averageCommentsPerUser, that.averageCommentsPerUser) == 0 && Double.compare(averageCommentsPerPost, that.averageCommentsPerPost) == 0;
    }

    @Override
    public int hashCode() {
        int result = usersCount;
        result = 31 * result + numberOfPosts;
        result = 31 * result + numberOfComments;
        result = 31 * result + Double.hashCode(averagePostsPerUser);
        result = 31 * result + Double.hashCode(averageCommentsPerUser);
        result = 31 * result + Double.hashCode(averageCommentsPerPost);
        return result;
    }
}
