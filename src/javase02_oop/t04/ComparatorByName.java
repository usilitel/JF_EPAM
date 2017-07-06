package javase02_oop.t04;

import javase02_oop.t03.Products.Stationery;
import java.util.Comparator;

public class ComparatorByName implements Comparator<Stationery> {
    public int compare(Stationery obj1, Stationery obj2)
    {
        String str1 = obj1.getName();
        String str2 = obj2.getName();

        return str1.compareTo(str2);
    }
}
