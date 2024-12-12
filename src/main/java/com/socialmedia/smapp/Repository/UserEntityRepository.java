package com.socialmedia.smapp.Repository;

import com.socialmedia.smapp.Entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityRepository extends JpaRepository<UserEntity,Integer> {
}
