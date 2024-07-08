package practice20240612;

import java.util.Random;
import java.util.UUID;

//Вы владелец кафе. Вы предлагаете клиентам блюда собственного приготовления, снеки и алкоголь.
//Сгенерируйте выторг данного кафе (количество на Ваше усмотрение) в формате:
//- наименование
//- тип (кухня, снек, алкоголь)
//- сумма (10-100)
//По окончании отчетного периода, вам нужно подсчитать налоги и доход:
//1) Со всей суммы выторга нужно забрать НДС - 15%.
//2) С алкоголя, нужно забрать 2% акцизного сбора.
//3) Снеки облагаются доп.налогом 1%.
//4) С продуктов кухни нужно снять 10%, как доп.выплату поварам.
//5) Зарплата сотрудникам рассчитывается как 20% от общей суммы.
//6) Инвесторам нужно выплатить 10 %.
//Вычислите сумму дохода и % составляет доход в от суммы общей выручки?
class Cafe {
    private String name;
    private Menu menu;
    private int sum;

    public Cafe(String name, Menu menu, int sum) {
        this.name = name;
        this.menu = menu;
        this.sum = sum;
    }

    public Cafe() {
        this.name = UUID.randomUUID().toString();
        this.menu = Menu.returnRandom();
        this.sum = generateSum();
    }

    private int generateSum() {
        Random random = new Random();
        return random.nextInt(91) + 10; // Random number between 10 and 100
    }

    public Menu getMenu() {
        return menu;
    }

    public int getSum() {
        return sum;
    }

    @Override
    public String toString() {
        return "Cafe{" +
                "name='" + name + '\'' +
                ", menu=" + menu +
                ", sum=" + sum +
                '}';
    }
}