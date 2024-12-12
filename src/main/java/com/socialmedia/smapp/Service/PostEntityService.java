package com.socialmedia.smapp.Service;

import com.socialmedia.smapp.Entities.CommentEntity;
import com.socialmedia.smapp.Entities.PostEntity;
import com.socialmedia.smapp.Repository.PostEntityRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostEntityService {

    private PostEntityRepository postEntityRepository;

    PostEntityService(PostEntityRepository postEntityRepository) {
        this.postEntityRepository = postEntityRepository;
    }

    public PostEntity createPost(PostEntity postEntity) {
        return postEntityRepository.save(postEntity);
    }

    public PostEntity getPostById(int postId){
        return postEntityRepository.findById(postId).orElse(null);
    }

    public PostEntity commentOnPost(CommentEntity comment,PostEntity post) {
        post.addComment(comment);
        return postEntityRepository.save(post);
    }

    public List<PostEntity> getAllPosts(){
        return postEntityRepository.findAll();
    }

}
