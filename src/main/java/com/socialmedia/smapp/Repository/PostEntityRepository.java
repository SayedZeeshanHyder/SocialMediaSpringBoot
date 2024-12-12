package com.socialmedia.smapp.Repository;

import com.socialmedia.smapp.Entities.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostEntityRepository extends JpaRepository<PostEntity,Integer> {
}
