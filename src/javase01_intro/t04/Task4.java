package javase01_intro.t04;

public class Task4 {

    // исходный массив действительных чисел
    public static double[] numbers = new double[] { 1, 2, 3, 3, 2, 1 };


    public static void main(String[] args) {

        if (numbers.length%2 != 0) {
            System.out.println("ошибка: нечетное количество элементов в массиве");
            return;
        }

        // заполняем массив с суммами пар элементов
        double[] sum = calcSum();

        // вычисляем максимальную сумму пар элементов
        double maxSum = maxValue(sum);

        System.out.println("Максимальная сумма пар элементов: " + maxSum);
    }


    // вычисляем суммы пар элементов исходного массива
    public static double[] calcSum() {
        int n = numbers.length/2;
        double[] sum = new double[n];

        for(int i=0;i<n;i++){
            sum[i] = numbers[i] + numbers[n*2-1-i];
        }
        return sum;
    }

    // вычисляем максимальный элемент массива
    public static double maxValue(double[] values) {
        double maxValue = values[0];

        for(double value: values){
            if(value > maxValue) {
                maxValue = value;
            }
        }
        return maxValue;
    }


}
