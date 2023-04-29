package assignment2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Student_Course class extend of student class for Assignment 2, this class will provide all the functions that is needed for Student_Course class 
 * @author      yin zhanpeng   
 * @version     1.0          (current version number of program)
 * Assignment 2
 * this program have will read the student csv file and have functions that will provide a summary for the students 
 */
public class Student_Course extends Student {

    private final String enrolmentType = "C";

    private final int studentCourseAssignment1;
    private final int studentCourseAssignment2;
    private final int studentCourseFinalExamination;
    private final String unitID;
    private final int levelOfUnit;

    /**
     * Constructor
     * @param studentCourseAssignment1 Marks of assignment 1 
     * @param studentCourseAssignment2 Marks of assignment 2
     * @param studentCourseFinalExamination Marks of final exam
     * @param firstName First name
     * @param lastName Last name
     * @param studentNumber Student number
     * @param unitID Student unit id
     * @param levelOfUnit Student level
     */
    public Student_Course(int studentCourseAssignment1, int studentCourseAssignment2, int studentCourseFinalExamination, String firstName, String lastName, long studentNumber, String unitID, int levelOfUnit) {
        super(firstName, lastName, studentNumber);
        this.studentCourseAssignment1 = studentCourseAssignment1;
        this.studentCourseAssignment2 = studentCourseAssignment2;
        this.studentCourseFinalExamination = studentCourseFinalExamination;
        this.unitID = unitID;
        this.levelOfUnit = levelOfUnit;
    }

    /**
     * returns the Enrollment type
     * @return Enrollment type
     */
    @Override
    public String getEnrolmentType() {
        return enrolmentType;
    }

    /**
     * get the overall marks from the unit course
     * @return overall marks 
     */
    public int getOverallMarks() {
        Unit_Course uc = new Unit_Course(studentCourseAssignment1, studentCourseAssignment2, studentCourseFinalExamination, enrolmentType, unitID, levelOfUnit);
        uc.overallMarkCalculation();
        return uc.overallMark;
    }

    /**
     * display the grades 
     * @param sorted check if the array list is sorted
     * @param OUTPUT_FILENAME the file which the array list will output 
     */
    @Override
    public void reportGrade(boolean sorted, String OUTPUT_FILENAME) {

        Unit_Course uc = new Unit_Course(studentCourseAssignment1, studentCourseAssignment2, studentCourseFinalExamination, enrolmentType, unitID, levelOfUnit);
        if (sorted) {
            try {
                //PrintWriter pw = new PrintWriter(OUTPUT_FILENAME);
                File outputFile = new File(OUTPUT_FILENAME);
                boolean append = outputFile.exists() && outputFile.length() > 0;
                FileWriter fw = new FileWriter(OUTPUT_FILENAME, append);
                try (PrintWriter pw = new PrintWriter(fw)) {
                    pw.print("Enrolment Type: " + enrolmentType);
                    pw.print(" Student Name: " + super.getFirstName() + " " + super.getLastName());
                    pw.print(" Student Number: " + super.getStudentNumber());
                    uc.overallMarkCalculation();
                    uc.finalGrade = uc.finalGradeCalculation(uc.overallMark);
                    pw.print(" Student Overall Mark: " + " " + uc.overallMark);
                    pw.print(" Student Final Grade: " + " " + uc.finalGrade);
                    pw.print(" Student Unit ID: " + " " + uc.unitID);
                    pw.print(" Student Unit Level: " + " " + uc.levelOfUnit);
                    pw.println("");
                }
            } catch (IOException ex) {
                System.out.println("file error");

            }

        } else {
            System.out.println("Enrolment Type: " + enrolmentType);
            System.out.println("Student Name: " + super.getFirstName() + " " + super.getLastName());
            System.out.println("Student Number: " + super.getStudentNumber());
            uc.overallMarkCalculation();
            uc.finalGrade = uc.finalGradeCalculation(uc.overallMark);
            System.out.println("Student Overall Mark: " + " " + uc.overallMark);
            System.out.println("Student Final Grade: " + " " + uc.finalGrade);
            System.out.println("Student Unit ID: " + " " + uc.unitID);
            System.out.println("Student Unit Level: " + " " + uc.levelOfUnit);
            
            
        }

    }

    /**
     * convert to string
     * @return enrollment type in string
     */
    @Override
    public String toString() {
        return this.enrolmentType;
    }

    /**
     * testing program 
     * @param args args
     */
    public static void main(String[] args) {
        boolean test = true;
        String OUTPUT_FILENAME = "testing";
        Student_Course student1 = new Student_Course(50, 50, 100, "john", "yip", 001,"ict110",10);
        System.out.println(student1.getOverallMarks());
        //System.out.println(student1.unitID);
        student1.reportGrade(test, OUTPUT_FILENAME);

    }

}
