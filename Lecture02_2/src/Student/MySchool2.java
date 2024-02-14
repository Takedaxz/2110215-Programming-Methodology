package Student;

import java.util.ArrayList;

public class MySchool2 {
    public static void main(String[] args) {
        Student s1 = new Student();
        s1.printName();

        GraduateStudent g1 = new GraduateStudent("Pop");
        g1.printName();

        UndergraduateStudent u1 = new UndergraduateStudent("Toe");
        u1.printName();

        Student s2 = new UndergraduateStudent("Time");
        s2.printName();

        Student s3 = new GraduateStudent("Pie");
        s3.printName();
        //ผลลัพธ์ขึ้นกับ object ที่สร้างขึ้น
        //polymorphism -> same code different action

        ArrayList<Student> students = new ArrayList<Student>();
        students.add(new Student());
        students.add(new UndergraduateStudent("Pop"));
        students.add(new GraduateStudent("Toe"));
        students.add(new GraduateStudent("Fern"));

        for(Student s : students){
            s.printName(); //same code different action //shorter code //polymorphism
        }



    }
}
