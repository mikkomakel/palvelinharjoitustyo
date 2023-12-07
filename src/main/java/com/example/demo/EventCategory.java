package com.example.demo;

import javax.persistence.*;


@Entity
@Table(name = "event_categories")
public class EventCategory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "event_id")
    private Event event;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

    // Getters and setters
}
