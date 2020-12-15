package AdventOfCode.SecondOfDecember;

import AdventOfCode.AdventOfCodeGlobals;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class SecondOfDecemberPuzzleTwo {

    public void solvePuzzleTwo() throws FileNotFoundException {

        int numberOfValidPasswords = 0;

        for (ArrayList<String> eachInputLine : new AdventOfCodeGlobals().parsedInputsForSecondOfDecember()) {

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
}
