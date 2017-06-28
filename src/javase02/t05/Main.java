package javase02.t05;

import java.util.ArrayList;

public class Main {

    // список групп
    public ArrayList<Group> groupList = new ArrayList<Group>();
    public ArrayList<Student> studentList = new ArrayList<Student>();


    public static void main(String[] args) {
        Main main = new Main();
        main.start();
    }

    public void start(){
        // формируем список студентов
        studentList.add(new Student("Ivanov","01.01.2010"));
        studentList.add(new Student("Petrov","02.01.2010"));
        studentList.add(new Student("Sidorov","03.01.2010"));

        // формируем группы
        groupList.add(new Group(Subject.mathematics));
        groupList.add(new Group(Subject.physics));
        groupList.add(new Group(Subject.chemistry));

        // добавляем студентов в группы
        groupList.get(0).addStudent(studentList.get(0), 3); // Ivanov -> mathematics
        groupList.get(0).addStudent(studentList.get(1), 3); // Petrov -> mathematics
        groupList.get(0).addStudent(studentList.get(2), 3); // Sidorov -> mathematics

        groupList.get(1).addStudent(studentList.get(0), 4.0); // Ivanov -> physics
        groupList.get(1).addStudent(studentList.get(1), 4.0); // Petrov -> physics

        groupList.get(2).addStudent(studentList.get(1), 5.0); // Petrov -> chemistry
        groupList.get(2).addStudent(studentList.get(2), 5.0); // Sidorov -> chemistry

        // выводим группы студентов и их оценки
        for(Student student: studentList){
            System.out.println(student.getName() + "'s grades:");
            System.out.println(getStudentGroups(student));
        }
    }


    // возвращаем список групп, в которых есть студент (с оценками)
    public String getStudentGroups(Student student){
        String result = "";
        for(Group group: groupList){
            Number studentGrade = group.getStudentGrade(student);
            if(studentGrade != null){ result += group.getSubject() + ": " + studentGrade + "\n";}
        }
        return result;
    }

}
