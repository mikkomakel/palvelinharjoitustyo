package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessagesAndTypes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long mat_id;
    @ManyToMany
    @JoinTable(
            name = "mat_messages",
            joinColumns = @JoinColumn(name= "mat_id"),
            inverseJoinColumns = @JoinColumn(name= "id")
    )
    private List<Message> messages;
    @ManyToMany
    @JoinTable(
            name = "mat_messagetypes",
            joinColumns = @JoinColumn(name= "mat_id"),
            inverseJoinColumns = @JoinColumn(name= "id")
    )
    private List<MessageType> messageTypes;

}
