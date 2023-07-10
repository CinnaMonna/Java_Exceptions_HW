//Дан следующий код, исправьте его там, где требуется

package Exceptions_HW.HW2;

public class task3 {
    public static void main(String[] args) throws Exception {
        int a = 90;
        int b = 3;
        if (b != 0) {
            System.out.println(a / b);
        } else {
            System.out.println("Incorrect value: Division by zero");
        }
        
        printSum(23, 234);
        
        int[] abc = { 1, 2 };

        int i = 3;
        if (i < abc.length) {
            abc[i] = 9;
        } else {
            System.out.println("Incorrect index");
        }
    }

        public static void printSum(Integer a, Integer b) {
        System.out.println(a + b);
        }

    
}

// public static void main(String[] args) throws Exception {
//    try {
//        int a = 90;
//        int b = 3;
//        System.out.println(a / b);
//        printSum(23, 234);
//        int[] abc = { 1, 2 };
//        abc[3] = 9;
//    } catch (Throwable ex) {
//        System.out.println("Что-то пошло не так...");
//    } catch (NullPointerException ex) {
//        System.out.println("Указатель не может указывать на null!");
//    } catch (IndexOutOfBoundsException ex) {
//        System.out.println("Массив выходит за пределы своего размера!");
//    }
// }
// public static void printSum(Integer a, Integer b) throws FileNotFoundException {
//    System.out.println(a + b);
// }