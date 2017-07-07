package javase04_io.t03;

import java.io.*;

public class TextTranslator {

    public static void main(String[] args) {
        TextTranslator textTranslator = new TextTranslator();
        try {
            textTranslator.start();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }


    public void start() throws IOException{
        String inputFileName = "resources\\TextExampleInput_utf8.txt";
        String outputFileName = "resources\\TextExampleOutput_utf16.txt";
        Reader inFile = null;
        FileWriter outFile = null;
        char[] c = new char[100];

        Reader fileReader = new InputStreamReader(new FileInputStream(inputFileName),"UTF-8");
        fileReader.read(c);
        String s = String.copyValueOf(c);

        Writer fileWriter = new OutputStreamWriter(new FileOutputStream(outputFileName),"UTF-16");
        fileWriter.write(s);

        System.out.println("Текст из файла [" + inputFileName + "] выведен в файл [" + outputFileName + "]");

        fileReader.close();
        fileWriter.close();
    }

}
