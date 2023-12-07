package com.example.demo;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "event_id")
    private Long eventId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(name = "event_title", nullable = false)
    private String eventTitle;

    @Column(name = "event_description", columnDefinition = "TEXT")
    private String eventDescription;

    @Column(name = "event_date")
    private java.sql.Date eventDate;

    @Column(name = "event_time")
    private java.sql.Time eventTime;

    @Column(name = "due_date")
    private java.sql.Date dueDate;

    @OneToMany(mappedBy = "event", cascade = CascadeType.ALL)
    private List<EventCategory> eventCategories;

    public Event() {
    }

    // Getters and setters
}
