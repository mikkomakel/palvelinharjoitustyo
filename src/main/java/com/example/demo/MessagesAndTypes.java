package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.domain.AbstractPersistable;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class MessagesAndTypes extends AbstractPersistable<Long> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long mat_id;

    @ManyToOne
    @JoinColumn(name = "m_id", referencedColumnName = "m_id")
    private Message message;

    @ManyToOne
    @JoinColumn(name = "mt_id", referencedColumnName = "mt_id")
    private MessageType messageType;
}