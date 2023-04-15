package hw2;

import java.util.Scanner;

/**
 * Задание 3
 * Разработайте программу, которая выбросит Exception,
 * когда пользователь вводит пустую строку.
 * Пользователю должно показаться сообщение,
 * что пустые строки вводить нельзя.
 */

public class Task4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in, "cp866");
        boolean flag = true;
        while (flag) {
            System.out.println("Введите текст: ");
            String text = scanner.nextLine();
            if (!text.isEmpty()) {
                System.out.println("Введённый тест: " + text);
                scanner.close();
                flag = false;
            } else {
                System.out.println("Введена пустая строка");
            }

        }

    }

}
