package javase04_io.t02;

import java.io.*;
import java.util.Map;
import java.util.TreeMap;

public class CharParser {
    Map<String, Integer> keyWords = new TreeMap<>(); // список ключевых слов Java

    public static void main(String[] args) {
        CharParser textParser = new CharParser();
        textParser.start();
    }

    public void start(){
        // заполняем список ключевых слов
        fillKeyWords();

        String inputFileName = "resources\\TextExampleInput.java";
        String outputFileName = "resources\\TextExampleOutput.txt";
        FileReader inFile = null;
        FileWriter outFile = null;

        // обрабатываем файл в потоке
        try{
            inFile = new FileReader(inputFileName);
            outFile = new FileWriter(outputFileName);
            listWords(inFile);

            // выводим список ключевых слов на экран
            String keyWords = getKeyWords();
            System.out.println("Список ключевых слов в файле [" + inputFileName + "]:");
            System.out.println(keyWords);
            //writeString(System.out, keyWords);

            // выводим список ключевых слов в файл
            writeString(outFile, keyWords);
            //System.out.println("");
            System.out.println("Список ключевых слов в файле [" + inputFileName + "] выведен в файл [" + outputFileName + "]");

            inFile.close();
            outFile.close();
        }
        catch (IOException e){
            e.printStackTrace();
        }

    }


    // выводим строку в символьный поток вывода
    public void writeString (Writer writer, String string) throws IOException{
        writer.write(string);
        writer.flush();
    }




    // выделяем слова из текста потока
    public void listWords (Reader reader) throws IOException{
        StringBuilder word = new StringBuilder("");
        char c = 0;
        int i = 0;

        while ((i = reader.read()) > 0){
            c = (char)i;
            //System.out.println(c);

            if (Character.isLetter(c)){
                word.append(c);
            }
            else {
                if (!word.equals("")){ // закончилось слово
                    checkKeyWord(word.toString());
                    word = new StringBuilder("");
                }
            }
        }

        if (!word.equals("")) // последнее слово в файле
            checkKeyWord(word.toString());
    }


    // проверяем является ли слово ключевым
    public void checkKeyWord(String word){
        if (keyWords.containsKey(word)){
            int i = keyWords.get(word);
            keyWords.replace(word,++i);
        }
    }

    // выводим список ключевых слов
    public String getKeyWords(){
        StringBuilder s = new StringBuilder("");

        for(String word: keyWords.keySet()){
            int i = keyWords.get(word);
            if (i > 0){
                s.append(word + ": " + i + "\n");
            }
        }
        return s.toString();
    }






    // заполняем список ключевых слов
    public void fillKeyWords(){
        keyWords.put("abstract",0);
        keyWords.put("assert",0);
        keyWords.put("boolean",0);
        keyWords.put("break",0);
        keyWords.put("byte",0);
        keyWords.put("case",0);
        keyWords.put("catch",0);
        keyWords.put("char",0);
        keyWords.put("class",0);
        keyWords.put("const",0);
        keyWords.put("continue",0);
        keyWords.put("default",0);
        keyWords.put("do",0);
        keyWords.put("double",0);
        keyWords.put("else",0);
        keyWords.put("enum",0);
        keyWords.put("extends",0);
        keyWords.put("final",0);
        keyWords.put("finally",0);
        keyWords.put("float",0);
        keyWords.put("for",0);
        keyWords.put("goto",0);
        keyWords.put("if",0);
        keyWords.put("implements",0);
        keyWords.put("import",0);
        keyWords.put("instanceof",0);
        keyWords.put("int",0);
        keyWords.put("interface",0);
        keyWords.put("long",0);
        keyWords.put("native",0);
        keyWords.put("new",0);
        keyWords.put("package",0);
        keyWords.put("private",0);
        keyWords.put("protected",0);
        keyWords.put("public",0);
        keyWords.put("return",0);
        keyWords.put("short",0);
        keyWords.put("static",0);
        keyWords.put("strictfp",0);
        keyWords.put("super",0);
        keyWords.put("switch",0);
        keyWords.put("synchronized",0);
        keyWords.put("this",0);
        keyWords.put("throw",0);
        keyWords.put("throws",0);
        keyWords.put("transient",0);
        keyWords.put("try",0);
        keyWords.put("void",0);
        keyWords.put("volatile",0);
        keyWords.put("while",0);
        keyWords.put("true",0);
        keyWords.put("false",0);
        keyWords.put("null",0);
    }

}

