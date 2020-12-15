package AdventOfCode.ThirdOfDecember;

import AdventOfCode.AdventOfCodeGlobals;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ThirdOfDecemberPuzzleTwo {

    public void solvePuzzleTwo() throws FileNotFoundException {

        ArrayList<String> inputs = new AdventOfCodeGlobals().inputsForThirdOfDecember();

        int rightOneDownOne = calculateNumberOFTrees(inputs, 1, 1);
        int rightThreeDownOne = calculateNumberOFTrees(inputs, 3, 1);
        int rightFiveDownOne = calculateNumberOFTrees(inputs, 5, 1);
        int rightSevenDownOne = calculateNumberOFTrees(inputs, 7, 1);
        int rightOneDownTwo = calculateNumberOFTrees(inputs, 1, 2);

        int sumOfSlopes = rightOneDownOne * rightThreeDownOne * rightFiveDownOne * rightSevenDownOne * rightOneDownTwo;


        System.out.println("Number of trees in the path: " + sumOfSlopes);
    }

    public int calculateNumberOFTrees(ArrayList<String> inputs, int rightMoves, int downMoves) {

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
}
