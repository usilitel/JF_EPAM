package javase02_oop.t02;

import java.util.ArrayList;

// сотрудник
public class Employee {
    private String fio; // ФИО сотрудника
    private ArrayList<Stationery> stationeryList = new ArrayList<Stationery>(); // список id канцтоваров

    Employee(String fio){
        this.fio = fio;
    }

    // добавляем канцтовар
    public void addStationery(Stationery stationery){
        stationeryList.add(stationery);
    }

    // удаляем 1 объект из списка канцтоваров
    public void removeStationery(Stationery stationery){
        stationeryList.remove(stationery);
    }

    // получаем стоимость всех канцтоваров сотрудника
    public int getStationeryCost(){
        int stationeryCost=0;
        for(Stationery s: stationeryList){
            {
                stationeryCost+=s.getPrice();
            }
        }
        return stationeryCost;
    }


    public String getFio() {
        return fio;
    }


}
