package assignment2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Student_Research class extend of student class for Assignment 2, this class will provide all the functions that is needed for Student_Research class 
 * @author      yin zhanpeng   
 * @version     1.0          (current version number of program)
 * Assignment 2
 * this program have will read the student csv file and have functions that will provide a summary for the students 
 */
public class Student_Research extends Student {

    private final String enrolmentType = "R";

    private int student_ResearchProposalMark;
    private int student_ResearchFinalDissertationMark;

    /**
     * constructor 
     */
    public Student_Research() {

    }

    /**
     * constructor
     * @param student_ResearchProposalMark proposal mark
     * @param student_ResearchFinalDissertationMark final mark
     * @param firstName first name 
     * @param lastName last name
     * @param studentNumber student number
     */
    public Student_Research(int student_ResearchProposalMark, int student_ResearchFinalDissertationMark, String firstName, String lastName, long studentNumber) {
        super(firstName, lastName, studentNumber);
        this.student_ResearchProposalMark = student_ResearchProposalMark;
        this.student_ResearchFinalDissertationMark = student_ResearchFinalDissertationMark;
    }

    /**
     * get enrollment type
     * @return enrollment type
     */
    @Override
    public String getEnrolmentType() {
        return enrolmentType;
    }

    /**
     * report the grades of the student 
     * @param sorted check if the array list is sorted
     * @param OUTPUT_FILENAME the file which the array list will output
     */
    @Override
    public void reportGrade(boolean sorted, String OUTPUT_FILENAME) {
        Research r = new Research(student_ResearchProposalMark, student_ResearchFinalDissertationMark, enrolmentType);
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
                    r.overallMarkCalculation();
                    r.finalGrade = r.finalGradeCalculation(r.overallMark);
                    pw.print(" Student Overall Mark: " + " " + r.overallMark);
                    pw.print(" Student Final Grade: " + " " + r.finalGrade);
                    pw.println("");
                }
            } catch (IOException ex) {
                System.out.println("file error");

            }

        } else {
            //System.out.println("Unit ID: " + r. );
            System.out.println("Enrolment Type: " + enrolmentType);
            System.out.println("Student Name: " + super.getFirstName() + " " + super.getLastName());
            System.out.println("Student Number: " + super.getStudentNumber());
            r.overallMarkCalculation();
            r.finalGrade = r.finalGradeCalculation(r.overallMark);
            System.out.println("Student Overall Mark: " + " " + r.overallMark);
            System.out.println("Student Final Grade: " + " " + r.finalGrade);
        }

    }

    /**
     * convert enrollment type to string 
     * @return enrollment type
     */
    @Override
    public String toString() {
        return this.enrolmentType;
    }

    /**
     * tetsing 
     * @param args args
     */
    public static void main(String[] args) {
        boolean test = false;
        String OUTPUT_FILENAME = " ";
        Student_Research student = new Student_Research(50, 100, "john", "yip", 001);
        student.reportGrade(test, OUTPUT_FILENAME);
    }

}
