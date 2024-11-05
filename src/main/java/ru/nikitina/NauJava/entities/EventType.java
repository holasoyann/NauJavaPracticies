package ru.nikitina.NauJava.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "event_types")
public class EventType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String message;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "importance_level_id", nullable = false)
    private ImportanceLevel importanceLevel;

    public EventType() {}

    public EventType(String name, String message, ImportanceLevel importanceLevel) {
        this.name = name;
        this.message = message;
        this.importanceLevel = importanceLevel;
    }
}
