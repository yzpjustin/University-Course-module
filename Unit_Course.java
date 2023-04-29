package assignment2;

/**
 * Unit_Course class extend of unit class for Assignment 2, this class will provide all the functions that is needed for Unit_Course class 
 * @author      yin zhanpeng    
 * @version     1.0          (current version number of program)
 * Assignment 2
 * this program have will read the student csv file and have functions that will provide a summary for the students 
 */
public class Unit_Course extends Unit {

    String unitID;
    int levelOfUnit;

    String enrolmentType = "C";

    int assignment1;  //max 100
    int assignment2;  //max 100
    int finalExamination;  //max 100

    int overallMark;
    String finalGrade;

    /**
     * constructor
     * @param assignment1 assignment 1 mark
     * @param assignment2 assignment 2 mark
     * @param finalExamination final examination mark
     * @param enrolmentType enrollment type
     * @param unitID unit id
     * @param levelOfUnit level of unit 
     */
    public Unit_Course(int assignment1, int assignment2, int finalExamination, String enrolmentType, String unitID, int levelOfUnit ) {
        super(enrolmentType);
        this.assignment1 = assignment1;
        this.assignment2 = assignment2;
        this.finalExamination = finalExamination;
        this.unitID = unitID;
        this.levelOfUnit = levelOfUnit;

    }

    /**
     * overall mark calculation
     */
    @Override
    public void overallMarkCalculation() {
        overallMark = overallMark = (int) (assignment1 * 0.3 + assignment2 * 0.3 + finalExamination * 0.4);
    }

    /**
     * convert to string
     * @return unit id, level of unit, assignment 1, assignment 2, final exam, overall mark, final grade
     */
    public String toString() {
        return this.unitID + "," + this.levelOfUnit + "," + this.assignment1
                + "," + this.assignment2 + "," + this.finalExamination
                + "," + this.overallMark + "," + this.finalGrade;
    }

    //testing

    /**
     * testing 
     * @param args args
     */
    public static void main(String[] args) {
        Unit_Course uc = new Unit_Course(50, 50, 100, "C", "ICT333", 3);
        uc.finalGradeCalculation(uc.overallMark);
        uc.overallMarkCalculation();
        System.out.println(uc.overallMark);
        System.out.println(uc.finalGradeCalculation(uc.overallMark));
    }

}
