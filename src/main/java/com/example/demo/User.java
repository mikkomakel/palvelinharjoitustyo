package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.AbstractPersistable;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User extends AbstractPersistable<Long> {
    private String username;
    private String password;
    private String passwordHash;
    @OneToMany(mappedBy = "user")
    private List<Category> categories;
    @OneToMany(mappedBy = "user")
    private List<Event> events;
}
