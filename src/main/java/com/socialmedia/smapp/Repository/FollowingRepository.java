package com.socialmedia.smapp.Repository;

import com.socialmedia.smapp.Entities.FollowingEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowingRepository extends JpaRepository<FollowingEntity,Integer> {
}
