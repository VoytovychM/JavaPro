package start.incapsulation;

public class useA {
    public static void main(String[] args) {
        A.staticMethod();
//        A.staticMethod();

        System.out.println("------");
        A a = new A("ABC");
        a.nonStaticMethod();

        //1 static field init
        //2 static blocks

        //3 non static field init
        //4 non static blocks
        //5 constructor

    }
}
