import java.util.ArrayList;
import java.util.List;

public class Course {

    private String id;
    private String name;
    private double price;
    private double money_earned;
    private Teacher teacher;
    List<Student> studentListCourse = new ArrayList<>();


    //no añadimos ni teacher ni studentList porque deben ser nullables
    public Course(String id, String name, double price) {
        setId(RandomClass.randomString());
        setName(name);
        setPrice(price);

        //añadir la actualización de money_earned en el constructor?

    }
    public Course(){

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getMoney_earned() {
        return money_earned;
    }

    public void setMoney_earned(double money_earned) {
        this.money_earned = money_earned;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public List<Student> getStudentListCourse() {
        return studentListCourse;
    }

    public void setStudentListCourse(List<Student> studentListCourse) {
        this.studentListCourse = studentListCourse;
    }

   @Override
    public String toString() {
        return "Course{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", money_earned=" + money_earned +
                ", teacher=" + teacher +
                ", studentList=" + studentListCourse +
                '}';
    }
}
