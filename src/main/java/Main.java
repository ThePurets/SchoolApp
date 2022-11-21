import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    /*private static List<String> getInputData(String... questions) {
        Scanner scanner = new Scanner(System.in);
        List<String> inputData = new ArrayList<>();
        for(String question: questions) {
            System.out.println("Introduce your mail: \n");
            inputData.add(scanner.next());
        }

        return inputData;
    }*/


    public static void main(String[] args) {


      /*  List<String> employeeData = getInputData("Birnak", "Domar", "Ruppert");

        System.out.println(employeeData);*/





        //creamos curso
        Course course = new Course("34", "History",45.6);
        Course course1 = new Course("35", "Math",45.6);
        Course course2 = new Course("36", "Biology",45.6);

        //creamos estudiantes
        Student st1 = new Student("Jonás", "Calle Princesa", "jonas@arroba");
        Student st2 = new Student("Borla", "Calle Barcelona", "borla@arroba");
        Student st3 = new Student("James", "Calle Provenza", "jams@arroba");

        //creamos profesor
        Teacher t1 = new Teacher("Manolo", 2300);

        //creamos escuela
        School school = new School("IronHack");

        //añadimos cursos a la escuela
        school.getCourseList().add(course);
        school.getCourseList().add(course1);
        school.getCourseList().add(course2);

        //añadimos estudiantes a la escuela
        school.getStudentList().add(st1);
        school.getStudentList().add(st2);
        school.getStudentList().add(st3);

        //añadimos profesor a la escuela
        school.getTeacherList().add(t1);


        //List<Student> studentList = new ArrayList<>();

        //studentList.add(st1);
        //studentList.add(st2);
        //studentList.add(st3);


        System.out.println("StudentList in School:");
        System.out.println(school.getStudentList().toString());

        //course.getStudentList().add(st1);
        System.out.println("");

        System.out.println("Courses in School: ");
        System.out.println(school.getCourseList().toString());

        System.out.println("");
        //school.enroll(st1.getId(), course.getId());

        System.out.println("student id: ");
        System.out.println(st1.getId().toString());

        System.out.println("");


        System.out.println("CourseId: ");
        System.out.println(course.getId());

        System.out.println("");


        System.out.println("We add an student with id " + st1.getId() + "in the course with id " + course.getId());
        school.enroll(st1.getId(),course.getId());

        System.out.println("We add an student with id " + st2.getId() + "in the course with id " + course.getId());
        school.enroll(st2.getId(),course.getId());

        System.out.println("");


        System.out.println("StudentList in course: ");
        System.out.println(course.getStudentListCourse());

        //System.out.println(course.getStudentList().toString());

        System.out.println("");

        System.out.println(("We assign a teacher with id " + t1.getId() + " to the course with id " + course.getId()));
        school.assign(t1.getId(),course.getId());

        System.out.println("The teacher of the course with id " + course.getId() + " is the teacher " + course.getTeacher());

        //System.out.println(course.toString());
        System.out.println("");

        System.out.println("Print info of course with id " + course.getId());
        System.out.println(school.lookUpCourse(course.getId()));

        System.out.println("Set teacher:");

        course.setTeacher(t1);

        System.out.println(course.toString());


        System.out.println("look up for a student: ");
        System.out.println(school.lookUpStudent(st1.getId()));

        System.out.println("Show profits: ");
        System.out.println(school.showProfit());

    }
}
