package javase02_oop.t05;

public class Student {
    private String name;
    private String dateOfBirth;

    Student(String name, String dateOfBirth){
        this.name = name;
        this.dateOfBirth = dateOfBirth;
    }






    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }
}
