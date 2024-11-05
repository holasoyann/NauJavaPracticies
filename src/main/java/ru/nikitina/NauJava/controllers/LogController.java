package ru.nikitina.NauJava.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.nikitina.NauJava.dao.LogRepositoryCustom;
import ru.nikitina.NauJava.entities.Log;

import java.util.List;

@RestController
@RequestMapping("/logs")
public class LogController {
    private LogRepositoryCustom logRepositoryCustom;

    @Autowired
    public LogController(LogRepositoryCustom logRepositoryCustom) {
        this.logRepositoryCustom = logRepositoryCustom;
    }

    @GetMapping("/findBy/source")
    public List<Log> findBySource(@RequestParam String source) {
        return logRepositoryCustom.findBySource(source);
    }

    @GetMapping("/findBy/sourceAndMessage")
    public List<Log> findByFolderName(@RequestParam String source, @RequestParam String message) {
        return logRepositoryCustom.findBySourceAndMessage(source, message);
    }
}
