package lesson20240415;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferences {
    public static void main(String[] args) {
        Consumer<String> consumer = s -> System.out.println(s);
        Consumer<String> consumer2 = System.out :: println;

        MethodReferences methodReferences = new MethodReferences();
        Consumer<Integer> consumer3 = methodReferences::customConsumer;
        consumer3.accept(100);
        Consumer<Integer> consumer4 = integer -> methodReferences.customConsumer(integer);
        Function<String, String> function = MethodReferences::customFunction;
//        Function<String, String> function = s->MethodReferences.customFunction(s);
        System.out.println(function.apply("String"));

        Supplier<MethodReferences> supplier = MethodReferences::new;
        MethodReferences entity = supplier.get();
    }

    public void customConsumer(Integer data){
        System.out.println("customConsumer " + data);
//        extraMethod(data);
        Consumer<Integer> consumer = this::extraMethod;
        consumer.accept(data);
    }

    private void extraMethod (Integer data){
        System.out.println("extraMethod " + data);
    }
    public static String customFunction(String data){
        return "{" + data + "}";
    }
}
