package ActionItems;

import java.util.ArrayList;

public class Automation_AI01 {
    public static void main(String[] args) {
        //Create an Arraylist of counties
        ArrayList<String> country = new ArrayList<>();
        country.add("Djibouti");
        country.add("Gabon");
        country.add("Kiribati");
        country.add("Mayotte");
        country.add("Nauru");

        //Create an Arraylist countryCode
        ArrayList<Integer> countryCode = new ArrayList<>();
        countryCode.add(253);
        countryCode.add(241);
        countryCode.add(686);
        countryCode.add(262);
        countryCode.add(674);

        for (int i = 0; i < country.size(); i++){
            System.out.println("My country is " + country.get(i) + " and my country code is " + countryCode.get(i));


        }//end of loop




    }//end of main
}//end of class
