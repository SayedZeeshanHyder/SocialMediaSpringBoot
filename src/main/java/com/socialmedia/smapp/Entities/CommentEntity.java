package com.socialmedia.smapp.Entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Table(name = "comments")
@Entity
public class CommentEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String commentBy;
    private String commentText;
    private int likes;
    private String commenterImageUrl;
    private LocalDateTime commentTime = LocalDateTime.now();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCommentBy() {
        return commentBy;
    }

    public void setCommentBy(String commentBy) {
        this.commentBy = commentBy;
    }

    public String getCommentText() {
        return commentText;
    }

    public void setCommentText(String commentText) {
        this.commentText = commentText;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public String getCommenterImageUrl() {
        return commenterImageUrl;
    }

    public void setCommenterImageUrl(String commenterImageUrl) {
        this.commenterImageUrl = commenterImageUrl;
    }

    public LocalDateTime getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(LocalDateTime commentTime) {
        this.commentTime = commentTime;
    }
}
