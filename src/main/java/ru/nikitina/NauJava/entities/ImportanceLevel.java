package ru.nikitina.NauJava.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "importance_levels")
public class ImportanceLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private Integer importance;

    public ImportanceLevel() {}

    public ImportanceLevel(String name, String description, Integer importance) {
        this.name = name;
        this.description = description;
        this.importance = importance;
    }
}
