package ru.nikitina.NauJava.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "logs")
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private Date timestamp;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "logging_level_id", nullable = false)
    private LoggingLevel loggingLevel;

    @Column
    private String source;

    @Column
    private String message;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Log() {}

    public Log(Date timestamp, LoggingLevel loggingLevel, String source, String message, User user) {
        this.timestamp = timestamp;
        this.loggingLevel = loggingLevel;
        this.source = source;
        this.message = message;
        this.user = user;
    }
}
