package javase02.t03;

import javase02.t03.Products.*;
import javase02.t03.Products.Papers.*;
import javase02.t03.Products.Pens.*;


import java.util.ArrayList;


public class BeginnerExample {

    public StationeryList stationeryList = new StationeryList();

    public static void main(String[] args) {
        BeginnerExample beginnerExample = new BeginnerExample();
        beginnerExample.setBeginnerList();
        beginnerExample.getBeginnerList();
    }

    // создаем набор новичка
    public void setBeginnerList(){
        Stationery stationery;

        stationery = new Pen();
        stationery.setName("beginnerPen");
        stationery.setPrice(20);
        stationeryList.add(stationery);

        stationery = new Pen();
        stationery.setName("beginnerPen");
        stationery.setPrice(19);
        stationeryList.add(stationery);

        stationery = new Pen();
        stationery.setName("beginnerPen");
        stationery.setPrice(18);
        stationeryList.add(stationery);

        stationery = new Pencil();
        stationery.setName("beginnerPencil");
        stationery.setPrice(10);
        stationeryList.add(stationery);

        stationery = new CopyBook();
        stationery.setName("beginnerCopyBook");
        stationery.setPrice(30);
        stationeryList.add(stationery);

        stationery = new Pen();
        stationery.setName("beginnerCopyBook");
        stationery.setPrice(19);
        stationeryList.add(stationery);

    }

    // возвращаем набор новичка
    public ArrayList<Stationery> getBeginnerList(){
        System.out.println(stationeryList.toString());
        return stationeryList;
    }

}
