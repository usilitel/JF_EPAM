package javase05_exceptions.t01;

import java.io.*;
import java.util.Arrays;

public class FileManager {

    // просмотр содержимого дректории
    private void listDirService(String pathname) throws IOException {
        File path;
        String[] fileNames;
        System.out.print("--> ");

        path = new File(pathname);

        if (!path.exists()) {
            throw new IOException("[" + pathname + "]: директория не существует");
        }

        if (path.isFile())
            throw new IOException("[" + pathname + "] не является директорией");

        fileNames = path.list();
        Arrays.sort(fileNames);
        System.out.println("содержимое директории [" + pathname + "]:");
        for(String fileName: fileNames)
            System.out.println(fileName);
    }


    // просмотр содержимого дректории
    public void listDir(String pathname) {
        try{
            listDirService(pathname);
        }
        catch (Exception e){
            System.out.println("Ошибка: " + e.getMessage());
        }
    }




    // создание текстового файла
    private void createFileService(String fileName) throws IOException {
        System.out.print("--> ");
        File file = new File(fileName);

        if (file.exists()) {
            throw new IOException("невозможно содать файл [" + fileName + "], т.к. такой файл уже существует.");
        }

        file.createNewFile();
        System.out.println("файл [" + fileName + "] создан.");
    }


    // просмотр содержимого дректории
    public void createFile(String fileName) {
        try{
            createFileService(fileName);
        }
        catch (Exception e){
            System.out.println("Ошибка: " + e.getMessage());
        }
    }





    // создание текстового файла
    private void deleteFileService(String fileName) throws IOException {
        System.out.print("--> ");
        File file = new File(fileName);

        if (!file.exists()) {
            throw new IOException("невозможно удалить файл [" + fileName + "], т.к. такой файл не существует.");
        }

        file.delete();
        System.out.println("файл [" + fileName + "] удален.");
    }


    // просмотр содержимого дректории
    public void deleteFile(String fileName) {
        try{
            deleteFileService(fileName);
        }
        catch (Exception e){
            System.out.println("Ошибка: " + e.getMessage());
        }
    }





    // запись текстового файла
    private void writeFileService(String fileName, String text, boolean append) throws IOException {
        System.out.print("--> ");
        File file = new File(fileName);

        if (!file.exists()) {
            throw new IOException("невозможно записать в файл [" + fileName + "], т.к. такой файл не существует.");
        }

        Writer fileWriter = new OutputStreamWriter(new FileOutputStream(fileName, append),"Windows-1251");
        fileWriter.write(text);
        //fileWriter.append(text);
        fileWriter.close();

        System.out.println("текст записан в файл [" + fileName + "].");
    }


    // запись текстового файла
    public void writeFile(String fileName, String text, boolean append) {
        try{
            writeFileService(fileName, text, append);
        }
        catch (Exception e){
            System.out.println("Ошибка: " + e.getMessage());
        }
    }

}
