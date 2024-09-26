package org.example;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Вариант 1
 * Необходимо сделать “GET” запрос на указанный адрес и обработать
 * ответ. Запрос выполняется на тестовый сервер по адресу
 * “https://httpbin.org/”. Сервер возвращает ответ в формате JSON. Из ответа
 * необходимо извлечь и вывести в консоль информацию в соответствии со
 * своим вариантом.
 * Варианты заданий.
 * 1. Вывести только значение IP адреса с которого был сделан запрос
 * (запрос выполняется по адресу “https://httpbin.org/ip”).
 * <p>
 * Выходные данные: в консоль напечатан результат выполнения запроса
 * обработанный в соответствии с вариантом задания
 */

class ip {
    public String origin;
}

public class Task4 {

    public static void execute() {
        var uri = "https://httpbin.org/ip";
        HttpClient client = HttpClient.newHttpClient();
        HttpRequest request = HttpRequest.newBuilder()
                .uri(URI.create(uri))
                .GET()
                .build();
        try {
            var response = client.send(request, HttpResponse.BodyHandlers.ofString());
            if (response.statusCode() == 200) {
                var responseBody = response.body();
                var objectMapper = new ObjectMapper();
                var ipAddress = objectMapper.readValue(responseBody, ip.class);
                System.out.println(ipAddress.origin);
            } else {
                System.out.println("Error occurred. Status: " + response.statusCode());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
