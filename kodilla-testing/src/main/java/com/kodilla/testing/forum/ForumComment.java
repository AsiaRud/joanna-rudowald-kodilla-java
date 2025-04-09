package com.kodilla.testing.forum;

public class ForumComment {
    private ForumPost forumPost;
    private String commentBody;
    private String author;

    public ForumComment(ForumPost forumPost, String commentBody, String author) {
        this.forumPost = forumPost;
        this.commentBody = commentBody;
        this.author = author;
    }

    public ForumPost getForumPost() {
        return forumPost;
    }

    public String getAuthor() {
        return author;
    }

    public String getCommentBody() {
        return commentBody;
    }

    @Override
    public final boolean equals(Object o) {
        if (!(o instanceof ForumComment that)) return false;

        ForumComment thatComment = (ForumComment) o;

        if (!commentBody.equals(thatComment.commentBody)) return false;
        if (!forumPost.equals(thatComment.forumPost)) return false;
        return author.equals(thatComment.author);
    }

    @Override
    public int hashCode() {
        int result = forumPost.hashCode();
        result = 31 * result + commentBody.hashCode();
        result = 31 * result + author.hashCode();
        return result;
    }
}
