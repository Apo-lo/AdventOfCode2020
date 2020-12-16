package AdventOfCode.FirstOfDecember;

import AdventOfCode.AdventOfCodeGlobals;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FirstOfDecember {

    public static void main (String[] args) {
        System.out.println("--------- Puzzle One ----------");
        solvePuzzleOne();
        System.out.println("--------- Puzzle Two ----------");
        solvePuzzleTwo();
        System.out.println("-------------------------------");
    }

    public static ArrayList<Integer> inputsForFirstOfDecember() {
        return AdventOfCodeGlobals.getInputsAsIntegers("src/AdventOfCode/FirstOfDecember/FirstOfDecemberInputs.txt");
    }

    public static void solvePuzzleOne() {

        ArrayList<Integer> inputs = inputsForFirstOfDecember();

        for (int i = 0; i < inputs.size(); i++) {
            for (int j = i + 1; j < inputs.size(); j++) {

                int firstNumber = inputs.get(i);
                int secondNumber = inputs.get(j);

                if (firstNumber + secondNumber == 2020) {
                    System.out.println("The two entries that sum up to 2020 are " + firstNumber + ", " + secondNumber);
                    System.out.println("The Answer is " + firstNumber + " * " + secondNumber + " = " + (firstNumber * secondNumber));
                }
            }
        }
    }

    public static void solvePuzzleTwo() {

        ArrayList<Integer> inputs = inputsForFirstOfDecember();

        for (int i = 0; i < inputs.size(); i++) {
            for (int j = i + 1; j < inputs.size(); j++) {
                for (int k = j + 1; k < inputs.size(); k ++) {
                    int firstNumber = inputs.get(i);
                    int secondNumber = inputs.get(j);
                    int thirdNumber = inputs.get(k);

                    if (firstNumber + secondNumber + thirdNumber == 2020) {
                        System.out.println("The three entries that sum up to 2020 are " + firstNumber + ", " + secondNumber + ", " + thirdNumber);
                        System.out.println("The Answer is " + firstNumber + " * " + secondNumber + " * " + thirdNumber + " = " + (firstNumber * secondNumber * thirdNumber));
                    }
                }
            }
        }
    }
}
