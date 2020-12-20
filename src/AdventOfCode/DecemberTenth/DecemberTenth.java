package AdventOfCode.DecemberTenth;

import AdventOfCode.AdventOfCodeGlobals;

import java.util.ArrayList;
import java.util.Collections;

public class DecemberTenth {
    static int myDevicesJolts = Collections.max(inputsForDecemberTenth()) + 3;

    public static void main (String[] args) {
        System.out.println("--------- Puzzle One ----------");
        solvePuzzleOne();
        System.out.println("--------- Puzzle Two ----------");
        solvePuzzleTwo();
        System.out.println("-------------------------------");
    }

    private static void solvePuzzleTwo() {
    }

    private static void solvePuzzleOne() {
        ArrayList<Integer> input = inputsForDecemberTenth();
        input.add(0); //starting jolt value
        Collections.sort(input);

        int adaptersWithOneDifference = 0;
        int adaptersWithThreeDifference = 0;

        for (int i = 0; i < input.size(); i++) {
            if (i != input.size() - 1) {
                if (input.get(i + 1) - input.get(i) == 1) {
                    adaptersWithOneDifference++;
                } else if (input.get(i + 1) - input.get(i) == 3) {
                    adaptersWithThreeDifference++;
                }
            } else if (myDevicesJolts - input.get(i) == 1) {
                adaptersWithOneDifference++;
            } else if (myDevicesJolts - input.get(i) == 3) {
                adaptersWithThreeDifference++;
            }
        }
        System.out.println("Number of one jolt difference times jolts of three difference " + (adaptersWithOneDifference * adaptersWithThreeDifference));
    }



    private static ArrayList<Integer> inputsForDecemberTenth() {
        return AdventOfCodeGlobals.getInputsAsIntegers("src/AdventOfCode/DecemberTenth/DecemberTenthInput.txt");
    }

    private static ArrayList<Integer> testInputsForDecemberTenth() {
        return AdventOfCodeGlobals.getInputsAsIntegers("src/AdventOfCode/DecemberTenth/DecemberTenthTestInput.txt");
    }
}
