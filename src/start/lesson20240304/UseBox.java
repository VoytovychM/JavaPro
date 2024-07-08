package start.lesson20240304;

import java.util.List;

public class UseBox {
    public static void main(String[] args) {
//        Box box = new Box("toy", 5, true);
//        System.out.println(box);
////        box.empty();
//        System.out.println(box);
//
//
//
//
//        String item = box.getItem();
//        System.out.println(item);
//        if (item != null) {
//            System.out.println(item.toUpperCase());
//        } else {
//            System.out.println("Item is null. Box is empty");
//        }
////        System.out.println(1 / 0);
//
//        System.out.println("do something");


//        String someData = getSomeData();
//        if (someData != null && someData.length() != 0) {
//                System.out.println(someData.charAt(0));
//            // process data
//        } else {
//            // some other logic
//        }
//
//        int number = getSomeInt();
//        System.out.println(number);

        Cat cat = new Cat("Tom", "white", 3);
        Box box = new Box("toy", 5, true, cat);
        System.out.println(box);
        Box shallowCopyBox = box.shallowCopy();
        box.getCat().setName("Vasya");

        System.out.println("After changing name, shallowCopy:");
        System.out.println(box);
        System.out.println(shallowCopyBox);

        System.out.println("After changing name, deepCopy:");
        Box deepCopyBox = box.deepCopy();
        box.getCat().setName("Tom");
        System.out.println(box);
        System.out.println(deepCopyBox);


//        try {
//            Cat catClone = cat.clone();
//            System.out.println(catClone);
//        } catch (CloneNotSupportedException e) {
//            System.out.println("CloneNotSupportedException");
//        }

        try {

            System.out.println("After changing name, deep clone:");
            Box boxClone = box.clone();
            box.getCat().setName("New name");
            System.out.println(box);
            System.out.println(boxClone);
        } catch (CloneNotSupportedException e) {
            System.out.println("CloneNotSupportedException");
        }

    }


    public static String getSomeData() {
        return "dsdgnagna";
    }

    public static int getSomeInt() {
        return 24;

    }




}

