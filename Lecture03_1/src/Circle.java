public class Circle extends Shape {
    double radius;

    public Circle(double r){
        this.radius=r;
    }

    @Override
    double getArea() {

        return Math.PI*this.radius*this.radius;
    }

    @Override
    double getPerimeter() {
        return 2*Math.PI*this.radius;
    }
}
