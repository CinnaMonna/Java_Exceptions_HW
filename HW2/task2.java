//Если необходимо, исправьте данный код

package Exceptions_HW.HW2;

public class task2 {
    public static void main(String[] args) {
        int[]intArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
        int d = 0;
        int i = 8;
        if (i >= intArray.length) {
            System.out.println("Incorrect index");
        }
        else if (d == 0) {
            System.out.println("Incorrect value: Division by zero");
        } else {
            double catchedRes1 = intArray[i] / d;
            System.out.println("catchedRes1 = " + catchedRes1);
        }
    }
}


        // исходный вариант в задании
        // try {
        //     int d = 0;
        //     double catchedRes1 = intArray[8] / d;
        //     System.out.println("catchedRes1 = " + catchedRes1);
        //  } catch (ArithmeticException e) {
        //     System.out.println("Catching exception: " + e);
        //  }

        //ArithmeticException является Unchecked и обрабатывается в коде через if/else
         
    
    

