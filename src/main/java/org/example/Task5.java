package org.example;

/**
 * Вариант 1
 * <p>
 * Необходимо реализовать интерфейс Task (см. Приложение Г)
 * <p>
 * Реализуйте интерфейс “Task” для выполнения функции обратного
 * отсчёта таймера. Таймер должен начинаться с заданного значения и
 * уменьшаться каждую секунду до нуля, печатая остаток времени в консоль.
 * При вызове метода start() таймер начинает свою работу, при вызове метода
 * stop() таймер останавливается. Для выполнения задания рекомендуется
 * использовать метод “java.lang.Thread#sleep(long)”.
 */

interface Task {
    void start();

    void stop();
}

public class Task5 {
    static class Timer implements Task {
        private int timeInSeconds;
        private volatile boolean running = false;

        public Timer(int timeInSeconds) {
            this.timeInSeconds = timeInSeconds;
        }

        public void start() {
            if (running) {
                System.out.println("Timer is already running");
                return;
            }

            running = true;

            new Thread(() -> {
                while (timeInSeconds > 0 && running) {
                    System.out.println("Left: " + timeInSeconds + " seconds");
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                        System.out.println("Timer interrupted");
                        return;
                    }
                    timeInSeconds--;
                }

                if (running) {
                    System.out.println("Timer finalized");
                    running = false;
                }
            }).start();
        }

        public void stop() {
            if (running) {
                running = false;
                System.out.println("Timer stopped");
            }
        }
    }

    public static void execute(int timeInSeconds, int waitInSeconds) {
        Timer timer = new Timer(timeInSeconds);
        timer.start();

        try {
            Thread.sleep(waitInSeconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        timer.stop();
    }
}
