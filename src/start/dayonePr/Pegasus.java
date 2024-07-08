package start.dayonePr;

public class Pegasus extends Horse{
    private int speedOfFlight;

    public Pegasus(String name, int weight, int speed) {
        super(name, weight, speed);
        this.speedOfFlight = speedOfFlight;
    }

    public void fly(){
        System.out.println(name + "flies with speed " + speedOfFlight );
    }

}
