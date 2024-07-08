package start.dayonePr;

public class Horse {
    protected String name;
    private int weight;
    private int speed;

    public void run (){
        System.out.println(name + "run with speed " + speed);
    }

    public Horse(String name, int weight, int speed) {
        this.name = name;
        this.weight = weight;
        this.speed = speed;
    }
  public Horse (){

  }
    @Override
    public String toString() {
        return "Horse{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                ", speed=" + speed +
                '}';
    }


}
