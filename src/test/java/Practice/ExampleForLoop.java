package Practice;

public class ExampleForLoop {

    public static void main(String[] args) {

        for(int i = 0; i <= 10; i++) {  //(i = i + 4 i++ i = i + 1)
            if(i % 2 == 0) System.out.println(i);
        }

        int[] examScroes = { 9, 3, 6, 8, 10 };

        for(int i = 0; i < examScroes.length; i++) {

            if(examScroes[i] < 7) System.out.println("You failed your exam");
            else System.out.println("You passed");
        }

        //i = i + 1

//        int a = 10;
//
//        int b = 10;
//
//        System.out.println("a: " + a);
//
//        System.out.println("a++: " + a++); //a = a + 1
//
//        System.out.println("a: " + a);
//
//        System.out.println("b: " + b);
//
//        System.out.println("++b: " + ++b);
//
//        System.out.println("b: " + b);

        //++ operator means increment the value by 1

//        *
//        **
//        ***
//        ****
//        *****

        for(int a = 0; a < 5; a++) {
            for(int b = 0; b <= a; b++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for(int a = 0; a < 5; a++) {
            for(int b = 5 - a; b >= 0; b--) {

                System.out.print(" ");

            }

            for(int b =  0; b <= a; b++) {
                System.out.print("*");
            }
            System.out.println();
        }

        int [][] my2DArray = {{ 1, 2, 3, 4, 5 },
                                { 6, 7, 8, 9, 10 },
                                { 11, 12, 13, 14, 15},
                                { 16, 17, 18, 19, 20},
                                { 21, 22, 23, 24, 25} };

        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                System.out.print(my2DArray[i][j] + " ");
            }
            System.out.println();
        }

    }
}
//     *
//    **
//   ***
