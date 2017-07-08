package javase05_exceptions.t01;

public class FileManagerExample {
    public static void main(String[] args) {
        FileManager fileManager = new FileManager();

        fileManager.listDir("C:\\gradle-3.5"); // просмотр содержимого дректории

        fileManager.deleteFile("C:\\projects\\JF_EPAM\\resources\\1.txt"); // удаление файла
        fileManager.createFile("C:\\projects\\JF_EPAM\\resources\\1.txt"); // создание файла

        fileManager.writeFile("C:\\projects\\JF_EPAM\\resources\\1.txt", "текст 1 ", false); // запись в текстовый файл
        fileManager.writeFile("C:\\projects\\JF_EPAM\\resources\\1.txt", "текст 2", true); // дозапись в текстовый файл

    }
}
