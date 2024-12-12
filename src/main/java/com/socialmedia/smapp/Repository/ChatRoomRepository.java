package com.socialmedia.smapp.Repository;

import com.socialmedia.smapp.Entities.ChatRoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatRoomRepository extends JpaRepository<ChatRoomEntity,Integer> {
}
