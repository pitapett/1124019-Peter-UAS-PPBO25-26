package utils;

import java.util.Scanner;

public class CLIUtil {
    private static final Scanner scn = new Scanner(System.in);

    public static String getString() {
        String input = scn.nextLine();
        return input;
    }

    public static int getInt() {
        String inputString;
        int inputToInt = 0;
        boolean isValidInput = false;

        while (!isValidInput) {
            inputString = scn.nextLine();
            try {
                inputToInt = Integer.parseInt(inputString);
                isValidInput = true;
            } catch (NumberFormatException nfe) {
                System.out.println("Invalid input, please enter a nuumber.");
            }
        }
        return inputToInt;
    }

    public static double getDouble() {
        String inputString;
        double inputToDouble = 0.0;
        boolean isValidInput = false;

        while (!isValidInput) {
            inputString = scn.nextLine();

            try {
                inputToDouble = Double.parseDouble(inputString);
                isValidInput = true;

            } catch (NumberFormatException nfe) {
                System.out.println("Invalid input. Please enter a number (e.g., 12.34 or 5).");
            }
        }
        return inputToDouble;
    }
}
