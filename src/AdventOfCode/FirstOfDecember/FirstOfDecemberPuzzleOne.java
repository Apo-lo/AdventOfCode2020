package AdventOfCode.FirstOfDecember;

import AdventOfCode.AdventOfCodeGlobals;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class FirstOfDecemberPuzzleOne {

    public void solvePuzzleOne() throws FileNotFoundException {

        ArrayList<Integer> inputs = new AdventOfCodeGlobals().inputsForFirstOfDecember();

        for (int i = 0; i < inputs.size(); i++) {
            for (int j = i + 1; j < inputs.size(); j++) {

                int firstNumber = inputs.get(i);
                int secondNumber = inputs.get(j);

                if (firstNumber + secondNumber == 2020) {
                    System.out.println("The two entries that sum up 2020 are " + firstNumber + " " + secondNumber);
                    System.out.println("The Answer is " + firstNumber + " * " + secondNumber + " = " + (firstNumber * secondNumber));
                }
            }
        }
    }
}
