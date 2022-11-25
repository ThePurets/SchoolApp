import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class SchoolTest {

    Course course;
    Student st1;
    Teacher t1;
    School school;


    @BeforeEach
    void setUp(){
        course = new Course( "","History",45.6);
        st1 = new Student("Jonás", "Calle Princesa", "jonas@arroba");
        t1 = new Teacher("Manolo", 2300);
        school = new School("IronHack");


        List<Student> studentList = new ArrayList<>();
        studentList.add(st1);
        List<Teacher> teacherList = new ArrayList<>();
        teacherList.add(t1);
        List<Course> courseList = new ArrayList<>();
        courseList.add(course);


        school.setStudentList(studentList);
        school.setCourseList(courseList);
        school.setTeacherList(teacherList);
    }


    @Test
    void school_name_ok(){
        assertEquals("IronHack", school.getName());
    }

    @Test
    void school_name(){
        //Empty, or spacing School Name:
        assertThrows(IllegalArgumentException.class, ()->new School("") );
        assertThrows(IllegalArgumentException.class, ()->new School(" ") );
    }

    @Test
    void enroll_student_ok(){
        school.enroll(st1.getId(),course.getId());
        assertEquals(1,course.getStudentListCourse().size());
    }

    @Test
    void enroll_student_exception(){
        //Empty or spacing Student ID:
        assertThrows(IllegalArgumentException.class, ()-> school.enroll("", course.getId()));
        assertThrows(IllegalArgumentException.class, ()-> school.enroll(" ",course.getId()));


        //Empty or spacing Course ID:
        assertThrows(IllegalArgumentException.class, ()-> school.enroll(st1.getId(),""));
        assertThrows(IllegalArgumentException.class, ()-> school.enroll(st1.getId()," "));

        //Non Existing Student ID:
        assertThrows(IllegalArgumentException.class, ()-> school.enroll("999999999",course.getId()));
        //Non Existing Course ID:
        assertThrows(IllegalArgumentException.class, ()-> school.enroll(st1.getId(),"999999999"));
    }

    @Test
    void assign_Teacher_OK(){
        school.assign(t1.getId(),course.getId());
        assertEquals(t1.getId(),course.getTeacher().getId());
    }

    @Test
    void assign_teacher_exception(){
        //Empty or spacing Teacher ID:
        assertThrows(IllegalArgumentException.class, ()-> school.assign("",course.getId()));
        assertThrows(IllegalArgumentException.class, ()-> school.assign(" ",course.getId()));

        //Empty or spacing Teacher ID:
        assertThrows(IllegalArgumentException.class, ()-> school.assign(t1.getId(), ""));
        assertThrows(IllegalArgumentException.class, ()-> school.assign(t1.getId()," "));

        //Non Existing Teacher ID:
        assertThrows(IllegalArgumentException.class, ()-> school.assign("999999999",course.getId()));
        //Non Existing Course ID:
        assertThrows(IllegalArgumentException.class, ()-> school.assign(t1.getId(),"999999999"));
    }

    @Test
    void lookUpCourse_ok(){
        assertEquals(course, school.lookUpCourse(course.getId()));
    }

    @Test
    void lookUpCourse_exception(){
        //Empty or spacing Course ID:
        assertThrows(IllegalArgumentException.class, ()-> school.lookUpCourse(""));
        assertThrows(IllegalArgumentException.class, ()-> school.lookUpCourse(" "));

        //Non Existing Course ID:
        assertThrows(IllegalArgumentException.class, ()-> school.lookUpCourse("999999999"));
    }

    @Test
    void lookUpStudent_ok(){
        assertEquals(st1, school.lookUpStudent(st1.getId()));
    }

    @Test
    void lookUpStudent_exception(){
        //Empty, spacing or null Student ID:
        assertThrows(IllegalArgumentException.class, ()-> school.lookUpStudent(""));
        assertThrows(IllegalArgumentException.class, ()-> school.lookUpStudent(" "));

        //Non Existing Student ID:
        assertThrows(IllegalArgumentException.class, ()-> school.lookUpStudent("999999999"));
    }

    @Test
    void lookUpTeacher_ok(){
        assertEquals(t1, school.lookUpTeacher(t1.getId()));
    }

    @Test
    void lookUpTeacher_exception(){
        //Empty, spacing or null Teacher ID:
        assertThrows(IllegalArgumentException.class, ()-> school.lookUpTeacher(""));
        assertThrows(IllegalArgumentException.class, ()-> school.lookUpTeacher(" "));

        //Non Existing Teacher ID:
        assertThrows(IllegalArgumentException.class, ()-> school.lookUpTeacher("999999999"));
    }

    @Test
    void showProfit_ok(){
        assertEquals((course.getMoney_earned() - t1.getSalary()), school.showProfit());
    }


}
