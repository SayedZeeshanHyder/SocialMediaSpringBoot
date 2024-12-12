package com.socialmedia.smapp.Service;

import com.socialmedia.smapp.Entities.FollowerEntity;
import com.socialmedia.smapp.Entities.FollowingEntity;
import com.socialmedia.smapp.Repository.FollowerRepository;
import com.socialmedia.smapp.Repository.FollowingRepository;
import org.springframework.stereotype.Service;

@Service
public class FollowerFollowingService {

    private FollowerRepository followerRepository;
    private FollowingRepository followingRepository;

    FollowerFollowingService(FollowerRepository followerRepository, FollowingRepository followingRepository) {
        this.followerRepository = followerRepository;
        this.followingRepository = followingRepository;
    }

    public FollowerEntity saveFollower(FollowerEntity followerEntity) {
        return followerRepository.save(followerEntity);
    }

    public FollowingEntity saveFollowing(FollowingEntity followingEntity) {
        return followingRepository.save(followingEntity);
    }

    public FollowerEntity getFollowerById(Integer followerId) {
        return followerRepository.findById(followerId).orElse(null);
    }

    public FollowingEntity getFollowingById(Integer followingId) {
        return followingRepository.findById(followingId).orElse(null);
    }

}
