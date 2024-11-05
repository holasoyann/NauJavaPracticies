package ru.nikitina.NauJava.helpers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.sql.Date;

@Component
public class CommandProcessor {
//    private final LogService logService;
//
//    @Autowired
//    @Lazy
//    public CommandProcessor(LogService logService) {
//        this.logService = logService;
//    }
//
//    public void processCommand(String input) {
//        String[] cmd = input.split(" ");
//        switch (cmd[0]) {
//            case "create" -> {
//                logService.createLog(Long.valueOf(cmd[1]), Date.valueOf(cmd[2]), LoggingLevel.valueOf(cmd[3]), cmd[4]);
//                System.out.println("Log successfully created...");
//            }
//            case "delete" -> {
//                logService.deleteById(Long.valueOf(cmd[1]));
//                System.out.println("Log successfully deleted...");
//            }
//            case "find" -> {
//                var result = logService.findById(Long.valueOf(cmd[1]));
//                System.out.println(result);
//            }
//            case "update" -> {
//                logService.updateLog(Long.valueOf(cmd[1]), Date.valueOf(cmd[2]), LoggingLevel.valueOf(cmd[3]), cmd[4]);
//                System.out.println("Log successfully updated...");
//            }
//            default -> System.out.println("Введена неизвестная команда...");
//        }
//    }
}