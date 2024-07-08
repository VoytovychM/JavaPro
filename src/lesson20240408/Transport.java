package lesson20240408;
// 3) Автозаправка. По умолчанию автомобили заправляются согласно стандартной очереди FIFO. Но автомобили скорой помощи
//всегда заправляются вне очереди.
//В час пик, общественные автобусы получают максимальный приоритет по заправке, но скорая помощь все равно более приоритетна.
//Во время стихийных бедствий (снегопад, наводнение) технологический транспорт городских служб заправляется вне очереди.
//Какую бы коллекцию Вы использовали для реализацию данного алгоритма?
//Напишите программу, которая бы имитировала работу.
public class Transport implements Comparable<Transport>{
    private String name;
    private int priorityLevel;

    private TransportTypes transportTypes;

    public Transport(String name, int priorityLevel, TransportTypes transportTypes) {
        this.name = name;
        this.priorityLevel = priorityLevel;
        this.transportTypes = transportTypes;
    }

    @Override
    public String toString() {
        return "Transport{" +
                "name='" + name + '\'' +
                ", priorityLevel=" + priorityLevel +
                ", transportTypes=" + transportTypes +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(int priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    public TransportTypes getTransportTypes() {
        return transportTypes;
    }

    public void setTransportTypes(TransportTypes transportTypes) {
        this.transportTypes = transportTypes;
    }

    @Override
    public int compareTo(Transport o) {
        return Integer.compare(this.priorityLevel, o.priorityLevel);
    }
}
