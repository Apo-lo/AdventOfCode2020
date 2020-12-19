package AdventOfCode.DecemberNinth;

import AdventOfCode.AdventOfCodeGlobals;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class DecemberNinth {
    public static void main (String[] args) {
        System.out.println("--------- Puzzle One ----------");
        solvePuzzleOne();
        System.out.println("--------- Puzzle Two ----------");
        solvePuzzleTwo();
        System.out.println("-------------------------------");
    }

    private static void solvePuzzleTwo() {
        List<BigInteger> result = calculateListOfNumbers();
        System.out.println("Sum of max and min number in list: " + (Collections.max(result).add(Collections.min(result))));
    }
    private static List<BigInteger> calculateListOfNumbers() {
        BigInteger invalidNumber = BigInteger.valueOf(41682220);
        ArrayList<BigInteger> input = inputsForDecemberNinth();
        BigInteger sum = BigInteger.valueOf(0);
        List<BigInteger> numberOfSum = new ArrayList<>();

        for (int i = 0; i < input.size(); i++) {
            sum = sum.add(input.get(i));
            numberOfSum.add(input.get(i));
            for (int j = i + 1; j < input.size(); j++) {
                sum = sum.add(input.get(j));
                numberOfSum.add(input.get(j));
                if(sum.equals(invalidNumber) && numberOfSum.size() >= 2) {
                    return numberOfSum;
                } else if (sum.compareTo(invalidNumber) > 0) {
                    break;
                }
            }
            sum = BigInteger.valueOf(0);
            numberOfSum = new ArrayList<>();
        }
        return numberOfSum;
    }

    private static void solvePuzzleOne() {
        ArrayList<BigInteger> input = inputsForDecemberNinth();

        for(int i = 25; i < input.size(); i++) {
            if(!sumOfTwo(input.subList(i - 25, i), input.get(i))) {
                System.out.println("First number that does not sum up: " + input.get(i));
                break;
            }
        }
    }

    private static boolean sumOfTwo(List<BigInteger> previousNumbers, BigInteger numberToCheck) {
        int sizeOfList = previousNumbers.size();
        for (int i = 0; i < sizeOfList; i++) {
            for (BigInteger previousNumber : previousNumbers) {
                if (previousNumbers.get(i).add(previousNumber).equals(numberToCheck) && !previousNumbers.get(i).equals(previousNumber)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static ArrayList<BigInteger> inputsForDecemberNinth() {
        return AdventOfCodeGlobals.getInputsAsBigIntegers("src/AdventOfCode/DecemberNinth/DecemberNinthInput.txt");
    }

    private static ArrayList<BigInteger> testInputsForDecemberNinth() {
        return AdventOfCodeGlobals.getInputsAsBigIntegers("src/AdventOfCode/DecemberNinth/DecemberNinthTestInput.txt");
    }
}
