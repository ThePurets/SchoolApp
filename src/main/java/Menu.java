import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Menu {

    static School school = new School("");
    public static void menuStart() throws IOException {
        System.out.println("Welcome to the School System App");
        nameOfSchool();
        menuSelectOption();
    }
    public static void nameOfSchool(){

        Scanner input = new Scanner(System.in);
        System.out.println("Enter a name for the school: ");
        school.setName(input.next());
    }
    public static void menuSelectOption() throws IOException {
            System.out.println("Press 1 to add ITEMS, press 2 to go to the COMMANDS console, or press 3 to CLOSE THE APP");
            menuGetUserSelection();
    }
    public static void menuGetUserSelection() throws IOException {
        try{

            Scanner input = new Scanner(System.in);
            int opc2 = input.nextInt();

            if (opc2 <= 0 || opc2 >4){
                System.out.println("Please choose a number between 1 to 3");
                menuSelectOption();
            }else{

                try {
                    if (opc2 == 1){
                        userSelectItems();
                    }else if (opc2 == 2){
                        userSelectCommands();
                    }else if (opc2 == 3){
                        shutdownApp();
                    }

                }catch (InputMismatchException e){
                    System.out.println("Please enter a valid number!");
                    menuSelectOption();
                }
            }

        }catch (InputMismatchException exception){
            System.out.println("Please enter a valid number!");
            menuSelectOption();
        }
    }
    public static void userSelectItems() throws IOException {

        Scanner input = new Scanner(System.in);
        System.out.println("Press 1 to add TEACHERS, 2 to add COURSES or 3 to add STUDENTS, press 4 to EXIT");

        try{

            int opc = input.nextInt();

            if (opc <= 0 || opc > 5){
                System.out.println("Please choose a number between 1 to 4");
                userSelectItems();

            }else{
                try{

                    switch (opc) {
                        case 1 -> addTeacher();
                        case 2 -> addCourses();
                        case 3 -> addStudent();
                        case 4 -> menuSelectOption();
                    }

                }catch(InputMismatchException e){
                    System.out.println("Please enter a valid number!");
                    userSelectItems();
                }
            }
        }catch (InputMismatchException exception){
            System.out.println("Please enter a valid number!");
            menuSelectOption();
        }
    }
    public static void userSelectCommands() throws IOException {

        Scanner input = new Scanner(System.in);

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Welcome to command console! ");
        System.out.println("Each command allows you to perform a task, select a command and follow the instructions... ");
        System.out.println("\n\n\n\n");

        int opcCommand = 0;
        do {
            System.out.println("Select a command: ");
            System.out.println("1. ENROLL (This command will help enroll the student specified in the corresponding course)");
            System.out.println("2. ASSIGN (This command will help assign the teacher specified to the corresponding course)");
            System.out.println("3. SHOW COURSES (This command will display a list of all courses)");
            System.out.println("4. LOOK UP COURSES (This command will display the full details of the specified course)");
            System.out.println("5. SHOW STUDENTS (This command will display a list of all students)");
            System.out.println("6. LOOKUP STUDENT (This command will display the full details of the specified student)");
            System.out.println("7. SHOW TEACHERS (This command will display a list of all teachers)");
            System.out.println("8. LOOKUP TEACHER ( This command will display the full details of the specified teacher)");
            System.out.println("9. SHOW PROFIT (This command will calculate (The total money earned from all courses))");
            System.out.println("0. BACK");

            opcCommand = input.nextInt();

            if (opcCommand == 0) {

                System.out.println("Are you sure? Y / N");
                Scanner inputScanner2 = new Scanner(System.in);
                String opc0 = inputScanner2.next();

                if (opc0.equals("y") || opc0.equals("Y")) {
                    menuSelectOption();
                }else{
                    userSelectCommands();
                }

            }else if (opcCommand < 0 || opcCommand >=10){

                System.out.println("Please enter a valid number");

            }else{

                try{

                    switch (opcCommand){

                        case 1 -> school.enrollData();
                        case 2 -> school.assignData();
                        case 3 -> System.out.println(school.getCourseList());
                        case 4 -> school.getDataCourse();
                        case 5 -> System.out.println(school.getStudentList());
                        case 6 -> school.getDataStudent();
                        case 7 -> System.out.println(school.getTeacherList());
                        case 8 -> school.getDataTeacher();
                        case 9 -> System.out.println(school.showProfit());
                        default -> throw new IllegalStateException("Please enter a valid number " + opcCommand);
                    }

                }catch(IllegalArgumentException e){System.out.println("Please enter a valid number");}
            }
        }while (opcCommand != 0);

    }
    public static void addTeacher() throws IOException {


        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Scanner input2 = new Scanner(System.in);

        System.out.println("How many teachers should be created? ");
        int numberOfTeachers;
        numberOfTeachers = input2.nextInt();

        if (numberOfTeachers < 0 || numberOfTeachers > 100){

            System.out.println("Please enter a valid number");
            addTeacher();

        }else{

            try{

                for(int i = 1; i <= numberOfTeachers; i++){

                    System.out.println("Enter the teacher's name ");
                    String name = input.readLine();

                    System.out.println("Enter the teacher's salary ");
                    double salary = Double.parseDouble(input.readLine());

                    Teacher teacher = new Teacher(name,salary);
                    school.getTeacherList().add(teacher);

                }

                Scanner inputScanner = new Scanner(System.in);
                boolean escTeacher = true;

                while (escTeacher){

                    System.out.print("Do you want to add more teachers? ");
                    System.out.println("Y / N ");
                    String opc = inputScanner.next();

                    if (opc.equals("y") || opc.equals("Y")) {
                        addTeacher();
                    }else{
                        escTeacher=false;

                    }
                }
            }catch(NumberFormatException e){
                System.out.println("Please enter a valid number");
                addTeacher();
            }
            addCourses();
        }
    }
    public static void addCourses() throws IOException {


        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Scanner input3 = new Scanner(System.in);

        System.out.println("How many courses should be created? ");
        int numberOfCourses;
        numberOfCourses = input3.nextInt();

        if (numberOfCourses < 0 || numberOfCourses > 100){
            System.out.println("Please enter a valid number");
            addCourses();
        }else {

            try {

                for(int i = 1; i <= numberOfCourses; i++){

                    System.out.println("Enter the name of the course ");
                    String name = input.readLine();

                    System.out.println("Enter the course fee ");
                    double price = Double.parseDouble(input.readLine());

                    Course course = new Course("", name, price);
                    school.getCourseList().add(course);
                }
                Scanner input2 = new Scanner(System.in);

                boolean escCourses = true;

                while (escCourses){

                    System.out.print("Do you want to add more courses? ");
                    System.out.println("Y / N ");
                    String opc = input2.next();

                    if (opc.equals("y") || opc.equals("Y")) {
                        addCourses();
                    }else{
                        escCourses=false;
                    }
                }

            }catch (NumberFormatException e){
                System.out.println("Introduce un número valido");
                addCourses();
            }
        }
        addStudent();
    }
    public static void addStudent() throws IOException {


        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        Scanner input4 = new Scanner(System.in);

        System.out.println("How many students must be created? ");
        int numberOfStudent;
        numberOfStudent = input4.nextInt();

        if (numberOfStudent < 0 || numberOfStudent > 100){

            System.out.println("Introduce un número valido");
            addStudent();

        }else {

            try{

                for(int i = 1; i <= numberOfStudent; i++){

                    System.out.println("Enter student's name ");
                    String name = input.readLine();

                    System.out.println("Introduzca la dirección del estudiante ");
                    String address = input.readLine();

                    System.out.println("Enter student's address ");
                    String email = input.readLine();

                    Student student = new Student(name, address, email);
                    school.getStudentList().add(student);


                }

                Scanner input2 = new Scanner(System.in);

                boolean escStudent = true;

                while (escStudent){

                    System.out.print("Do you want to add more students? ");
                    System.out.println("Y / N");
                    String opc = input2.next();

                    if (opc.equals("y") || opc.equals("Y")) {

                        addStudent();

                    }else{

                        escStudent=false;
                    }
                }

            }catch(NumberFormatException e){
                System.out.println("Please enter a valid number");
                addStudent();

            }

            menuSelectOption();

        }
    }
    public static void shutdownApp(){
        System.out.println("See you soon");
    }

}
