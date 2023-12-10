package com.example.demo;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import java.util.Date;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Message extends AbstractPersistable<Long> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Account user;
    private String content;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}