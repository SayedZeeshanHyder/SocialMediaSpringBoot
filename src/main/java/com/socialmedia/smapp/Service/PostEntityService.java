package com.socialmedia.smapp.Service;

import com.socialmedia.smapp.Entities.CommentEntity;
import com.socialmedia.smapp.Entities.PostEntity;
import com.socialmedia.smapp.Repository.PostEntityRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class PostEntityService {

    private PostEntityRepository postEntityRepository;
    private CloudinaryService cloudinaryService;

    PostEntityService(PostEntityRepository postEntityRepository, CloudinaryService cloudinaryService) {
        this.postEntityRepository = postEntityRepository;
        this.cloudinaryService = cloudinaryService;
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

    public PostEntity convertFileToUrl(String title,String content,String contentType, MultipartFile file) throws IOException {
        PostEntity post = new PostEntity();
        post.setTitle(title);
        post.setContentType(contentType);
        String imageUrl = cloudinaryService.uploadImage(file);
        post.setContent(imageUrl);
        return post;
    }

}
