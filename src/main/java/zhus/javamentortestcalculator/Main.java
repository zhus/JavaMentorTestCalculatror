package zhus.javamentortestcalculator;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        System.out.println("Калькулятор умеет выполнять операции");
        System.out.println("сложения, вычитания, умножения и деления с двумя числами:");
        System.out.println("a + b, a - b, a * b, a / b\n");

        Scanner sc = new Scanner(System.in);

        while (sc.hasNextLine()) {

            String input = sc.nextLine();

            if (input.isEmpty()) {
                System.exit(0);
            }

            try {
                System.out.println(new Xpression(input).parse().evaluate());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }

        }

    }

}
