package javase01_intro.t05;

public class Task5 {

    // размер массива
    public static int N = 7;

    public static void main(String[] args) {

        // матрица, которую нужно заполнить
        int[][] doubleArray = new int[N][N];

        // генерируем матрицу
        for(int i=0;i<=N/2;i++){
            // генерируем одномерный массив
            int[] singleArray = getArray(N,i);

            // заполняем строки матрицы полученным одномерным массивом
            doubleArray[i]=singleArray;
            doubleArray[N-1-i]=singleArray;
        }

        // распечатываем матрицу
        printDoubleArray(doubleArray);
    }

    // генерируем одномерный массив с двумя симметричными единицами (пример: 0100010)
    // size - размер массива
    // startPosition - порядковый номер первой единицы
    public static int[] getArray(int size, int startPosition) {
        int[] array = new int[size];
        array[startPosition]=1;
        array[size-1-startPosition]=1;
        return array;
    }

    // распечатываем в строчку все элементы одномерного массива
    public static void printSingleArray(int[] array) {

        //System.out.print(Arrays.toString(array));
        for(int i: array){
            System.out.print(i + " ");
        }
    }

    // распечатываем в таблице все элементы двумерного массива
    public static void printDoubleArray(int[][] array) {
        for(int i[]: array){
            printSingleArray(i);
            System.out.println("");
        }
    }

}
