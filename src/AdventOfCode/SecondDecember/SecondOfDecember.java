package AdventOfCode.SecondDecember;

import AdventOfCode.AdventOfCodeGlobals;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class SecondOfDecember {

    public static void main (String[] args) {
        System.out.println("--------- Puzzle One ----------");
        solvePuzzleOne();
        System.out.println("--------- Puzzle Two ----------");
        solvePuzzleTwo();
        System.out.println("-------------------------------");
    }

    public static void solvePuzzleOne() {

        int numberOfOccurrences;
        int numberOfValidPasswords = 0;

        for (ArrayList<String> eachInputLine : parsedInputsForSecondOfDecember()) {

            numberOfOccurrences = 0;

            for (int i = 0; i < eachInputLine.get(3).length(); i++) {
                if (eachInputLine.get(3).charAt(i) == eachInputLine.get(2).charAt(0)) {
                    numberOfOccurrences++;
                }
            }

            if (Integer.parseInt(eachInputLine.get(0)) <= numberOfOccurrences && numberOfOccurrences <= Integer.parseInt(eachInputLine.get(1))) {
                numberOfValidPasswords++;
            }
        }
        System.out.println("Number of wrong passwords: " + numberOfValidPasswords);
    }

    public static void solvePuzzleTwo() {

        int numberOfValidPasswords = 0;

        for (ArrayList<String> eachInputLine : parsedInputsForSecondOfDecember()) {

            int firstOccurrence = Integer.parseInt(eachInputLine.get(0));
            int secondOccurrence = Integer.parseInt(eachInputLine.get(1));
            char characterToCheck = eachInputLine.get(2).charAt(0);
            String password = eachInputLine.get(3);
            password = " " + password; //To shift the String so that the password starts at index one

            if (password.length() > firstOccurrence && password.length() > secondOccurrence)  {
                if (password.charAt(firstOccurrence) == characterToCheck && password.charAt(secondOccurrence) != characterToCheck) {
                    numberOfValidPasswords++;
                } else if (password.charAt(firstOccurrence) != characterToCheck && password.charAt(secondOccurrence) == characterToCheck) {
                    numberOfValidPasswords++;
                }
            }
        }
        System.out.println("Number of wrong passwords: " + numberOfValidPasswords);
    }

    private static ArrayList<String> inputsForSecondOfDecember() {
        return AdventOfCodeGlobals.getInputsAsString("src/AdventOfCode/SecondDecember/SecondDecemberInputs.txt");
    }

    private static ArrayList<ArrayList<String>> parsedInputsForSecondOfDecember() {

        ArrayList<String> inputs = inputsForSecondOfDecember();
        ArrayList<ArrayList<String>> parsedInputs = new ArrayList<>();
        ArrayList<String> temporaryStringList;

        String minimalAndMaximalNumberOfOccurrences;
        String StringWithCharacterToCheck;
        String password;

        String minimalNumberOfOccurrences;
        String maximalNumberOfOccurrences;

        for (String input : inputs) {
            temporaryStringList = new ArrayList<>();

            String[] splittedInputString = input.split(" ");

            minimalAndMaximalNumberOfOccurrences = splittedInputString[0];
            password = splittedInputString[2];

            minimalNumberOfOccurrences = minimalAndMaximalNumberOfOccurrences.split("-")[0];
            maximalNumberOfOccurrences = minimalAndMaximalNumberOfOccurrences.split("-")[1];

            StringWithCharacterToCheck = splittedInputString[1].split(":")[0];

            temporaryStringList.add(minimalNumberOfOccurrences);
            temporaryStringList.add(maximalNumberOfOccurrences);
            temporaryStringList.add(StringWithCharacterToCheck);
            temporaryStringList.add(password);

            parsedInputs.add(temporaryStringList);
        }
        return parsedInputs;
    }
}
