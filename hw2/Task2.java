package hw2;

/**
 * Задание 2
 *  Если необходимо, исправьте данный код
 * Исходный код:
 * try {
 *    int d = 0;
 *    double catchedRes1 = intArray[8] / d;
 *    System.out.println("catchedRes1 = " + catchedRes1);
 * } catch (ArithmeticException e) {
 *    System.out.println("Catching exception: " + e);
 * }
 * 
 */

public class Task2 {
    public static void main(String[] args) {

        int[] intArray = { 1, 3, 6, 7, 8, 3, 5, 34 };
        try {
            int d = 0;
            double catchedRes1 = (double) intArray[8] / d;
            System.out.println("catchedres1 = " + catchedRes1);
        } catch (ArithmeticException e) {
            System.out.println("Catching exeption: " + e);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Catching exeption: " + e);
        }
    }
}
