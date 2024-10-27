package ru.nikitina.NauJava.entities;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class Log {
    private Long id;
    private Date timeStamp;
    private LoggingLevel loggingLevel;
    private String message;

    public String toString() {
        return "LOG [id=" + id + ", timeStamp=" + timeStamp + ", loggingLevel=" + loggingLevel + ", message=" + message + "]";
    }
}
