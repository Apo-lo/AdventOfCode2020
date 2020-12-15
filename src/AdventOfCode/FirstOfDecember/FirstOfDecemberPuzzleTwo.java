package AdventOfCode.FirstOfDecember;

import AdventOfCode.AdventOfCodeGlobals;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class FirstOfDecemberPuzzleTwo {

    public void solvePuzzleTwo() throws FileNotFoundException {

        ArrayList<Integer> inputs = new AdventOfCodeGlobals().inputsForFirstOfDecember();

        for (int i = 0; i < inputs.size(); i++) {
            for (int j = i + 1; j < inputs.size(); j++) {
                for (int k = j + 1; k < inputs.size(); k ++) {
                    int firstNumber = inputs.get(i);
                    int secondNumber = inputs.get(j);
                    int thirdNumber = inputs.get(k);

                    if (firstNumber + secondNumber + thirdNumber == 2020) {
                        System.out.println("The three entries that sum up 2020 are " + firstNumber + " " + secondNumber + " " + thirdNumber);
                        System.out.println("The Answer is " + firstNumber + " * " + secondNumber + " = " + (firstNumber * secondNumber * thirdNumber));
                    }
                }
            }
        }
    }
}
