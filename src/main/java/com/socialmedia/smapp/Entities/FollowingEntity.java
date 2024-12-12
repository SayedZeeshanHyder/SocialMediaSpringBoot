package com.socialmedia.smapp.Entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "followings")
@Entity
public class FollowingEntity {

    @Id
    private int id;
    private String followingImageUrl;
    private String followingUserName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFollowingImageUrl() {
        return followingImageUrl;
    }

    public void setFollowingImageUrl(String followingImageUrl) {
        this.followingImageUrl = followingImageUrl;
    }

    public String getFollowingUserName() {
        return followingUserName;
    }

    public void setFollowingUserName(String followingUserName) {
        this.followingUserName = followingUserName;
    }
}
