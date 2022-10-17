package ru.academits.balyshen.lambda_task_1_main;

import ru.academits.balyshen.lambda_task_1.Person;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = Arrays.asList(
                new Person("Иван", 15),
                new Person("Анастасия", 25),
                new Person("Алексей", 16),
                new Person("Светлана", 63),
                new Person("Евгений", 33),
                new Person("Сергей", 55),
                new Person("Владислав", 10),
                new Person("Лариса", 27),
                new Person("Петр", 25),
                new Person("Иван", 56),
                new Person("Тамара", 47),
                new Person("Валентина", 71),
                new Person("Николай", 15),
                new Person("Светлана", 82),
                new Person("Екатерина", 34),
                new Person("Алексей", 18),
                new Person("Андрей", 41),
                new Person("Николай", 53),
                new Person("Евгений", 39),
                new Person("Екатерина", 39)
        );

        System.out.println("Исходный список людей: " + persons);
        System.out.println();

        List<String> uniqueNamesList = persons.stream()
                .map(Person::getName)
                .distinct()
                .toList();

        System.out.println(uniqueNamesList.stream().collect(Collectors.joining(", ", "Уникальные имена в списке: ", ".")));
        System.out.println();

        List<Person> personsWithAgeUnder18List = persons.stream()
                .filter(p -> p.getAge() < 18)
                .toList();

        System.out.println("Список людей младше 18: " + personsWithAgeUnder18List);
        System.out.println();

        OptionalDouble averageAgeForPersonsWithAgeUnder18 = personsWithAgeUnder18List.stream()
                .mapToInt(Person::getAge)
                .average();

        if (averageAgeForPersonsWithAgeUnder18.isPresent()) {
            System.out.println("Средний возраст людей младше 18: " + averageAgeForPersonsWithAgeUnder18.getAsDouble() + ".");
            System.out.println();
        } else {
            System.out.println("В списке отсутствуют люди младше 18.");
            System.out.println();
        }

        Map<String, Double> averageAgeByNames = persons.stream()
                .collect(Collectors.groupingBy(Person::getName, Collectors.averagingInt(Person::getAge)));

        System.out.println("Map, в котором ключи – имена, а значения – средний возраст:");
        averageAgeByNames.forEach((name, averageAge) -> System.out.printf("Имя: %s. Средний возраст: %s.%n", name, averageAge));

        System.out.println();

        System.out.println("Имена людей, возраст которых от 20 до 45, в порядке убывания возраста:");
        persons.stream()
                .filter(p -> p.getAge() >= 20 && p.getAge() <= 45)
                .sorted((p1, p2) -> p2.getAge() - p1.getAge())
                .forEach(p -> System.out.println(p.getName()));
    }
}
