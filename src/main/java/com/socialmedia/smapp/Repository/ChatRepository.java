package com.socialmedia.smapp.Repository;

import com.socialmedia.smapp.Entities.ChatEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRepository extends JpaRepository<ChatEntity,Integer> {
}
