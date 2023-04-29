package assignment2;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * client class for Assignment 2, this class will provide all the functions that is needed for the requirement 
 * @author      yin zhanpeng   
 * @version     1.0          (current version number of program)
 * Assignment 2
 * this program have will read the student csv file and have functions that will provide a summary for the students 
 */




public class Client {

    private static final ArrayList<Student> students = new ArrayList<>(); // will store the data from csv
    //private static String fileName = "student.csv";
    private static final String OUTPUTFILE = "programOutput.csv";

    private static boolean bubbleStored = false;
    private static boolean carrybit = false;

    /**
     * constructor
     */
    public Client() {
    }

    
    
    /**
     * the main program
     */
    public static void run() {
        printMenuAndGetChoice();

        //Student_Course Sc = new Student_Course(50,10,100,"fname", "sname", 1 );
    }

    /**
     * print the menu and get the choice of the user
     */
    public static void printMenuAndGetChoice() {
        boolean carryOn = true;
        while (carryOn) {
            printMenu();
            String choice = Helper.getString("please enter only options 1 to 8, 1 is to quit");
            switch (choice) {
                case "1" -> {
                    carryOn = false;
                    Helper.println("Thank you, have a good day. bye bye ");
                }
                case "2" ->
                    addMarksInfomationFromCsv();
                case "3" ->
                    removeInfomationById();
                case "4" ->
                    outputAllDetailsOfStudents();
                case "5" ->
                    getNumberOfStudentAboveAndBelowAverageCourseWork();
                case "6" ->
                    checkArrayListByStudentId();
                case "7" ->
                    sortingStudentsById();
                case "8" ->
                    printSortedArrayListToCsv();
                default ->
                    System.out.println("INvalid choice, Please only enter the number 1-8");
            }
        }
    }

    /**
     * display the arraylist to output csv file
     */
    public static void printToCsv() {
        if (bubbleStored) {
            Helper.println("yes");
            carrybit = true;
            for (Student s : students) {
                s.reportGrade(carrybit, OUTPUTFILE);

            }
            Helper.println("Arraylist have been printed to programOutput.csv");
            carrybit = false;
        } else {
            Helper.println("Arraylist have not been sorted, please sort it before using this function");
        }
    }

    /**
     * using bubble sort algo to sort the array list
     */
    public static void bubbleSort() {
        boolean swap = true;
        while (swap) {
            swap = false;
            for (int i = 1; i < students.size(); i++) {
                long studentId1 = students.get(i - 1).getStudentNumber();
                long studentId2 = students.get(i).getStudentNumber();
                if (studentId1 > studentId2) {
                    Student student1 = students.get(i - 1);
                    Student student2 = students.get(i);
                    students.set(i - 1, student2);
                    students.set(i, student1);
                    swap = true;
                }

            }

        }
        Helper.println("file have been sorted");

    }

    /**
     * find using student id and display the student
     */
    public static void getIdAndDisplay() {
        boolean exsist  = true;
        int id = Helper.getInt("Enter the ID");
        for (int i = 0; i < students.size(); i++) {
            if (id == students.get(i).getStudentNumber()) {
                students.get(i).reportGrade(carrybit, OUTPUTFILE);
                exsist  = false;
                break;

            }
        }
        if(exsist){
            Helper.println("This ID does not exsit");
        }
    }

    /**
     * calculate the number of student below or above the average mark
     * @param averageMarks average mark
     */
    public static void numberOfStudentGetAboveOrBelowCalculation(int averageMarks) {
        int indexAbove = 0;
        int indexBelow = 0;

        for (int i = 0; i < students.size(); i++) {
            if ((students.get(i)).getEnrolmentType().equals("C")) {
                if (((Student_Course) students.get(i)).getOverallMarks() >= averageMarks) {
                    indexAbove++;
                } else {
                    indexBelow++;
                }
            }
        }

        System.out.println(indexAbove + " number of student gets above or equal to the average marks of : " + averageMarks);
        System.out.println(indexBelow + " number of student gets below the average marks of : " + averageMarks);

    }

    /**
     * calculate the average mark
     * @return average mark
     */
    public static int aveageMarksForCourseWorkStudent() {
        int averageMarks = 0;
        int index = 0;
        for (int i = 0; i < students.size(); i++) {
            //students.get(i).reportGrade();
            if ((students.get(i)).getEnrolmentType().equals("C")) {
                //students.get(i).reportGrade();
                averageMarks += ((Student_Course) students.get(i)).getOverallMarks();
                index++;
                //students.get(i).reportGrade();
            }
        }
        averageMarks = averageMarks / index;

        return averageMarks;
    }

