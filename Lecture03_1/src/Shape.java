public abstract class Shape {
    String name;
    abstract double getArea();
    abstract double getPerimeter();
    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name=name;
    }


}
