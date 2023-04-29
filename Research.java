package assignment2;
/**
 * research class extend of unit class for Assignment 2, this class will provide all the functions that is needed for research class 
 * @author      yin zhanpeng    
 * @version     1.0          (current version number of program)
 * Assignment 2
 * this program have will read the student csv file and have functions that will provide a summary for the students 
 */
public class Research extends Unit {

    
    String enrolmentType = "R";

    int proposalMark;
    int finalDissertationMark;

    int overallMark;
    String finalGrade;

    /**
     * constructor
     * @param enrolmentType enrollment type
     */
    public Research(String enrolmentType) {
        super(enrolmentType);
    }
    
    
    
    
    

    /**
     * constructor 
     * @param proposalMark proposal mark
     * @param finalDissertationMark final mark
     * @param enrolmentType enrollment type
     */
    public Research(int proposalMark, int finalDissertationMark, String enrolmentType) {
        super(enrolmentType);
        this.proposalMark = proposalMark;
        this.finalDissertationMark = finalDissertationMark;

    }

    /**
     * coverall mark calculation
     */
    @Override
    public void overallMarkCalculation() {
        overallMark = (int) (proposalMark * 0.4 + finalDissertationMark * 0.6);
    }
    
    /**
     * testing 
     * @param args args
     */
    public static void main(String[] args) {
        Research r = new Research(50, 100, "C");
        r.overallMarkCalculation();
        r.finalGrade = r.finalGradeCalculation(r.overallMark);
        
        System.out.println(r.overallMark);
        System.out.println(r.finalGrade);
    }

}
