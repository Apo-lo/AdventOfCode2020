package AdventOfCode.DecemberTenth;

import AdventOfCode.AdventOfCodeGlobals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class DecemberTenth {
    static int myDevicesJolts = Collections.max(inputsForDecemberTenth()) + 3;
    static int numberOfPermutations = 0;

    public static void main (String[] args) {
        System.out.println("--------- Puzzle One ----------");
        solvePuzzleOne();
        System.out.println("--------- Puzzle Two ----------");
        solvePuzzleTwo();
        System.out.println("-------------------------------");
    }

    private static void solvePuzzleTwo() {
        Map<Integer, Long> memoizationMap = new HashMap<>();
        System.out.println("Number of valid permutations: " + dynamicApproach(0, memoizationMap, inputsForDecemberTenth()));
    }

    private static void solvePuzzleOne() {
        ArrayList<Integer> input = inputsForDecemberTenth();

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

    public static long dynamicApproach(int i, Map<Integer, Long> memoizationMap, ArrayList<Integer> inputs) {
        long result = 0;
        if (i == inputs.size() - 1) {
            return 1;
        }
        if (memoizationMap.containsKey(i)) {
            return memoizationMap.get(i);
        }
        for (int j = i + 1; j < inputs.size(); j++) {
            if ((inputs.get(j) - inputs.get(i)) <= 3) {
                result += dynamicApproach(j, memoizationMap, inputs);
            }
        }
        memoizationMap.put(i, result);
        return result;
    }


    private static ArrayList<Integer> inputsForDecemberTenth() {
        ArrayList<Integer> input = AdventOfCodeGlobals.getInputsAsIntegers("src/AdventOfCode/DecemberTenth/DecemberTenthInput.txt");
        input.add(0);
        Collections.sort(input);
        return input;
    }

    private static ArrayList<Integer> testInputsForDecemberTenth() {
        return AdventOfCodeGlobals.getInputsAsIntegers("src/AdventOfCode/DecemberTenth/DecemberTenthTestInput.txt");
    }
}
