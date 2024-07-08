package practice20240429;

import java.util.Arrays;
import java.util.List;

public class Concert<T extends Actor> {
    private List<T> performers;

     public Concert(T...performers){
         this.performers = Arrays.stream(performers).toList();

     }
    public Concert(List<T> performers) {
        this.performers = performers;
    }

    public void process(){
        for(Actor actor: performers){
           actor.showTalant();

        }
    }
}
