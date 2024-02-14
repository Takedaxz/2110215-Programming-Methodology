public class Rectangle extends Shape{
    double width;
    double height;

    public Rectangle(double w,double h){
        this.width=w;
        this.height=h;
    }

    @Override
    double getArea() {

        return this.width*this.height;
    }

    @Override
    double getPerimeter() {
        return 2*(this.width+this.height);
    }
}
