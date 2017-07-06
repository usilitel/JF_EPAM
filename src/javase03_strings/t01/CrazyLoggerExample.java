package javase03_strings.t01;

import java.util.Formatter;

// тестируем класс CrazyLogger
public class CrazyLoggerExample {
    public static void main(String[] args) {
        CrazyLogger logger = new CrazyLogger();
        logger.addMessage("test1");
        logger.addMessage("test2");

        Formatter formatter;

        // выводим весь лог в поток System.err
        formatter = new Formatter(System.err);
        formatter.format("весь лог:\n");
        logger.printOut(logger.getLogText(), formatter);
        //System.err.println("весь лог:");
        //System.err.println(logger.getLogText());

        // выводим сообщения содержащие test в поток System.out
        formatter = new Formatter(System.out);
        formatter.format("сообщения содержащие test:\n");
        logger.printOut(logger.find("test"), formatter);
        //System.out.println("сообщения содержащие test:");
        //System.out.println(logger.find("test"));
    }

}
