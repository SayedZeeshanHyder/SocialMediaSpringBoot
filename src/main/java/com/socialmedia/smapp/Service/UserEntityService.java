package com.socialmedia.smapp.Service;

import com.socialmedia.smapp.Entities.*;
import com.socialmedia.smapp.Repository.UserEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class UserEntityService {

    private UserEntityRepository userEntityRepository;
    private FollowerFollowingService followerFollowingService;

    UserEntityService(UserEntityRepository userEntityRepository,FollowerFollowingService followerFollowingService) {
        this.userEntityRepository = userEntityRepository;
        this.followerFollowingService = followerFollowingService;
    }

    //Creates a New User
    public UserEntity saveUser(UserEntity userEntity) {
        return userEntityRepository.save(userEntity);
    }

    //Get User By Id
    public UserEntity getUserEntityById(int id) {
        return userEntityRepository.findById(id).orElse(null);
    }


    //Creates a Post by User
    public UserEntity createPost(PostEntity postEntity,UserEntity userEntity) {
        userEntity.createPost(postEntity);
        return saveUser(userEntity);
    }



    public void performFollowOperation(UserEntity user1, FollowingEntity toBeFollowed) {
        // Get Already Present Following
        FollowingEntity getFollowingEntity = followerFollowingService.getFollowingById(toBeFollowed.getId());

        if (getFollowingEntity == null) {
            // Save Following Entity if Not Present
            System.out.println("Created New Following Entity");
            getFollowingEntity = followerFollowingService.saveFollowing(toBeFollowed);
        }

        System.out.println("User1 Id got = " + user1.getId());
        System.out.println("Following Id got = " + getFollowingEntity.getId());

        // Process of User1 adding User2 in its following List
        user1.addToFollowing(getFollowingEntity);
        System.out.println("Added Following one element " + user1.getFollowings());

        // Getting the person who is being followed
        UserEntity user2 = getUserEntityById(getFollowingEntity.getId());

        // Maps the UserEntity to Follower Entity
        FollowerEntity followerEntity = new FollowerEntity();
        followerEntity.setFollowingImageUrl(user1.getImageurl());
        followerEntity.setFollowingUserName(user1.getUsername());
        followerEntity.setId(user1.getId());

        FollowerEntity getFollowerEntity = followerFollowingService.getFollowerById(followerEntity.getId());
        if (getFollowerEntity == null) {
            System.out.println("Created New Follower Entity");
            getFollowerEntity = followerFollowingService.saveFollower(followerEntity);
        }

        System.out.println("User2 got = " + user2.getId());
        System.out.println("Follower Id got = " + getFollowerEntity.getId());

        // Process of User1 adding User1 in its followers List
        user2.addToFollower(getFollowerEntity);
        System.out.println("Added Follower one element " + user2.getFollowers());
        System.out.println("User has follower as " + user2.toString());

        userEntityRepository.save(user2);
    }






    public void addChatRoomToUser(UserEntity user, ChatRoomEntity chatRoom){
        user.addChatRoom(chatRoom);
        saveUser(user);
    }

}
