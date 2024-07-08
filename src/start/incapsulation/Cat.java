package start.incapsulation;

public class Cat {
    private String name;
    private int age;
    protected String colour;

    private boolean isHungry;

    public Cat(String catName){
        this(catName, "white", 1, true);
    }

    public Cat(String catName, String catColour, int catAge){
        this(catName, catColour, catAge, true);
    }
    private Cat(String catName, String catColour, int catAge, boolean isHungry){
        this.isHungry = isHungry;
        name = catName;
        colour = catColour;
        age = catAge;
    }

    public void sayHello(){
        System.out.println("Meow! I'm " + name);
    }

    public void feed(){
        isHungry = false;
        System.out.println("Cat " + name + " is not hungry anymore");
    }

    public int getAge(){
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColour() {
        return colour;
    }

    public void setColour(String colour) {
        this.colour = colour;
    }

    public boolean isHungry() {
        return isHungry;
    }

    public void setHungry(boolean hungry) {
        isHungry = hungry;
    }
}

