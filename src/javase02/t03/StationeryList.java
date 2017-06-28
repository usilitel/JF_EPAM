package javase02.t03;

import javase02.t03.Products.Stationery;
import java.util.ArrayList;

public class StationeryList extends ArrayList<Stationery> {

    // выводим список канцтоваров в наборе
    public String toString(){
        String s = "";
        for(Stationery stationery: this){
            s += stationery.getClass().getSimpleName() +  ": name = " + stationery.getName() + ", price = " + stationery.getPrice() + "\n";
        }
        return s;
    }
}
