package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Kayttaja extends AbstractPersistable<Long> {
    private String username;
    private String password;
}
