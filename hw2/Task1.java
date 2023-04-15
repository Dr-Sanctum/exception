package hw2;

import java.util.Scanner;

/**
 * Задание 1
 * Реализуйте метод, который запрашивает у пользователя ввод дробного числа
 * (типа float), и возвращает введенное значение.
 * Ввод текста вместо числа не должно приводить к
 * падению приложения, вместо этого, необходимо
 * повторно запросить у пользователя ввод данных.
 */

public class Task1 {
    public static void main(String[] args) {
        System.out.println(myMethod());
    }

    public static float myMethod() {
        Scanner scanner = new Scanner(System.in, "cp866");
        Float result;
        while (true) {
            try {
                System.out.println("Введите целое или дробное число:");
                result = Float.parseFloat(scanner.nextLine());
                scanner.close();
                return result;
            } catch (NumberFormatException e) {
                System.out.println("Неверный формат ввода");
            }
        }
    }
}
