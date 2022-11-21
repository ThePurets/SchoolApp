import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Student extends Person {

    private String address;
    private String email;
    private List<Course> courseListOfStudent = new ArrayList<>();

    public Student(String name, String address, String email) {
        super(name);
        setAddress(address);
        setEmail(email);
    }

    public Student(String name) {
        super(name);
    }

    public Student() {
        super();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Course> getCourseListOfStudent() {
        return courseListOfStudent;
    }

    public void setCourseListOfStudent(List<Course> courseListOfStudent) {
        this.courseListOfStudent = courseListOfStudent;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Student student = (Student) o;
        return Objects.equals(address, student.address) && Objects.equals(email, student.email) && Objects.equals(courseListOfStudent, student.courseListOfStudent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), address, email, courseListOfStudent);
    }
}
