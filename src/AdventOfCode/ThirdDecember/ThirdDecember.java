package AdventOfCode.ThirdDecember;

import AdventOfCode.AdventOfCodeGlobals;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class ThirdDecember {

    public static void main (String[] args) {
        System.out.println("--------- Puzzle One ----------");
        solvePuzzleOne();
        System.out.println("--------- Puzzle Two ----------");
        solvePuzzleTwo();
        System.out.println("-------------------------------");
    }

    public static void solvePuzzleOne() {

        ArrayList<String> inputs = inputsForThirdOfDecember();

        System.out.println("Number of trees in the path: " + calculateNumberOfTrees(inputs, 3, 1));
    }

    public static void solvePuzzleTwo() {

        ArrayList<String> inputs = inputsForThirdOfDecember();

        int rightOneDownOne = calculateNumberOfTrees(inputs, 1, 1);
        int rightThreeDownOne = calculateNumberOfTrees(inputs, 3, 1);
        int rightFiveDownOne = calculateNumberOfTrees(inputs, 5, 1);
        int rightSevenDownOne = calculateNumberOfTrees(inputs, 7, 1);
        int rightOneDownTwo = calculateNumberOfTrees(inputs, 1, 2);

        int sumOfSlopes = rightOneDownOne * rightThreeDownOne * rightFiveDownOne * rightSevenDownOne * rightOneDownTwo;


        System.out.println("Number of trees in the path: " + sumOfSlopes);
    }

    private static int calculateNumberOfTrees(ArrayList<String> inputs, int rightMoves, int downMoves) {

        int numberOfTrees = 0;
        int indexForNextLine = 0;
        char treeIndicator = '#';

        for (int i = 0; i < inputs.size(); i = i + downMoves) {

            if (inputs.get(i).length() <= indexForNextLine)  {
                indexForNextLine = indexForNextLine - inputs.get(i).length();
            }

            if (inputs.get(i).charAt(indexForNextLine) == treeIndicator) {
                numberOfTrees++;
            }
            indexForNextLine = indexForNextLine + rightMoves;
        }
        return numberOfTrees;
    }

    private static ArrayList<String> inputsForThirdOfDecember() {
        return AdventOfCodeGlobals.getInputsAsString("src/AdventOfCode/ThirdDecember/ThirdDecemberInput.txt");
    }

}
