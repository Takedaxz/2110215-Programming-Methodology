import java.util.HashSet;

public class MyProgram {
    public static void main(String[] args) {
        EmptyClass e = new EmptyClass();

        System.out.println(e.toString());
        printClass(e);
        printClass(new Rectangle(4,5));

        HashSet<Course> c=new HashSet<Course>();
        c.add(new Course(2110215,"Prog Meth"));
        c.add(new Course(2110215,"Prog Meth"));
        c.add(new Course(2110215,"Prog Meth"));
        c.add(new Course(2110446,"DS"));
        System.out.println(c);

        Course c1=new Course(2110215,"Prog Meth");
        Course c2=new Course(c1);

        System.out.println(c2);

    }

    public static void printClass(Object o){
        if(o instanceof Shape){
            System.out.println(((Shape)o).getArea());
        }
        else{
            System.out.println(o.getClass());
        }
    }
}
