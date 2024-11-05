package ru.nikitina.NauJava.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "logging_levels")
public class LoggingLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "importance_level_id", nullable = false)
    private ImportanceLevel importanceLevel;

    public LoggingLevel() {}

    public LoggingLevel(String name, String description, ImportanceLevel importanceLevel) {
        this.name = name;
        this.description = description;
        this.importanceLevel = importanceLevel;
    }
}