    /**
     * delete the student by id
     */
    public static void deletebyId() {
        int inputId = Helper.getInt("Please enter the student ID");
        int index;
        boolean carryOn = true;

        for (int i = 0; i < students.size(); i++) {
            if (inputId == (students.get(i).getStudentNumber())) {
                index = i;
                deleteByIndex(index);
                carryOn = false;
            }
            
        }
        if(carryOn){
            Helper.println("Student not found");
        }
    }

    /**
     * confirm the the delete student by id
     * @param index the index of student in array list
     */
    public static void deleteByIndex(int index) {
        if (index >= 0) {

            System.out.print("Do you want to delete student: " + students.get(index).getFirstName() + " with ID " + students.get(index).getStudentNumber() + "? (y/n) ");

            String answer = Helper.getString(" ").toLowerCase();
            if (answer.equals("y")) {

                System.out.println("Student: " + students.get(index).getFirstName() + " with ID " + students.get(index).getStudentNumber() + " has been deleted.");
                students.remove(index);
            } else {
                System.out.println("Deletion cancelled.");
            }
        }

    }

    /**
     * output the data to csv
     * @throws FileNotFoundException file not found 
     */
    public static void addDataToArrayList() throws FileNotFoundException {
        String inputFileName = Helper.getString("Enter the file name");
        File fp = new File(inputFileName);
        Scanner file = new Scanner(fp);
        while (file.hasNextLine()) {
            String line = file.nextLine(); // get the line 
            //Helper.println(line);

            List<String> datas = new ArrayList<>();
            datas.addAll(Arrays.asList(line.split(",")));
            //System.out.println(datas);
            //System.out.println(datas);
            if (datas.get(0).equals("C")) {
                //System.out.println(datas.get(0));
                Student_Course studentsc = new Student_Course(Integer.parseInt(datas.get(1)), Integer.parseInt(datas.get(2))
                        , Integer.parseInt(datas.get(3)), datas.get(4), datas.get(5), Integer.parseInt(datas.get(6))
                        , datas.get(7), Integer.parseInt(datas.get(8)));
                students.add(studentsc);

            } else if (datas.get(0).equals("R")) {
                //System.out.println(datas.get(0));
                Student_Research studentsr = new Student_Research(Integer.parseInt(datas.get(1)), Integer.parseInt(datas.get(2))
                        , datas.get(3), datas.get(4), Integer.parseInt(datas.get(5)));
                students.add(studentsr);
            }

        }
        Helper.println("Data have been imported");
        //(students.get(0)).reportGrade();

    }

    /**
     * import the student data from csv file
     */
    public static void addMarksInfomationFromCsv() {
        try {

            addDataToArrayList();

        } catch (FileNotFoundException ex) {
            System.out.println("file not found");
        }

    }

    /**
     * remove the student by id
     */
    public static void removeInfomationById() {
        deletebyId();

    }

    /**
     * display all the student infomations in the array list
     */
    public static void outputAllDetailsOfStudents() {

        //Helper.println("Testing");
        for (Student s : students) {
            s.reportGrade(carrybit, OUTPUTFILE);
            Helper.println("---------------------------------------------");
        }

    }

    /**
     * get the student marks for course work student 
     */
    public static void getNumberOfStudentAboveAndBelowAverageCourseWork() {
        try{
            numberOfStudentGetAboveOrBelowCalculation(aveageMarksForCourseWorkStudent());
        }catch(java.lang.ArithmeticException ex){
            Helper.println("Cant divide by 0");
        }
    }

    /**
     * get the student data from array list by id
     */
    public static void checkArrayListByStudentId() {
        getIdAndDisplay();

    }

    /**
     * sort the student by id in the array list
     */
    public static void sortingStudentsById() {
        bubbleSort();
        bubbleStored = true;

    }

    /**
     * print array list to csv
     */
    public static void printSortedArrayListToCsv() {
        printToCsv();

    }

    /**
     * print menu
     */
    public static void printMenu() {
        Helper.println("1. Quit (exit the program)");
        System.out.println();
        System.out.println();
        Helper.println("""
                       2. Add (to the ArrayList) from csv. """);
        System.out.println();
        System.out.println();
        Helper.println("""
                       3. Delete from arraylist by student ID. """);
        System.out.println();
        System.out.println();
        Helper.println("4. Output all details currently held in the ArrayList. ");
        System.out.println();
        System.out.println();
        Helper.println("""
                       5. Calculate overall marks for course work students. """);
        System.out.println();
        System.out.println();
        Helper.println("""
                       6. Report grade by student ID. """);
        System.out.println();
        System.out.println();
        Helper.println("""
                       7. Bubble sort the students in arraylist. """);
        System.out.println();
        System.out.println();
        Helper.println("""
                       8. Output SORTED arraylist to csv. """);
        System.out.println();
        System.out.println();
    }

}
