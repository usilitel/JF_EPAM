package javase02_oop.t04;

import javase02_oop.t03.Products.Stationery;
import java.util.Comparator;


public class ComparatorByPrice implements Comparator<Stationery> {
    public int compare(Stationery obj1, Stationery obj2)
    {
        int price1 = obj1.getPrice();
        int price2 = obj2.getPrice();

        return price1-price2;
    }
}