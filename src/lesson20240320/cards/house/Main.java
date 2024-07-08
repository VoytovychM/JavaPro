package lesson20240320.cards.house;

import java.util.*;

public class Main {

    public static void main(String[] args) {
         // 1. Вы автоматизируете бизнес риелторов. у вас есть класс:
        //public class House {
        //    int area; //площадь дома
        //    int price; // цена
        //    String city; // город
        //    boolean hasFurniture; //продается с мебелью
        //}
        //- По умолчанию в вашем информационном хранилище дома сортируются по цене.
        //- Но иногда клиент хочет видеть информацию о домах в конкретном городе и осортированную по цене.
        //Реализуйте компаратор, который вы можете применить для показа клиенту в требуемом им формате.
        //- А если клиенту неожиданно захочет увидеть информацию, отсортированную в формате:
        //"город - площадь дома", что вы будете делать?

        House.CityAreaComparator cityAreaComparator = new House.CityAreaComparator();
        House.CityPriceComparator cityPriceComparator= new House.CityPriceComparator();

       House house1 = new House(150, 150_000, "Berlin", false);
       House house2 = new House(100, 700_000, "Heidelberg", true);
       House house3 = new House(120, 300_000, "Schwetzingen", true);
       House house4 = new House(120, 310_000, "Mannheim", false);

    List<House> houseList = new ArrayList<>(Arrays.asList(house1, house2, house3, house4));
       Collections.sort(houseList, cityPriceComparator);
        System.out.println("Sorted by city and price:");
        for(House house: houseList){
            System.out.println(house.getCity() + " - " + house.getPrice());
        }
    Collections.sort(houseList, cityAreaComparator);
        System.out.println("\nSorted by city and area");
        for(House house: houseList){
            System.out.println(house.getCity() + "-" + house.getArea());
        }

        Queue<House> houseQueue = new LinkedList<>();
        houseQueue.addAll(houseList);
        System.out.println("Queue " + houseQueue);
//        System.out.println(houseQueue.remove());
        System.out.println(houseQueue.offer(house1));
        System.out.println(houseQueue.peek());
}
}
