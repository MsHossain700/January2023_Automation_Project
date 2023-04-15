package Day2_2262023;

import java.util.ArrayList;

public class T3_ForLoop {
    public static void main(String[] args) {
        //Create an Arraylist of counties
        ArrayList<String> countries = new ArrayList<>();
        countries.add("USA");
        countries.add("Canada");
        countries.add("Bangladesh");
        countries.add("Austria");

        //iterate /loop through the entire list of counties using for loop
        for(int i = 0; i < countries.size(); i++) {
            System.out.println("Country is " + countries.get(i));
        }//End of loop


        ArrayList <Integer> areaCode = new ArrayList<>();
        areaCode.add(11431);
        areaCode.add(11432);
        areaCode.add(11433);
        areaCode.add(11434);
        //if you are using one loop for 2 or more array list, then they all have the same amount of count
        //if not then it needs to be in separate loop statement

        //iterate/loop through the entire list of countries using loop
        for (int i = 0; i < countries.size(); i++){
            System.out.println("Country is " + countries.get(i) + " area code is " + areaCode.get(i));
        }//Eng of loop



    }
}
