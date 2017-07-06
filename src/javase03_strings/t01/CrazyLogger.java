package javase03_strings.t01;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;

public class CrazyLogger {
    private StringBuilder logText;
    //private Formatter formatter;

    // текущая дата-время в строковом формате
    private String getNowString(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy : HH-mm");
        return sdf.format(date);
    }

    // создание нового лога (добавляем запись "logger started")
    public CrazyLogger(){
        //this.formatter = formatter;
        this.logText =  new StringBuilder(getNowString() + " - logger started;");
    }

    // добавляем запись в лог
    public void addMessage(String messageText) {
        this.logText.append(getNowString() + " - " +  messageText + ";");
    }

    // возвращаем весь текст лога
    public String getLogText() {
        return logText.toString().replace(";",";\n");
    }


    // возвращаем записи в логе, содержащие текст messageText
    public String find(String messageText){
        StringBuilder result = new StringBuilder("");
        String[] messages = this.logText.toString().split(";");

        for(String message: messages){
            if(message.contains(messageText)){result.append(message + ";\n");}
        }
        return result.toString();
    }

    // выводим текст в заданный поток
    public void printOut(String text, Formatter formatter){
        formatter.format(text);
    }

}
