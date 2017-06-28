package javase02.t03.Products.Pens;

import javase02.t03.Products.Papers.Papers;
import javase02.t03.Products.Stationery;

public class Pens extends Stationery {



    public void write(Papers paper, String text){
        paper.setText(text);
    }
}
