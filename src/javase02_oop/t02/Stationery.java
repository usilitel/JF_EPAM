package javase02_oop.t02;

// канцтовары
public class Stationery {
    private String name;
    private int price;

    Stationery(String name, int price){
        this.name = name;
        this.price = price;

    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
