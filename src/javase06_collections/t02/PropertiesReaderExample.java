package javase06_collections.t02;

public class PropertiesReaderExample {
    public static void main(String[] args) {

        System.out.println("---");
        PropertiesReader.loadFile("resources\\test1.properties");

        System.out.println("---");
        System.out.println("значение поля header:");
        System.out.println(PropertiesReader.getValue("header"));

        System.out.println("---");
        System.out.println("значение поля header1:");
        System.out.println(PropertiesReader.getValue("header1"));


    }

}
