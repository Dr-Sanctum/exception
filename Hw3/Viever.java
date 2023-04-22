package Hw3;

import java.util.Scanner;

public class Viever {
    private Scanner scanner = new Scanner(System.in, "cp866");
    public String getInfoConsole() {
        
        System.out.println("Введите свои данные в одну строку разделяя пробелом: \n" 
                            + "1. Имя\n" 
                            + "2. Фамилия\n"
                            + "3. Отчество\n"
                            + "4. Дата рождения в формате: dd.mm.yyyy\n"
                            + "5. Номер телефона\n"
                            + "6. Пол (m или f)\n");
        String info = scanner.nextLine();
        return info;
    }
    public void littleData() {
        System.out.println("Введено недостаточно данных");
    }

    public void lotsOfData() {
        System.out.println("Введены лишние данные");
    }

    public void closeScanner() {
        scanner.close();
    }
}
