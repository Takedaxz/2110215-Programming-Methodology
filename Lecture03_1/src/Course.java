import java.util.Objects;

public class Course {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        if(id<0)
            this.id=2110000;
        else if(id/1000000<1)
            this.id=2110000;
        else
            this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Course(int id, String name){
        this.id=id;
        this.name=name;
    }
    //copy constructor
    public Course(Course o){
        this(o.id,o.name);

    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Course course = (Course) o;

        return id == course.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
