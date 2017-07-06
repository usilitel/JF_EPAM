package javase02_oop.t06;

public class Main {
    public static void main(String[] args) {
        Submarine submarine = new Submarine("АПЛ 1.0", 200,"двигатель 1.0",11d);

        if(submarine.checkSubmarine()==1) {
            System.out.println("проверка АПЛ прошла успешно");
            submarine.startSubmarine();
        }
    }
}
