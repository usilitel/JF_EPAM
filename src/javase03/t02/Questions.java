package javase03.t02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class Questions {

    public static void main(String[] args) {
        String language = "", country = "";

        System.out.println("Выберите язык: 1 = english, любой символ = русский");
        System.out.print(">>");
        char i = 0;

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            i = reader.readLine().charAt(0);
        }
        catch (Exception x)
        {
            //x.printStackTrace();
        }


        switch (i) {
            case '1':
                language = "en";
                country = "US";
                break;
            default :
                language = "ru";
                country = "RU";
                break;
        }

        Locale current = new Locale(language, country);
        ResourceBundle resourceBundleQuestions = ResourceBundle.getBundle("questions", current);
        ResourceBundle resourceBundleAnswers = ResourceBundle.getBundle("answers", current);

        System.out.println(getResourceValue(resourceBundleAnswers, "header"));

        // выводим список вопросов
        for(int j=1;j <= resourceBundleQuestions.keySet().size(); j++){
            System.out.println(getResourceValue(resourceBundleQuestions, "question" + j));
        }

        // спрашиваем номер вопроса до тех пор, пока пользователь не введет 0
        while(!inputQuestionNumber(resourceBundleAnswers).equals("0")){        }
    }

    // ввод номера вопроса
    public static String inputQuestionNumber(ResourceBundle resourceBundle){
        String line = null;
        System.out.print(getResourceValue(resourceBundle, "enterNumberText"));
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            line = reader.readLine();

            try{
                System.out.println(getResourceValue(resourceBundle, "answerText") + " " + line + ": " + getResourceValue(resourceBundle, "answer" + line));
            }
            catch (MissingResourceException e) {
                if(line.equals("0")==false)
                    System.out.println(getResourceValue(resourceBundle, "wrongNumberText"));
            }
        }
        catch (Exception x)
        {
            x.printStackTrace();
        }

        return line;
    }

    // возвращаем значение resourceBundle по ключу (в т.ч. для нелатинских  символов)
    public static String getResourceValue(ResourceBundle resourceBundle, String key){
        String valueTemp = resourceBundle.getString(key);
        String value = "";
        try {
            value = new String(valueTemp.getBytes("ISO-8859-1"), "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return value;
    }
}
