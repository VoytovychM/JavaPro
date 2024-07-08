package summary.task;

import java.util.*;

public class FiguresMain {
    public static void main(String[] args) {
        List<Figures> figuresList = new ArrayList<>(Arrays.asList());
        figuresList.add(new Circle(6));
        figuresList.add(new Rectangle(4, 3));
        figuresList.add(new Square(6));
        figuresList.add(new Triangle(5,4));

        Collections.sort(figuresList, new Comparator<Figures>() {
            @Override
            public int compare(Figures o1, Figures o2) {
                return (int) (o1.calculateArea() - o2.calculateArea());
            }
        });
        System.out.println("Sorted list by area: " );
        for(Figures figure: figuresList){
            System.out.println(figure.getClass().getSimpleName() + " - area: " + figure.calculateArea());
        }
        TreeSet<Figures> treeSet = new TreeSet<>(new Comparator<Figures>() {
            @Override
            public int compare(Figures o1, Figures o2) {
                return (int) (o1.calculateArea() - o2.calculateArea());
            }
        });
//        TreeSet<Figures> treeSet = new TreeSet<>(Comparator.comparingDouble(Figures::calculateArea));
        treeSet.addAll(figuresList);

        System.out.println("/n Treeset with geometrical figures: "  );
        for(Figures figure: figuresList){
            System.out.println(figure.getClass().getSimpleName() + " - area" + figure.calculateArea());
        }

    }
}
