// Разработайте программу, которая выбросит Exception, когда пользователь вводит пустую строку. 
//Пользователю должно показаться сообщение, что пустые строки вводить нельзя

package Exceptions_HW.HW2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class task4 {
    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("input not empty text string:");
        try {
            String result = reader.readLine();
            if (result.equals("")) throw new RuntimeException("Don't input empty string!");
            System.out.println(result);
        } catch (IOException | NullPointerException e) {
            throw new RuntimeException(e);
        }
    }  
}
