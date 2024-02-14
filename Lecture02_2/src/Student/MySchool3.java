package Student;

public class MySchool3 {
    public static void main(String[] args) {
        Student s1 = new Student();
        giveSpecialGrade(s1);
        System.out.println(s1.getCourseGrade());

        Student s2 = new GraduateStudent("Pop");
        giveSpecialGrade(s2);
        System.out.println(s2.getCourseGrade());

        Student s3 = new UndergraduateStudent("Pie");
        giveSpecialGrade(s3);
        System.out.println(s3.getCourseGrade());

    }

    public static void giveSpecialGrade(Student s){
        if(s instanceof UndergraduateStudent){
            s.setCourseGrade("A++");
        }
        else s.setCourseGrade("F");
    }
}
