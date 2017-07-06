package javase02_oop.t02;

import java.util.ArrayList;

public class StationeryExample {
    ArrayList<Stationery> stationeryList = new ArrayList<Stationery>();
    ArrayList<Employee> employeeList = new ArrayList<Employee>();

    public static void main(String[] args) {
        StationeryExample stationeryExample = new StationeryExample();
        stationeryExample.start();


    }

    public void start(){
        // заполняем список канцтоваров
        stationeryList.add(new Stationery("pen",10));
        stationeryList.add(new Stationery("pencil",20));

        // заполняем список сотрудников
        employeeList.add(new Employee("Иванов И.И."));
        employeeList.add(new Employee("Петров П.П."));

        // добавляем канцтовары сотруднику
        Employee employee = employeeList.get(0);
        employee.addStationery(stationeryList.get(0));
        employee.addStationery(stationeryList.get(1));
        employee.addStationery(stationeryList.get(1));
        employee.removeStationery(stationeryList.get(1));

        System.out.println(employee.getFio() + ": стоимость канцтоваров = " + employee.getStationeryCost());

    }

}
