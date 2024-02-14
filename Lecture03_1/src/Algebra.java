import java.util.ArrayList;

public class Algebra {
    public static void main(String[] args) {
        Shape s=new Rectangle(4,5);
        ArrayList<Shape> shapes=new ArrayList<Shape>();
        shapes.add(new Rectangle(4,5));
        shapes.add(new Circle(5));
        shapes.add(new Rectangle(7,8));

        for(Shape x: shapes){
            System.out.println(x.getArea());
            if(x instanceof Circle)
                System.out.println(((Circle) x).radius);
        }
    }
}
