package com.socialmedia.smapp.Service;
import com.socialmedia.smapp.Entities.ChatRoomEntity;
import com.socialmedia.smapp.Entities.UserEntity;
import com.socialmedia.smapp.Repository.ChatRoomRepository;
import org.springframework.stereotype.Service;

@Service
public class ChatRoomService {

    private UserEntityService userEntityService;
    private ChatRoomRepository chatRoomRepository;

    ChatRoomService(UserEntityService userEntityService,ChatRoomRepository chatRoomRepository){
        this.chatRoomRepository = chatRoomRepository;
        this.userEntityService = userEntityService;
    }

    public ChatRoomEntity createRoom(ChatRoomEntity chatRoomEntity){
        UserEntity user1 = userEntityService.getUserEntityById(chatRoomEntity.getUserid1());
        UserEntity user2 = userEntityService.getUserEntityById(chatRoomEntity.getUserid2());
        if(user2 != null && user1 != null){
            ChatRoomEntity savedChatRoom = chatRoomRepository.save(chatRoomEntity);

            userEntityService.addChatRoomToUser(user1,savedChatRoom);
            userEntityService.addChatRoomToUser(user2,savedChatRoom);
            return savedChatRoom;
        }
        return null;
    }

    public ChatRoomEntity getChatRoomById(int id){
        return chatRoomRepository.findById(id).orElse(null);
    }

}
