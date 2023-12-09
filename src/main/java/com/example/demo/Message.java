package com.example.demo;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

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

    @ManyToOne
    private Account user;
    private String content;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}