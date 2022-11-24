import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class School {

private String name;
    private List<Student> studentList = new ArrayList<>();
    private List<Teacher> teacherList = new ArrayList<>();
    private List<Course> courseList = new ArrayList<>();



    public School(String name) {
        setName(name);
    }


    public void enrollData() {

        Scanner scanner = new Scanner(System.in);

        //show lists

        System.out.println("List of students: ");
        System.out.println(studentList.toString());
        System.out.println(" ");
        System.out.println("List of courses: ");
        System.out.println(courseList.toString());

        //get data

        System.out.println("Specify Student Id:");
        String studentId = scanner.nextLine();
        System.out.println("Specify Course Id:");
        String courseId = scanner.nextLine();

        //apply method

        enroll(studentId, courseId);


    }

    public void assignData() {


        Scanner scanner = new Scanner(System.in);

        //show lists

        System.out.println("List of teachers: ");
        System.out.println(teacherList.toString());
        System.out.println(" ");
        System.out.println("List of courses: ");
        System.out.println(courseList.toString());

        //get data

        System.out.println("Specify Teacher Id:");
        String teacherId = scanner.nextLine();
        System.out.println("Specify Course Id:");
        String courseId = scanner.nextLine();

        //apply method

        assign(teacherId, courseId);


    }

    public void enroll(String studentId, String courseId) {

        Student student = lookUpStudent(studentId);
        Course course = lookUpCourse(courseId);
        course.getStudentListCourse().add(student);
        student.getCourseListOfStudent().add(course);
        course.setMoney_earned(course.getMoney_earned() + course.getPrice());
        System.out.println("The student with id " + studentId +
                " has been enrolled in the course with id " + courseId);

    }

    public void assign(String teacherId, String courseId) {

        if (courseId.isBlank()|| teacherId.isBlank()) throw new IllegalArgumentException("Please, introduce ID");

        Teacher teacher = lookUpTeacher(teacherId);
        Course course = lookUpCourse(courseId);
        course.setTeacher(teacher);
        teacher.getCourseListOfTeacher().add(course);
        System.out.println("The teacher with id " + teacherId +
                " has been enrolled in the course with id " + courseId);
    }

    public Course lookUpCourse(String courseId) {


        for (int i = 0; i < getCourseList().size(); i++) {

            if (courseId.equalsIgnoreCase(getCourseList().get(i).getId())) {

                return getCourseList().get(i);

            }
        }

        throw new IllegalArgumentException("The id does not exists.");
    }


    public Student lookUpStudent(String studentId) {


        for (int i = 0; i < getStudentList().size(); i++) {


            if (studentId.equalsIgnoreCase(getStudentList().get(i).getId())) {

                return getStudentList().get(i);

            }
        }
        throw new IllegalArgumentException("The id does not exists.");


    }


    public Teacher lookUpTeacher(String teacherId) {


        for (int i = 0; i < getTeacherList().size(); i++) {

            if (teacherId.equalsIgnoreCase(getTeacherList().get(i).getId())) {

                return getTeacherList().get(i);

            }

        }
        throw new IllegalArgumentException("The id does not exists.");

    }

    public void getDataTeacher() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Specify Teacher Id:");
        String teacherId = scanner.nextLine();

        System.out.println(lookUpTeacher(teacherId));

    }

    public void getDataCourse() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Specify Course Id:");
        String courseId = scanner.nextLine();

        System.out.println(lookUpCourse(courseId));

    }

    public void getDataStudent() {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Specify Student Id:");
        String studentId = scanner.nextLine();

        System.out.println(lookUpStudent(studentId));

    }

    public double showProfit() {

        double earnings = 0;
        double salaries = 0;


        for (Course course : courseList) {

            earnings += course.getMoney_earned();
        }

        for (Teacher teacher : teacherList) {

            salaries += teacher.getSalary();

        }
        return earnings - salaries;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(List<Student> studentList) {
        this.studentList = studentList;
    }

    public List<Teacher> getTeacherList() {
        return teacherList;
    }

    public void setTeacherList(List<Teacher> teacherList) {
        this.teacherList = teacherList;
    }

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }
}
