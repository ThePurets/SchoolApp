import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Teacher extends Person {

    private double salary;

    private List<Course> courseListOfTeacher = new ArrayList<>();

    public Teacher(String name, double salary) {
        super(name);
        setSalary(salary);

    }

    public Teacher(){

    }
    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public List<Course> getCourseListOfTeacher() {
        return courseListOfTeacher;
    }

    public void setCourseListOfTeacher(List<Course> courseListOfTeacher) {
        this.courseListOfTeacher = courseListOfTeacher;
    }

    @Override
    public String toString() {

        return super.toString() +
                "salary=" + salary +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Teacher teacher = (Teacher) o;
        return Double.compare(teacher.salary, salary) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), salary);
    }
}
