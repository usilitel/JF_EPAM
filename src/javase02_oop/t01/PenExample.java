package javase02_oop.t01;

public class PenExample {
    public static void main(String[] args) {
        Pen pen1 = new Pen(10, "model1");
        Pen pen2 = new Pen(20, "model2");
        Pen pen3 = new Pen(20, "model2");

        System.out.println(pen1.equals(pen2)); // false
        System.out.println(pen2.equals(pen3)); // true

        System.out.println(pen1.hashCode());
        System.out.println(pen2.hashCode());

        System.out.println(pen1.toString()); // javase02_oop.t01.Pen@price: 10, model: model1
        System.out.println(pen2.toString()); // javase02_oop.t01.Pen@price: 20, model: model2
    }
}
