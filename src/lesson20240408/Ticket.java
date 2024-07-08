package lesson20240408;

import java.util.*;

//1. Составить маршрут из заданного списка билетов
 //Имеется список билетов, необходимо найти маршрут по порядку, используя данный список.
 //Вход:
 //«Berlin» -> «London»
 //«Tokyo» -> «Seoul»
 //«Mumbai» -> «Berlin»
 //«Seoul» -> «Mumbai»
 //
 //Выход:
 //Tokyo->Seoul, Seoul->Mumbai, Mumbai->Berlin, Berlin->London
 //
 //2. Найти первый элемент, встречающийся k раз в массиве
 //
 //3. Проверьте, равны ли два массива или нет (массивы считаются равными, если содержат одинаковые элементы, порядок не важен)
public class Ticket {
    public static void main(String[] args) {
        Map<String, String> input = new HashMap<>();
        input.put("Berlin", "London");
        input.put("Tokio", "Seoul");
        input.put("Mumbai", "Berlin");
        input.put("Seoul", "Mumbai");

        printTicketsInOrder(input);
    }

    public static void printTicketsInOrder(Map<String, String> input) { // O(n) constant time

        // find the starting point
        Map<String, String> reverseOrder = new HashMap<>();
        Set<Map.Entry<String, String>> entries = input.entrySet();
        for (Map.Entry<String, String> e : entries) {
            reverseOrder.put(e.getValue(), e.getKey());
        }
        String start = reverseOrder.keySet().iterator().next();
        String first = start;

        while (start != null) { // O(n)
            first = start;
            start = reverseOrder.get(start);
        }
        System.out.println("Starting point: " + first);

        // traverse the route and print
        while (first != null){
            String value = input.get(first);
            System.out.println(first + " ---> " + value);
            first = value;
        }
    }

}