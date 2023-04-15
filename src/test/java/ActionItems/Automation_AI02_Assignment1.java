package ActionItems;

public class Automation_AI02_Assignment1 {
    public static void main(String[] args) {
        //Create a variable with numeric value
        int grade = 90;

        //use conditional statements to change the variable
        if (grade >= 90 && grade <= 100) {
            grade = 'A';
        } else if (grade >= 80 && grade < 90) {
            grade = 'B';
        } else if (grade >= 70 && grade < 80) {
            grade = 'C';
        } else if (grade >= 60 && grade < 70) {
            grade = 'D';
        } else {
            grade = 'F';
        }

        // print out the final grade
        System.out.println("The final grade is: " + (char)grade);



    }//end of main
}//end of class
