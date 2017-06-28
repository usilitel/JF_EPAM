package javase02.t04;

//import javase02.t03.BeginnerExample;
import javase02.t03.*;
import javase02.t03.Products.Stationery;

import java.util.Comparator;

public class ArraySort {

    public static void main(String[] args) {
        BeginnerExample beginnerExample = new BeginnerExample();

        System.out.println("начальный порядок:");
        beginnerExample.setBeginnerList();
        beginnerExample.getBeginnerList();

        System.out.println("сортировка по имени:");
        beginnerExample.stationeryList.sort(new ComparatorByName());
        beginnerExample.getBeginnerList();

        System.out.println("сортировка по цене:");
        beginnerExample.stationeryList.sort(new ComparatorByPrice());
        beginnerExample.getBeginnerList();

        System.out.println("сортировка по имени и цене:");
        beginnerExample.stationeryList.sort(new ComparatorByNamePrice());
        beginnerExample.getBeginnerList();

        System.out.println("сортировка по цене и имени:");
        beginnerExample.stationeryList.sort(new ComparatorByPriceName());
        beginnerExample.getBeginnerList();
    }

}
