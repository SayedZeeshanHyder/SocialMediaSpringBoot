package com.socialmedia.smapp.Controller;

import com.socialmedia.smapp.Entities.FollowingEntity;
import com.socialmedia.smapp.Entities.PostEntity;
import com.socialmedia.smapp.Entities.UserEntity;
import com.socialmedia.smapp.Service.PostEntityService;
import com.socialmedia.smapp.Service.UserEntityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequestMapping("user")
@RestController
public class UserEntityController {

    private UserEntityService userEntityService;
    private PostEntityService postEntityService;

    UserEntityController(UserEntityService userEntityService, PostEntityService postEntityService) {
        this.userEntityService = userEntityService;
        this.postEntityService = postEntityService;
    }

    @PostMapping
    public ResponseEntity<UserEntity> saveUser(@RequestBody UserEntity userEntity) {
        UserEntity savedUserEntity = userEntityService.saveUser(userEntity);
        if (savedUserEntity != null) {
            return ResponseEntity.ok(savedUserEntity);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("{userid}")
    public ResponseEntity<UserEntity> getUserEntity(@PathVariable("userid") int userid) {
        UserEntity foundUser = userEntityService.getUserEntityById(userid);
        if (foundUser != null) {
            return ResponseEntity.ok(foundUser);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("{userId}/post")
    public ResponseEntity<UserEntity> postUserEntity(@PathVariable("userId") int userid, @RequestBody PostEntity postEntity) {
        PostEntity savedPost = postEntityService.createPost(postEntity);
        UserEntity foundUser = userEntityService.getUserEntityById(userid);
        if (foundUser != null) {
            UserEntity postedUser = userEntityService.createPost(savedPost, foundUser);
            return ResponseEntity.ok(postedUser);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("{userId}/follow")
    public ResponseEntity<UserEntity> followUser(@PathVariable Integer userId, @RequestBody FollowingEntity followingEntity){
        UserEntity foundUser = userEntityService.getUserEntityById(userId);
        userEntityService.performFollowOperation(foundUser, followingEntity);
        return ResponseEntity.ok(foundUser);
    }

}
