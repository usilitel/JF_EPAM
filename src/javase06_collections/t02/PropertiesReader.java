package javase06_collections.t02;

import java.io.*;
import java.util.Map;
import java.util.Properties;
import java.util.TreeMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PropertiesReader {
    private static Map<String, String> values = new TreeMap<>();
    private static String fileName;


    public static void loadFile(String fileName){
        PropertiesReader.fileName = fileName;
        File file = new File(fileName);

        try{
            if (!file.exists()) {
                throw new IOException("невозможно прочитать файл [" + fileName + "], т.к. такой файл не существует.");
            }
            String textLine = "";
            String paramName = "";
            String paramValue = "";
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            Pattern p = Pattern.compile("([^=]+)\\s=\\s");
            Matcher m;
            while (true){
                textLine = reader.readLine();
                if (textLine != null){
                    m  = p.matcher(textLine);
                    if (m.find()){
                        paramName = m.group(1);
                        paramValue = textLine.substring(paramName.length() + 3);
                        values.put(paramName, paramValue);
                    }
                }
                else
                    break;
            }
            System.out.println("файл [" + fileName + "] загружен.");
        }
        catch (Exception e){
            System.out.println("Ошибка: " + e.getMessage());
            //e.printStackTrace();
        }

    }



    private static String getValueService(String key) throws IOException {
        String result = values.get(key);
        if (result == null)
            throw new IOException("в файле [" + fileName + "] нет ключа [" + key + "]");
        return result;
    }

    public static String getValue(String key) {
        String result = "";
        try{
            result = getValueService(key);
        }
        catch (IOException e){
            System.out.println("Ошибка: " + e.getMessage());
        }
        return result;
    }

}
