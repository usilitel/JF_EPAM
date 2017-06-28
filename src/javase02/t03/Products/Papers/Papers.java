package javase02.t03.Products.Papers;

import javase02.t03.Products.Stationery;

public class Papers extends Stationery {
    private int sizeX;
    private int sizeY;
    private String text = "";

    public int getSizeX() {
        return sizeX;
    }

    public void setSizeX(int sizeX) {
        this.sizeX = sizeX;
    }

    public int getSizeY() {
        return sizeY;
    }

    public void setSizeY(int sizeY) {
        this.sizeY = sizeY;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text += text;
    }


}
