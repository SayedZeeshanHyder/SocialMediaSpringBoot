package com.socialmedia.smapp.Entities;

import jakarta.persistence.*;

import java.util.List;

@Table(name = "chatrooms")
@Entity
public class ChatRoomEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int userid1;
    private int userid2;

    @ManyToMany
    @JoinTable(
            name = "chatrooms_chats",
            joinColumns = @JoinColumn(name = "chatrooms_id"),
            inverseJoinColumns = @JoinColumn(name = "chats_id")
    )
    private List<ChatEntity> chats;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserid1() {
        return userid1;
    }

    public void setUserid1(int userid1) {
        this.userid1 = userid1;
    }

    public int getUserid2() {
        return userid2;
    }

    public void setUserid2(int userid2) {
        this.userid2 = userid2;
    }

    public List<ChatEntity> getChats() {
        return chats;
    }

    public void addChat(ChatEntity chat) {
        this.chats.add(chat);
    }

}
