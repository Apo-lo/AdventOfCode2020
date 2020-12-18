package AdventOfCode.DecemberNinth;

import AdventOfCode.AdventOfCodeGlobals;

import java.math.BigInteger;
import java.util.ArrayList;
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

    /*ToDo
       while all sum < my number -> sum + next number (index in loop) if sum == my Number
       save numbers in list return list min * max
     */


    }

    private static void solvePuzzleOne() {
        ArrayList<BigInteger> input = inputsForDecemberNinth();

        for(int i = 25; i < input.size(); i++) {
            if(!sumUp(input.subList(i - 25, i), input.get(i))) {
                System.out.println("First number that does not sum up: " + input.get(i));
                break;
            }
        }
    }

    private static boolean sumUp(List<BigInteger> previousNumbers, BigInteger numberToCheck) {
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
}
