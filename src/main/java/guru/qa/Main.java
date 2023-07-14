package guru.qa;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Runner.runProgram();
    }

    public static class Runner {
        public static void runProgram() {
            Scanner scanner = new Scanner(System.in);
            boolean running = true;

            while (running) {
                System.out.println("Какую программу вы хотите запустить?");
                System.out.println("1. sayHello");
                System.out.println("2. sayHelloToSpecificName");
                System.out.println("3. multiplesOfThree");
                System.out.println("4. Stop");

                int choice = scanner.nextInt();
                scanner.nextLine();

                Solution solution = new Solution();

                switch (choice) {
                    case 1:
                        System.out.println("Введите число от 1 до 10");
                        String number = scanner.nextLine();
                        solution.sayHello(number);
                        break;
                    case 2:
                        System.out.println("Введите имя:");
                        String name = scanner.nextLine();
                        solution.sayHelloToSpecificName(name);
                        break;
                    case 3:
                        System.out.println("Задайте длину целочисленного массива:");
                        int arrLen = scanner.nextInt();
                        scanner.nextLine();
                        System.out.println("Введите элементы массива через запятую.\nНапример: 1,2,3,4,5");
                        String input = scanner.nextLine();
                        String[] elements = input.split(",");
                        if (arrLen < elements.length) {
                            System.out.println("Ошибка. Введенное количество элементов не совпадает с заданной длинной, попробоуйте снова");
                            break;
                        }
                        int[] arr = new int[elements.length];
                        for (int i = 0; i < elements.length; i++) {
                            arr[i] = Integer.parseInt(elements[i].trim());
                        }
                        solution.multiplesOfThree(arr);
                        break;
                    case 4:
                        running = false;
                        break;
                    default:
                        System.out.println("Ошбика. Доступмные опции: 1, 2, 3, 4");
                        break;
                }
            }
        }
    }

    public static class Solution {
        void sayHello(String num) {
            if (Integer.parseInt(num) >= 7) System.out.println("Привет");
        }

        void sayHelloToSpecificName(String name) {
            if (name.equals("Вячеслав")) {
                System.out.println("Привет " + name);
            } else {
                System.out.println("Нет такого имени");
            }
        }

        void multiplesOfThree(int[] arr) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] % 3 == 0) {
                    System.out.println(arr[i]);
                }
            }
        }
    }
}

