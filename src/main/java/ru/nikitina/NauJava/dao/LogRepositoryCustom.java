package ru.nikitina.NauJava.dao;

import ru.nikitina.NauJava.entities.Log;
import java.util.List;

public interface LogRepositoryCustom {

    List<Log> findBySource(String source);

    List<Log> findBySourceAndMessage(String level, String message);
}
