package com.example.demo;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message extends AbstractPersistable<Long> implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long m_id;
    @ManyToOne
    private Account user;
    private String content;
    private String type;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    @OneToMany(mappedBy = "message")
    private List<MessagesAndTypes> mmt = new ArrayList<>();

}