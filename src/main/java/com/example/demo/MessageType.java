package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class MessageType extends AbstractPersistable<Long> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long mt_id;
    private String type;

    @OneToMany(mappedBy = "messageType")
    private List<MessagesAndTypes> messageTypes = new ArrayList<>();

}