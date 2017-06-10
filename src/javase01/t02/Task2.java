package javase01.t02;

public class Task2 {

    // входные параметры
    public static final int N=10; // количество элементов в последовательности
    public static final double E=0.1d; // верхняя граница


    public static void main(String[] args) {

        System.out.println("входные параметры:");
        System.out.println("n="+N);
        System.out.println("E="+E);
        System.out.println("");

        if(N<1){
            System.out.println("количество элементов в последовательности должно быть >= 1");
            return;
        }

        // вычисляем наименьший номер элемента последовательности, для которого выполняется условие M.
        int minElement = calcMinElement(N);
        if(minElement != -1){
            System.out.println("наименьший номер элемента последовательности, для которого выполняется условие M:");
            System.out.println(minElement);

            // выводим на экран все элементы ai  где i = 1, 2, ..., n.
            System.out.println("");
            System.out.println("элементы ai  где i = 1, 2, ..., n:");
            for(int i=1; i<=minElement; i++){
                System.out.println(i);
            }
        }
        else{
            System.out.println("в последовательности нет подходящих элементов");
        }
    }

    // вычисляем первый подходящий элемент последовательности.
    // если подходящих элементов нет - то возвращаем -1
    public static int calcMinElement(int countElements){
        if((1.0/Math.pow((countElements+1),2)) >= E){return -1;} // нет подходящих элементов

        for(int i=1; i<=countElements; i++){
            double f = (1.0/Math.pow((i+1),2));
            if(f<E){return i;}
        }

        return -1;
    };
}
