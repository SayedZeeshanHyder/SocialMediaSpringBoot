package com.socialmedia.smapp.Controller;

import com.socialmedia.smapp.Entities.CommentEntity;
import com.socialmedia.smapp.Entities.PostEntity;
import com.socialmedia.smapp.Service.CommentEntityService;
import com.socialmedia.smapp.Service.PostEntityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RequestMapping("post")
@RestController
public class PostController {

    private CommentEntityService commentEntityService;
    private PostEntityService postEntityService;

    PostController(CommentEntityService commentEntityService, PostEntityService postEntityService) {
        this.commentEntityService = commentEntityService;
        this.postEntityService = postEntityService;
    }

    @PostMapping("{postId}/comment")
    public ResponseEntity<PostEntity> addComment(@PathVariable int postId, @RequestBody CommentEntity comment) {
        PostEntity post = postEntityService.getPostById(postId);
        CommentEntity savedComment = commentEntityService.saveComment(comment);
        if(post != null){
            postEntityService.commentOnPost(savedComment, post);
            return ResponseEntity.ok(post);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("{postId}")
    public ResponseEntity<PostEntity> getPostById(@PathVariable int postId) {
        PostEntity post = postEntityService.getPostById(postId);
        if (post != null) {
            return ResponseEntity.ok(post);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<List<PostEntity>> getAllPosts(){
        List<PostEntity> allPosts = postEntityService.getAllPosts();
        if (allPosts != null){
            return ResponseEntity.ok(allPosts);
        }
        return ResponseEntity.notFound().build();
    }

}
