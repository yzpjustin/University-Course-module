
package assignment2;
/**
 * student class for Assignment 2, this class will provide all the functions that is needed for student which will be pass down to its sub class 
 * @author      yin zhanpeng    
 * @version     1.0          (current version number of program)
 * Assignment 2
 * this program have will read the student csv file and have functions that will provide a summary for the students 
 */
public class Student {

    private String firstName;
    private String
            lastName;
    private long studentNumber;
    
    /**
     * constructor
     */
    public Student() {

        this.firstName = "Firstname";
        this.lastName = "LastName";
        this.studentNumber = 00;
        

    }

    /**
     * constructor 
     * @param firstName first name 
     * @param lastName last name 
     * @param studentNumber student number 
     */
    public Student(String firstName, String lastName, long studentNumber) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.studentNumber = studentNumber;
        
    }

    /**
     * display grade 
     * @param sorted check if array list is sorted
     * @param OUTPUT_FILENAME the file name which the array list will output
     */
    public void reportGrade(boolean sorted, String OUTPUT_FILENAME) {
        System.out.println("There is no grade here");
    }

    /**
     * check if student A is equal to student B by student number 
     * @param student2 the student you want to check with 
     * @return boolean  depending if the students are the same or not
     */
    public boolean equals(Student student2) {
        boolean sameStudentNumber = false;
        if (getStudentNumber() == student2.getStudentNumber()) {
            sameStudentNumber = true;
        }
        return sameStudentNumber;
    }

    /**
     * set the first name
     * @param firstName name you want to set
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * set last name 
     * @param lastName the last name you want to set
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * set student number 
     * @param studentNumber the student number you want to set
     */
    public void setStudentNumber(long studentNumber) {
        this.studentNumber = studentNumber;
    }

    /**
     * get the first name 
     * @return first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * get the last name 
     * @return last name 
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * get the student number 
     * @return student number
     */
    public long getStudentNumber() {
        return studentNumber;
    }

    /**
     * get the enrollment type 
     * @return enrollment type 
     */
    public String getEnrolmentType() {
        return "no  enrolment";
    }

    /**
     * convert to string 
     * @return first name, last name, student number
     */
    @Override
    public String toString() {
        return this.firstName + "," + this.lastName + "," + this.studentNumber;
    }

    //testing

    /**
     * testing
     * @param args args
     */
    public static void main(String[] args) {
        Student student1 = new Student("john", "yip", 12);
        Student student2 = new Student("tom", "neo", 2);
        System.out.println(student1.equals(student2));
    }

}
