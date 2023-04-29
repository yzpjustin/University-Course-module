package assignment2;

/**
 * Unit class for Assignment 2, this class will provide all the functions that is needed for Unit which will be pass down to its sub class 
 * @author      yin zhanpeng    
 * @version     1.0          (current version number of program)
 * Assignment 2
 * this program have will read the student csv file and have functions that will provide a summary for the students 
 */
public class Unit {

    String enrolmentType; // C course work enrolment R research enrolment
    int overallMark;
    String finalGrade;

    /**
     * constructor 
     * @param enrolmentType enrollment type
     */
    public Unit(String enrolmentType) {
        this.enrolmentType = enrolmentType;
    }

    /**
     * get the enrollment type
     * @return enrollment type
     */
    public String getEnrolmentType() {
        return enrolmentType;
    }

    /**
     * display the grades
     */
    public void gradeReporting() {
        System.out.println("NA");
    }

    /**
     * overall mark calculation
     */
    public void overallMarkCalculation() {
        Helper.println("no marks to calculate");
    }

    /**
     * final grade calculation
     * @param overallMarks overall marks
     * @return grades
     */
    public static String finalGradeCalculation(int overallMarks ) {
        if (overallMarks < 50) {
            return "N";
        } else if (overallMarks >= 80) {
            return "HD";
        } else if (overallMarks >= 70) {
            return "D";
        } else if (overallMarks >= 60) {
            return "C";
        } else if (overallMarks >= 50) {
            return "P";
        }
        return "error";
    }
    public static void main(String[] args) {
        System.out.println(finalGradeCalculation(80));
        System.out.println(finalGradeCalculation(70));
        System.out.println(finalGradeCalculation(60));
        System.out.println(finalGradeCalculation(50));
        System.out.println(finalGradeCalculation(90));
    }

}
