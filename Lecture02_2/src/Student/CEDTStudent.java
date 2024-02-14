package Student;

public class CEDTStudent extends Student {

    String internCompany = "";

    @Override //เขียนทับ fn แม่
    public void printName() {
        System.out.println("I'm a CEDT student.");;
    }

    public String getInternCompany() {
        return internCompany;
    }

    public void setInternCompany(String internCompany) {
        this.internCompany = internCompany;
    }

    public CEDTStudent() {
        this.name="Pop";

    }
}
