package com.socialmedia.smapp.Service;

import com.socialmedia.smapp.Entities.ChatEntity;
import com.socialmedia.smapp.Entities.ChatRoomEntity;
import com.socialmedia.smapp.Repository.ChatRepository;
import org.springframework.stereotype.Service;

@Service
public class ChatService {

    private ChatRepository chatRepository;
    private ChatRoomService chatRoomService;

    ChatService(ChatRepository chatRepository, ChatRoomService chatRoomService) {
        this.chatRepository = chatRepository;
        this.chatRoomService = chatRoomService;
    }

    public ChatEntity createChat(ChatEntity chat,int chatRoomId) {
        ChatRoomEntity chatRoom = chatRoomService.getChatRoomById(chatRoomId);
        if(chatRoom != null) {
            ChatEntity savedChat = chatRepository.save(chat);
            System.out.println(savedChat.toString());
            chatRoom.addChat(savedChat);
            chatRoomService.createRoom(chatRoom);
            return savedChat;
        }
        return null;
    }

}
