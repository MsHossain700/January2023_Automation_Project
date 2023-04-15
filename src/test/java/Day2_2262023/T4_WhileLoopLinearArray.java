package Day2_2262023;

public class T4_WhileLoopLinearArray {
    public static void main(String[] args) {
        //create a list of countries in linear array
        //array count starts from 0 index
        String[] countries = new String[] { "USA", "Canada", "Bangladesh", "Argentina"};
        //create a linear array of areaCode
        int[] areaCode = new int[]{111,222,333,444};

        int i = 0;
        while (i < countries.length){
            System.out.println("Country is " + countries[i] + " area code is " + areaCode[i]);

            i= i+1;
        }// end of loop


    }
}
