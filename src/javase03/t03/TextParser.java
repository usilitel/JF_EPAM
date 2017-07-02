package javase03.t03;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.io.File;
import java.io.IOException;


public class TextParser {

    static StringBuilder messageText;

    public static void main(String[] args) throws IOException {

        //String fileName = "src\\javase03\\t03\\Java.SE.03.Information handling_task_attachment.html";
        String fileName = "resources\\Java.SE.03.Information handling_task_attachment.html";
        String fileText = getFileText(fileName);

        System.out.println("");
        System.out.println("Ссылки на рисунки:");
        printPictures(fileText);

        System.out.println("");
        System.out.println("Предложения, в которых встречаются ссылки на рисунки:");
        printSentences(fileText);
    }


    // выделяем в тексте все предложения, в которых встречаются ссылки на рисунки
    public static void printPictures(String fileText){
        // минимальный и максимальный номера рисунков (нужны для определения порядка рисунков)
        String[] minMaxNumbersPrevious = {"",""};
        String[] minMaxNumbersCurrent = {"",""};

        Pattern p = Pattern.compile("\\(Рис\\.\\s([^\\)]+)\\)", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(fileText);
        int i = 1;
        while (m.find()) {
            messageText = new StringBuilder(i + ". ");
            messageText.append("ссылка на рисунок: '" + m.group(0) + "' найдена на позиции " + m.start(0) + "-" + m.end(0) + ". ");
            messageText.append("Номер рисунка: ");
            minMaxNumbersCurrent = getMinMaxNumbers(getNumbers(m.group(1) + ")"));
            messageText.append(". ");

            // определяем порядок  следования рисунков в тексте
            if (comparePictureNumbers(minMaxNumbersCurrent[0],minMaxNumbersPrevious[1])>=0) // минимальный текущий номер рисунка >= максимального предыдущего номера рисунка
            {messageText.append("Порядок ссылок: последовательно.");}
            else
            {messageText.append("Порядок ссылок: НЕПОСЛЕДОВАТЕЛЬНО.");}

            minMaxNumbersPrevious = minMaxNumbersCurrent;
            System.out.println(messageText);
            i++;
        }
    }


    // получаем текст файла
    public static String getFileText (String fileName) throws FileNotFoundException, IOException {
        char[] cbuf;

        // узнаем размер файла в байтах
        File f = new File(fileName);
        long fileSize = f.length();

        // считываем файл в массив байтов
        InputStreamReader isrBE = new InputStreamReader(new FileInputStream(fileName), "windows-1251");
        cbuf = new char[(int)fileSize];
        isrBE.read(cbuf);
        isrBE.close();

        return new String(cbuf);
    }


    // выделяем в тексте все предложения, в которых встречаются ссылки на рисунки
    public static void printSentences(String fileText){
        Pattern p = Pattern.compile("([А-ЯA-Z]((т.п.|т.д.|пр.)|[^?!.\\(]|\\([^\\)]*\\))*(\\(Рис\\.\\s([^\\)]+)\\))((т.п.|т.д.|пр.)|[^?!.\\(]|\\([^\\)]*\\))*[.?!])");
        Matcher m = p.matcher(fileText);
        int i = 1;
        while (m.find()) {
            messageText = new StringBuilder(i + ". " + m.group(0));
            System.out.println(messageText);
            i++;
        }
    }




    // выбираем из массива строк минимальный и максимальный номер рисунка
    public static String[] getMinMaxNumbers(ArrayList<String> numbersStr){
        String[] minMaxNumbers = {numbersStr.get(0),numbersStr.get(0)};
        for(String s: numbersStr){
            if(comparePictureNumbers(s, minMaxNumbers[0])==-1) minMaxNumbers[0]=s;
            if(comparePictureNumbers(s, minMaxNumbers[1])== 1) minMaxNumbers[1]=s;
        }
        return minMaxNumbers;
    }



    // сравниваем 2 номера (1,2,8-б,...). [-1] = str1<str2, [1] = str1>str2, [0] = str1=str2
    public static int comparePictureNumbers(String str1, String str2){
        if(str1.equals(str2)) return 0;
        int int1=getNumericPart(str1);
        int int2=getNumericPart(str2);
        if(int1<int2) return -1;
        if(int1>int2) return 1;
        return str1.compareTo(str2);
    }

    // выбираем первую (числовую) часть из строки
    public static int getNumericPart(String str){
        Pattern p = Pattern.compile("\\d+", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(str);

        if(m.find())
            return Integer.parseInt(m.group(0));
        else
            return 0;
    }


    // возвращаем массив строк со всеми номерами рисунков в строке
    public static ArrayList<String> getNumbers(String str){
        //System.out.println("'"+str+"'");
        int i=0;
        ArrayList<String> Numbers = new ArrayList<String>();
        Pattern p = Pattern.compile("([0-9]*(\\s|\\-|[а-я])*)(\\,|( и )|\\))", Pattern.CASE_INSENSITIVE);
        Matcher m = p.matcher(str);

        while (m.find()) {
            String s = m.group(1);

            // если указана только буква - берем цифру из предыдущего номера
            if (s.matches("[а-я]")){
                s = Numbers.get(i-1).substring(0,Numbers.get(i-1).length()-1) + s;
            }
            Numbers.add(s);
            //System.out.println("Found '" + Numbers.get(i) + "' at position " + m.start(0) + "-" + m.end(0));
            messageText.append(Numbers.get(i) + ",");
            i++;
        }
        messageText.deleteCharAt(messageText.length()-1);
        return Numbers;
    }


/*

        // еще один рабочий вариант чтения файла
        //String fileText = readUsingScanner("src\\javase03\\t03\\0.html");

    // читаем файл с помощью Scanner
    private static String readUsingScanner(String fileName) throws IOException {
        Scanner scanner = new Scanner(Paths.get(fileName), "windows-1251");
        //здесь мы можем использовать разделитель, например: "\\A", "\\Z" или "\\z"
        String data = scanner.useDelimiter("\\A").next();
        scanner.close();
        return data;
    }


    // считываем содержимое файла в String с помощью BufferedReader
    private static String readUsingBufferedReader(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader( new FileReader(fileName));
        String line = null;
        StringBuilder stringBuilder = new StringBuilder();
        String ls = System.getProperty("line.separator");
        while( ( line = reader.readLine() ) != null ) {
            stringBuilder.append( line );
            stringBuilder.append( ls );
        }

        stringBuilder.deleteCharAt(stringBuilder.length()-1);
        return stringBuilder.toString();
    }

    // читаем файл в строку с помощью класса Files
    private static String readUsingFiles(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    // считываем содержимое файла с помощью Apache Commons IO
//    private static String readUsingApacheCommonsIO(String fileName) throws IOException {
//        return FileUtils.readFileToString(new File(fileName), StandardCharsets.UTF_8);
//    }



*/

}
