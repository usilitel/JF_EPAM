package javase02_oop.t03.Products;

public class Stationery {
    private int price;
    private String name;

    public Stationery(){
    }

    public Stationery(int price, String name){
        this.price = price;
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
