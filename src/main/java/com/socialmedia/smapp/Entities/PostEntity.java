package com.socialmedia.smapp.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "posts")
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class PostEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String content;
    private String contentType;
    private LocalDateTime postedAt = LocalDateTime.now();

    @ManyToMany
    @JoinTable(
            name = "post_comment",
            joinColumns = @JoinColumn(name = "posts"),
            inverseJoinColumns = @JoinColumn(name = "comments")
    )
    private List<CommentEntity> comments;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getContentType() {
        return contentType;
    }

    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    public LocalDateTime getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(LocalDateTime postedAt) {
        this.postedAt = postedAt;
    }

    public List<CommentEntity> getComments() {
        return comments;
    }

    public void setComments(List<CommentEntity> comments) {
        this.comments = comments;
    }

    public void addComment(CommentEntity comment) {
        this.comments.add(comment);
    }

    public void removeComment(CommentEntity comment) {
        this.comments.remove(comment);
    }
}
