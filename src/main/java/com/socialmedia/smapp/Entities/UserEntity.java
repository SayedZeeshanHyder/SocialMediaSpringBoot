package com.socialmedia.smapp.Entities;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String username;
    private String password;
    private String email;
    private String imageurl;
    private LocalDateTime createdAt = LocalDateTime.now();
    private boolean isVerified = false;

    public void verifyUser() {
        this.isVerified = true;
    }

    @ManyToMany
    @JoinTable(
            name = "user_post",
            joinColumns = @JoinColumn(name = "users_id"),
            inverseJoinColumns = @JoinColumn(name = "posts_id")
    )
    private List<PostEntity> posts;

    @ManyToMany
    @JoinTable(
            name = "user_following",
            joinColumns = @JoinColumn(name = "users_id"),
            inverseJoinColumns = @JoinColumn(name = "followings_id")
    )
    private List<FollowingEntity> followings;

    @ManyToMany
    @JoinTable(
            name = "user_follower",
            joinColumns = @JoinColumn(name = "users_id"),
            inverseJoinColumns = @JoinColumn(name = "followers_id")
    )
    private List<FollowerEntity> followers;

    @ManyToMany
    @JoinTable(
            name = "user_chatrooms",
            joinColumns = @JoinColumn(name = "users_id"),
            inverseJoinColumns = @JoinColumn(name = "chatrooms_id")
    )
    private List<ChatRoomEntity> chatrooms;

    public void createPost(PostEntity post) {
        this.posts.add(post);
    }

    public void deletePost(PostEntity post) {
        this.posts.remove(post);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImageurl() {
        return imageurl;
    }

    public void setImageurl(String imageurl) {
        this.imageurl = imageurl;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public boolean isVerified() {
        return isVerified;
    }

    public void setVerified(boolean verified) {
        isVerified = verified;
    }

    public List<PostEntity> getPosts() {
        return posts;
    }

    public void setPosts(List<PostEntity> posts) {
        this.posts = posts;
    }

    public List<FollowingEntity> getFollowings() {
        return followings;
    }

    public void addToFollowing(FollowingEntity following) {
        for (FollowingEntity followingEntity : this.followings) {
            if (following.getId() == followingEntity.getId()) {
                return;
            }
        }
        this.followings.add(following);
    }

    public void removeFromFollowing(FollowingEntity following) {
        this.followings.remove(following);
    }

    public void addToFollower(FollowerEntity follower) {
        for (FollowerEntity followerEntity : this.followers) {
            if (follower.getId() == followerEntity.getId()) {
                return;
            }
        }
        this.followers.add(follower);
        System.out.println("Added to follower with follower id : " + follower.getId());
    }

    public void removeFromFollower(FollowerEntity follower) {
        this.followers.remove(follower);
    }

    public List<FollowerEntity> getFollowers() {
        return followers;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", imageurl='" + imageurl + '\'' +
                ", createdAt=" + createdAt +
                ", isVerified=" + isVerified +
                ", posts=" + posts +
                ", followings=" + followings +
                ", followers=" + followers +
                '}';
    }

    public List<ChatRoomEntity> getChatrooms() {
        return chatrooms;
    }

    public void addChatRoom(ChatRoomEntity chatRoom){
        this.chatrooms.add(chatRoom);

    }
}
