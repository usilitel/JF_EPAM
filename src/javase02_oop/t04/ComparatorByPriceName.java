package javase02_oop.t04;

import javase02_oop.t03.Products.Stationery;
import java.util.Comparator;

public class ComparatorByPriceName implements Comparator<Stationery> {
    public int compare(Stationery obj1, Stationery obj2)
    {
        String name1 = obj1.getName();
        String name2 = obj2.getName();

        int price1 = obj1.getPrice();
        int price2 = obj2.getPrice();

        if(price1 != price2)
            return price1-price2;
        else
            return name1.compareTo(name2);

    }
}
