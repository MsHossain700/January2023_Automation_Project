package Day2_2262023;


import java.util.ArrayList;

public class T2_ArrayList {
    public static void main(String[] args) {

        //Create an Arraylist of counties
        ArrayList <String> countries = new ArrayList<>();
        countries.add("USA");
        countries.add("Canada");
        countries.add("Bangladesh");
        countries.add("Austria");

        //get the count of the list
        System.out.println("Countries list: " + countries.size());

        //Print only USA Bangladesh and Canada
        System.out.println("Countries are " + countries.get(0) + ", " + countries.get(1) + ", " + countries.get(2));

        //you can add more to the list afterwards
        countries.add("Russia");
        //get the count of the list
        System.out.println("Countries list: " + countries.size());
        System.out.println(countries.get(4));

        //To get the last value count dynamically do the following
        //System.out.println(countries.size()-1);

        //Create integer ArrayList
        ArrayList <Integer> areaCode = new ArrayList<>();
        areaCode.add(11431);
        areaCode.add(11432);
        areaCode.add(11433);
        //get count of the list
        System.out.println("Area code list: " + areaCode.size());
        System.out.println("My area codes is: " + areaCode.get(1));





    }
}
