package start.inheritance;

public class Child extends Parent {
     public String name = "Name";
     public int publicField = 20;

     public void method (){
         System.out.println("child method " + this.publicField);
         System.out.println("child method " + super.publicField);
     }
     @Override
    public void publicMethod (){

     }
    }



