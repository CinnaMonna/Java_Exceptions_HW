// Реализуйте метод, который запрашивает у пользователя ввод дробного числа (типа float)
//и возвращает введенное значение. Ввод текста вместо числа не должно приводить к падению приложения, 
//вместо этого необходимо повторно запросить у пользователя ввод данных.

package Exceptions_HW.HW2;

import java.util.Scanner;

public class task1 {
    public static void main(String[] args) {
        System.out.println(inputFloatNumber());
    }

    public static float inputFloatNumber(){
        Scanner sc = new Scanner(System.in);
        while (true){
            try {
                System.out.println("input float number: ");
                String num = sc.nextLine();
                return Float.parseFloat(num);
                
            } catch (NumberFormatException e){
                System.out.println("incorrect value");
                e.printStackTrace();
            }
        }
    }
    
}
