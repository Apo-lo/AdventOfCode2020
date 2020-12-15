package AdventOfCode.SecondOfDecember;

import AdventOfCode.AdventOfCodeGlobals;

import java.io.FileNotFoundException;
import java.util.ArrayList;


public class SecondOfDecemberPuzzleOne {
    public void solvePuzzleOne() throws FileNotFoundException {

        int numberOfOccurrences;
        int numberOfValidPasswords = 0;

        for (ArrayList<String> eachInputLine : new AdventOfCodeGlobals().parsedInputsForSecondOfDecember()) {

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
}
