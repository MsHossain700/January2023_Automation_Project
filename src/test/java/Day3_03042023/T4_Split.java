package Day3_03042023;

public class T4_Split {
    public static void main(String[] args) {

        //declare a single string variable
        String message = "My name is Sahadat";
        //print of only Sahadat front above string
        String[] arrayMessage = message.split(" ");

        System.out.println("Result: " + arrayMessage[3]);
    }//end of main
}//end of class
