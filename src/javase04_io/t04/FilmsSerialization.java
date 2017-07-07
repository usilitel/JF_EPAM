package javase04_io.t04;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class FilmsSerialization {

    //ArrayList<String> actors = new ArrayList<>(); // актеры

    Map<Integer,String> actors = new TreeMap<>();
    Map<String,ArrayList<Integer>> films = new TreeMap<>();

    public static void main(String[] args) {
        FilmsSerialization filmsSerialization = new FilmsSerialization();

        try{
            filmsSerialization.start();
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

    public void start() throws Exception{
        fillData(); // заполняем данные о фильмах

        System.out.println("список актеров: " + actors.toString());
        System.out.println("список фильмов: " + films.toString());

        String filmsFileName = "resources\\filmsCollection.bin";
        String actorsFileName = "resources\\actorsCollection.bin";

        serializeObject(films, filmsFileName);
        serializeObject(actors, actorsFileName);

        films.clear();
        actors.clear();

        films = ((Map<String,ArrayList<Integer>>) restoreObject(filmsFileName));
        actors = ((Map<Integer,String>) restoreObject(actorsFileName));

        System.out.println("список актеров: " + actors.toString());
        System.out.println("список фильмов: " + films.toString());


    }

    // десериализуем объект из файла
    public Object restoreObject(String fileName) throws Exception {
        InputStream inputStream = new FileInputStream(fileName);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
        Object object = objectInputStream.readObject();
        System.out.println("Объект [" + object.getClass() + "] десериализован из файла [" + fileName + "]");
        return object;
    }

    // сериализуем объект в файл
    public void serializeObject(Object object, String fileName) throws IOException {
        OutputStream outputStream = new FileOutputStream(fileName);
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(object);
        System.out.println("Объект [" + object.getClass() + "] сериализован в файл [" + fileName + "]");
    }

    // заполняем данные о фильмах
    public void fillData() {
        actors.put(1, "Иванов");
        actors.put(2, "Петров");
        actors.put(3, "Сидоров");


        ArrayList<Integer> filmActors = new ArrayList<>();
        filmActors.add(1);
        filmActors.add(2);
        films.put("фильм1",filmActors);

        filmActors = new ArrayList<>(); //.clear();
        filmActors.add(1);
        filmActors.add(3);
        films.put("фильм2",filmActors);

        filmActors = new ArrayList<>(); //.clear();
        filmActors.add(2);
        filmActors.add(3);
        films.put("фильм3",filmActors);

    }



}
