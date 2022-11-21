import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class School {

    private String name;
    private List<Student> studentList = new ArrayList<>();
    private List<Teacher> teacherList = new ArrayList<>();
    private List<Course> courseList = new ArrayList<>();

    public School(String name) {

        setName(name);
    }

    public void enroll(String studentId, String courseId) {


        //check if we have an student with this id

        for (Student student : studentList) {

            if (Objects.equals(studentId, student.getId())) {

                //check if we have a course with this id

                for (Course course : courseList) {

                    if (Objects.equals(courseId, course.getId())) {

                        //add the student to the course studentList

                        course.getStudentListCourse().add(student);

                        //add the course to the courseList of the student

                        student.getCourseListOfStudent().add(course);

                        //update variable money_earned

                        course.setMoney_earned(course.getMoney_earned() + course.getPrice());


                    }

                }

            }
        }

    }


    public void assign(String teacherId, String courseId) {

        //search teacher in teacherList
        for (int i = 0; i < getTeacherList().size(); i++) {

            if (teacherId.equalsIgnoreCase(getTeacherList().get(i).getId())) {

                //search course in courseList

                for (int j = 0; j < getCourseList().size(); j++) {

                    if (courseId.equalsIgnoreCase(getCourseList().get(j).getId())) {

                        //assign teacher to the course

                        getCourseList().get(j).setTeacher(getTeacherList().get(i));

                        //add course to the courseList of teacher

                        getTeacherList().get(i).getCourseListOfTeacher().add(getCourseList().get(j));
                    }
                }
            }
        }

    }

    public Course lookUpCourse(String courseId) {

        Course course = new Course();

        for (int i = 0; i < getCourseList().size(); i++) {

            if (courseId.equalsIgnoreCase(getCourseList().get(i).getId())) {

                course = getCourseList().get(i);
            }

        } return course;


    }

    public Student lookUpStudent(String studentId) {

      Student st = new Student();

        for (int i = 0; i < getStudentList().size(); i++) {

            if (studentId.equalsIgnoreCase(getStudentList().get(i).getId())) {

                st = getStudentList().get(i);
            }

        } return st;
    }




    public Teacher lookUpTeacher(String teacherId) {

        Teacher teacher = new Teacher();

        for (int i = 0; i < getTeacherList().size(); i++) {

            if (teacherId.equalsIgnoreCase(getTeacherList().get(i).getId())) {

                teacher = getTeacherList().get(i);
            }

        } return teacher;
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


    //los métodos SHOW() son los GETTERS de las listas


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
