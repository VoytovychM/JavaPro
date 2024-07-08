package start.inheritance;

public class Parent {
    public int publicField = 10;
    private int privateField = 10;

    public void publicMethod(){
        System.out.println("Parent public method");
    }
    private void privateMethod(){
        System.out.println("Parent private method");
}
}
