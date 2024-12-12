package com.socialmedia.smapp.Service;

import com.socialmedia.smapp.Entities.CommentEntity;
import com.socialmedia.smapp.Repository.CommentEntityRepository;
import org.springframework.stereotype.Service;

@Service
public class CommentEntityService {

    private CommentEntityRepository commentEntityRepository;

    CommentEntityService(CommentEntityRepository commentEntityRepository) {
        this.commentEntityRepository = commentEntityRepository;
    }

    public CommentEntity saveComment(CommentEntity commentEntity) {
        return commentEntityRepository.save(commentEntity);
    }

}
