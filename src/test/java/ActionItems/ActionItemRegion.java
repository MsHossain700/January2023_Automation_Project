package ActionItems;

public class ActionItemRegion {
    public static void main(String[] args) {
        //Linear Array of Regions
        String[] Region = new String[] {"TX","ON","OH","MD","AL"};
        //Linear Array of regionCode
        int[] regionalCode = new int[]{214,226,216,240,251};

        int i =0;
        while (i<Region.length){
            System.out.println("My region is " + Region[i] + " and my are is " + regionalCode[i]);

            i=i+1;
        }//end of loop






    }//end of main
}//end of class
