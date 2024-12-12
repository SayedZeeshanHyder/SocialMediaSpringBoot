package com.socialmedia.smapp.Repository;

import com.socialmedia.smapp.Entities.FollowerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowerRepository extends JpaRepository<FollowerEntity,Integer> {
}
