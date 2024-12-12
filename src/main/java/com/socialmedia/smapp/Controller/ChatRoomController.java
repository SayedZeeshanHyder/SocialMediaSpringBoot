package com.socialmedia.smapp.Controller;

import com.socialmedia.smapp.Entities.ChatEntity;
import com.socialmedia.smapp.Entities.ChatRoomEntity;
import com.socialmedia.smapp.Service.ChatRoomService;
import com.socialmedia.smapp.Service.ChatService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("chatroom")
public class ChatRoomController {

    private ChatRoomService chatRoomService;
    private ChatService chatService;

    ChatRoomController(ChatRoomService chatRoomService, ChatService chatService) {
        this.chatRoomService = chatRoomService;
        this.chatService = chatService;
    }

    @PostMapping("create")
    public ResponseEntity<ChatRoomEntity> create(@RequestBody ChatRoomEntity chatRoomEntity) {
        ChatRoomEntity savedChatRoom = chatRoomService.createRoom(chatRoomEntity);
        if (savedChatRoom != null) {
            return ResponseEntity.ok(savedChatRoom);
        }
        return ResponseEntity.internalServerError().build();
    }

    @GetMapping("{chatRoomId}")
    public ResponseEntity<ChatRoomEntity> getChatRoom(@PathVariable int chatRoomId) {
        ChatRoomEntity foundChatRoom = chatRoomService.getChatRoomById(chatRoomId);
        if (foundChatRoom != null) {
            return ResponseEntity.ok(foundChatRoom);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("{chatRoomId}/chat")
    public ResponseEntity<ChatEntity> sendChat(@PathVariable int chatRoomId, @RequestBody ChatEntity chatEntity) {
        System.out.println(chatEntity.toString());
        ChatEntity savedChat = chatService.createChat(chatEntity, chatRoomId);
        if (savedChat != null) {
            return ResponseEntity.ok(savedChat);
        }
        return ResponseEntity.internalServerError().build();
    }
}
