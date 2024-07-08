package practice20240506;
//1. Создайте обобщенный интерфейс для калькулятора, в котором будут объявлен перечень операций,
//которые умеет делать ваш калькулятор add, sub, multi и div и реализуйте классы, которые
//будут включать данный интерфейс для работы с различными типами данных аргументов.

public interface NumericialOperations <T extends Number> {

    T add (T a, T b);

    T sub(T a, T b);

    T multi (T a, T b);

    T div (T a, T b);
}

