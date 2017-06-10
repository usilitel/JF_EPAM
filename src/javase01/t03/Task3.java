package javase01.t03;

public class Task3 {

    // входные параметры
    public static final double a=1d; // левая граница отрезка
    public static final double b=5d; // правая граница отрезка
    public static final double h=0.5d; // шаг вычисления значений функции F(x)


    public static void main(String[] args) {

        System.out.println("x   |   F(x)");
        System.out.println("----|----------------");

        for(double i=a; i<=b; i+=h){
            double f = F(i);
            System.out.println(i + " | " + f);
        }
    }


    // вычисляем F(x) = tg(2x)-3
    public static double F(double x){
        return Math.tan(2*x) - 3;
    };






}
