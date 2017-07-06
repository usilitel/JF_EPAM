package javase02_oop.t05;

import java.util.ArrayList;

public class Group<T extends Number> {
    public Subject getSubject() {
        return subject;
    }

    private Subject subject;
    private ArrayList<StudentGrade> studentList = new ArrayList<StudentGrade>();

    Group(Subject subject){
        this.subject = subject;
    }

    public void addStudent(Student student, T grade){
        this.studentList.add(new StudentGrade(student, grade));
    }

    // возвращаем полный список студентов группы с оценками
    public String getStudentList(){
        String s = "";
        for(StudentGrade studentGrade: studentList){
            s += studentGrade.student.getName() + ": " + studentGrade.grade + "\n";
        }
        return s;
    }

    // возвращаем оценку заданного студента (null если нет такого студента в группе)
    public T getStudentGrade(Student student){
        T grade;

        for(StudentGrade studentGrade: studentList){
            if(studentGrade.student == student){ return studentGrade.grade;}
        }
        return null;
    }





    // внутренний класс для хранения оценок
    private class StudentGrade{
        public Student student;
        public T grade;

        StudentGrade(Student student, T grade){
            this.student = student;
            this.grade = grade;
        }
    }
}
