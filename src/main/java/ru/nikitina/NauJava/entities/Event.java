package ru.nikitina.NauJava.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "events")
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Date timestamp;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "event_type_id", nullable = false)
    private EventType eventType;

    @Column
    private String source;

    @Column
    private String message;

    @Column
    private String context;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Event() {}

    public Event(Date timestamp, EventType eventType, String source, String message, String context, User user) {
        this.timestamp = timestamp;
        this.eventType = eventType;
        this.source = source;
        this.message = message;
        this.context = context;
        this.user = user;
    }
}
