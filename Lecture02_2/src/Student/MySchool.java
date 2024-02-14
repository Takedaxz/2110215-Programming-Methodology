package Student;

public class MySchool {
    public static void main(String[] args) {
        Student s1 = new Student();

        //ลูกทุกตัว is a เป็นแม่ แต่จะใช้ได้เท่าที่ แม่ Student มีเท่านั้น
        Student s2 = new CEDTStudent();
        Student s3 = new UndergraduateStudent("Pop");
        //แม่ใส่ลูกต้อง cast ระวัง error
        CEDTStudent d1 = (CEDTStudent) s2;
        d1.internCompany = "Google";

        //แม่ใส่ลูกต้อง cast ระวัง error
        //CEDTStudent d2 = (CEDTStudent) s1;
        //d2.internCompany = "Facebook";

    }


}
