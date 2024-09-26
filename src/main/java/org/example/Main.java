package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        System.out.println("Task1: ");
        int n = 5;
        Task1.execute(n);

        System.out.println("\n\nTask2: ");
        int m = 8;
        Task2.execute(m);

        System.out.println("\n\nTask3: ");
        Task3.execute();

        System.out.println("\nTask4: ");
        Task4.execute();

        System.out.println("\n\nTask5: ");
        int initialTimeInSeconds = 10;
        int secondsBeforeStop = 8;
        Task5.execute(initialTimeInSeconds, secondsBeforeStop);

    }
}