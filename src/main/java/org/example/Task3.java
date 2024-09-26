package org.example;

import java.util.ArrayList;
import java.util.Random;

/**
 * Вариант 1
 * Необходимо обработать список с использованием Stream API.
 * 1. Необходимо реализовать java-класс сотрудник (код “Employee”).
 * Приватные поля класса: ФИО (“fullName” тип “String”), Возраст (“age”
 * тип “Integer”), Отдел (“department” тип “String”), З/П (“salary” тип
 * “Double”). Класс должен содержать геттеры и сеттеры для доступа к
 * полям.
 * 2. Необходимо реализовать предзаполненный список (тип
 * “ArrayList<Employee>”) с объектами класса “Employee”, по которым будем
 * выполняться задание. Необходимо создать не менее 5 элементов списка.
 * 3. Выполнить задание в соответствии с вашим вариантом. При
 * выполнении задания необходимо использовать возможности Stream API!
 * <p>
 * Варианты заданий.
 * 1. Отфильтровать сотрудников, оставив только тех, кто старше 30
 * лет.
 * <p>
 * Выходные данные: в консоль напечатан результат выполнения задания.
 * Объекты должны быть напечатаны в читаемом виде
 */

public class Task3 {
    static class Employee {
        private String fullName;
        private Integer age;
        private String department;
        private Double salary;

        public String getFullName() {
            return this.fullName;
        }

        public void setFullName(String fullName) {
            this.fullName = fullName;
        }

        public Integer getAge() {
            return this.age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getDepartment() {
            return this.department;
        }

        public void setDepartment(String department) {
            this.department = department;
        }

        public Double getSalary() {
            return this.salary;
        }

        public void setSalary(Double salary) {
            this.salary = salary;
        }

        public Employee(String fullName, Integer age, String department, Double salary) {
            this.fullName = fullName;
            this.age = age;
            this.department = department;
            this.salary = salary;
        }

        @Override
        public String toString() {
            return "Name: '" + this.fullName + "',\nAge: '" + this.age + "',\nDepartment: '" + this.department + "',\nSalary: " + salary+"\n";
        }
    }

    private static ArrayList<Employee> GenerateEmployees(int min, int max) {
        var names = new String[]{"Иван", "Петр", "Абрам", "Олег", "Ибрагим", "Леонид"};
        var departments = new String[]{"Отдел продаж", "Отдел маркетинга", "Отдел техподдержчки"};

        ArrayList<Employee> employees = new ArrayList<>();
        Random rand = new Random();
        int n = rand.nextInt(min, max);
        for (int i = 0; i < n; i++) {
            var name = String.format("%sов %s %sович",
                    names[rand.nextInt(0, names.length)],
                    names[rand.nextInt(0, names.length)],
                    names[rand.nextInt(0, names.length)]);
            var age = rand.nextInt(18, 65);
            var department = departments[rand.nextInt(0, departments.length)];
            var salary = rand.nextDouble(30000, 200000);

            employees.add(new Employee(name, age, department, salary));
        }
        return employees;
    }

    public static void execute() {
        var employees = GenerateEmployees(5, 10);


        System.out.println("All employees: ");
        for (var employee : employees) {
            System.out.println(employee);
        }

        System.out.println("-------------------------------------------");

        System.out.println("Filtered employees: ");
        employees.stream()
                .filter(c -> c.getAge() > 30)
                .forEach(System.out::println);

    }

}
