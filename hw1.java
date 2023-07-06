// Реализуйте 3 метода, чтобы в каждом из них получить разные исключения

package Exceptions_HW;
public class hw1 {
    public static void main(String[] args) {
        arrayAddValue();
        printStringLength();
        parseInt();
    }

    public static void arrayAddValue() {
        int[] array = new int[5];
        try{
            array[10] = 0;
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("недопустимый индекс массива");
            e.printStackTrace();
        }

    }

    public static void printStringLength() {
        String str = null;
        try{
            System.out.println(str.length());
        } catch (NullPointerException e) {
            System.out.println("действие невыполнимо, строка имеет значение null");
            e.printStackTrace();
        }
    }

    public static void parseInt() {
        try{
            int number = Integer.parseInt("twenty two");
            System.out.println(number);
        } catch (NumberFormatException e) {
            System.out.println("преобразуемая строка содержит нечисловые данные");
            e.printStackTrace();
        }
    }
    
}
