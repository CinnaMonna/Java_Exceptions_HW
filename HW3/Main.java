    // Напишите приложение, которое будет запрашивать у пользователя следующие данные 
    // в произвольном порядке, разделенные пробелом:
    // Фамилия Имя Отчество датарождения номертелефона пол

    // Форматы данных:
    // фамилия, имя, отчество - строки
    // датарождения - строка формата dd.mm.yyyy
    // номертелефона - целое беззнаковое число без форматирования
    // пол - символ латиницей f или m.

    // Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым, 
    // вернуть код ошибки, обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, 
    // чем требуется.

    // Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры. 
    // Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. Можно использовать 
    // встроенные типы java и создать свои. Исключение должно быть корректно обработано, пользователю выведено 
    // сообщение с информацией, что именно неверно.

    // Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку 
    // должны записаться полученные данные, вида

    // <Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>

    // Однофамильцы должны записаться в один и тот же файл, в отдельные строки.

    // Не забудьте закрыть соединение с файлом.

    // При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, 
    // пользователь должен увидеть стектрейс ошибки.

package Exceptions_HW.HW3;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

import Exceptions_HW.HW3.Exceptions.BirthdayFormatException;
import Exceptions_HW.HW3.Exceptions.CheckQuantityException;
import Exceptions_HW.HW3.Exceptions.CheckSexException;
import Exceptions_HW.HW3.Exceptions.FileCreateException;
import Exceptions_HW.HW3.Exceptions.FullNameContainsDigitException;
import Exceptions_HW.HW3.Exceptions.FullNameEmptyValueException;
import Exceptions_HW.HW3.Exceptions.FullNameReadFromDataException;
import Exceptions_HW.HW3.Exceptions.IncorrectSexValuesException;
import Exceptions_HW.HW3.Exceptions.MyFileCreateException;
import Exceptions_HW.HW3.Exceptions.ParseDataException;
import Exceptions_HW.HW3.Exceptions.ParseDataToIntegerException;
import Exceptions_HW.HW3.Exceptions.TheSameFileWritingException;

public class Main {
    public static void main(String[] args) throws TheSameFileWritingException, MyFileCreateException, IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите данные в произвольном порядке через пробел в одну строку:\nФамилия Имя Отчество\nдата рождения (дд.мм.гггг)\n"+
            "номер телефона (цифры без пробелов)\nпол (символ латиницей f или m)");
        String input = sc.nextLine();
        String[] data = input.split(" ");
        
        checkQuantity(data);
        String[] fullName = new String[3];
        String birthday = null;
        long phoneNumber = 0;
        String sex = null;

        try {
            for (int i = 0; i < data.length; i++) {
                if (data[i].length() == 1)
                    sex = data[i];
                else if ((Character.isDigit(data[i].charAt(0))) && data[i].contains("."))
                    birthday = data[i];
                else if ((Character.isDigit(data[i].charAt(0))) && !(data[i].contains(".")))
                    try {
                        phoneNumber = Integer.parseInt(data[i]);
                    }catch (NumberFormatException e){
                        throw new ParseDataToIntegerException(e.getMessage());
                    }
                else {
                    try {
                        fullName[0] = data[i];
                        fullName[1] = data[i + 1];
                        fullName[2] = data[i + 2];
                        i += 2;
                    }catch (IndexOutOfBoundsException e){
                        throw new FullNameReadFromDataException(e.getMessage());
                    }
                }
            }
        }catch (RuntimeException e){
            throw new ParseDataException(e.getMessage());
        }

      
        
        checkFullName(fullName);
        checkBirthday(birthday);
        checkSex(sex);

        

        String[] infoToWrite = getInfoToWrite(fullName, birthday, phoneNumber, sex);
        writeToFile(infoToWrite);

    }

    public static boolean checkQuantity(String data[]) {
        if(data.length != 6)
            throw new CheckQuantityException();
        return true;
    }

    public static boolean checkFullName(String[] fullName) {

        for (int i = 0; i < fullName.length; i++) {
            if(fullName[i].length() == 0)
                throw new FullNameEmptyValueException();
            for (int j = 0; j < fullName[i].length(); j++) {
                if(Character.isDigit(fullName[i].charAt(j)))
                    throw new FullNameContainsDigitException();
            }
        }
        return true;
    }

    public static boolean checkBirthday(String birthday) {
        String[] birthdayArray = birthday.split("\\.");
        if(birthdayArray.length!=3 || birthdayArray[0].length()!=2 || birthdayArray[1].length()!=2 || birthdayArray[2].length()!=4)
            throw new BirthdayFormatException();

        for (String s : birthdayArray) {
            for (int j = 0; j < s.length(); j++) {
                if (!(Character.isDigit(s.charAt(j))))
                    throw new BirthdayFormatException();
            }
        }
        return true;
    }

    public static boolean checkSex(String sex) {
        if(sex.equals(""))
            throw new CheckSexException();
        if(!(sex.contains("f") || sex.contains("m")))
            throw new IncorrectSexValuesException();
        return true;
    }

    public static boolean createFile(String path) throws FileCreateException {
        File file = new File(path);
        try {
            return file.createNewFile();
        }catch (IOException e){
            throw new FileCreateException(e.getMessage());
        }
    }

    public static String[] getInfoToWrite(String[] fullName, String birthday, long phoneNumber, String sex) {
        String[] infoArray = new String[2];
        StringBuilder sb = new StringBuilder();
        sb.append("<").append(fullName[0]).append(">").append("<").append(fullName[1]).append(">");
        sb.append("<").append(fullName[2]).append(">").append("<").append(birthday).append(">");
        sb.append("<").append(phoneNumber).append(">").append("<").append(sex).append(">");

        infoArray[0] = fullName[0];
        infoArray[1] = sb.toString();

        sb = new StringBuilder();
        return infoArray;
    }

    public static boolean findTheSameFileName(String lastName, String folderName) {
        File folder = new File(folderName);
        boolean found = false;

        for(File file: folder.listFiles()){
            String fileName = file.getName().split("\\.")[0];

            if(fileName.equals(lastName)) {
                found = true;
                break;
            }
        }
        return found;
    }

    public static boolean writeToFile(String[] infoToWrite) throws TheSameFileWritingException, MyFileCreateException {
        String pathProject = System.getProperty("user.dir");
        
        String path = pathProject + "/Exceptions_HW/HW3/data/" + infoToWrite[0] + ".txt";

            try {
                createFile(path);
                System.out.println("New file created");
            } catch (FileCreateException e) {
                throw new MyFileCreateException(e.getMessage());
            }
            try {
                FileWriter fileWriter = new FileWriter(path, true);
                fileWriter.write(infoToWrite[1]+"\n");
                fileWriter.close();
                System.out.println("The data write");
            }catch (IOException e){
                throw new TheSameFileWritingException(e.getMessage());
            }
        
        return true;
    }


}


