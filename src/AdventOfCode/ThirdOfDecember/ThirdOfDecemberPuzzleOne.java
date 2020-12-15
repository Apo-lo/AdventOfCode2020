package AdventOfCode.ThirdOfDecember;

import AdventOfCode.AdventOfCodeGlobals;

import java.io.FileNotFoundException;
import java.util.ArrayList;

public class ThirdOfDecemberPuzzleOne {

    public void solvePuzzleOne() throws FileNotFoundException {

        ArrayList<String> inputs = new AdventOfCodeGlobals().inputsForThirdOfDecember();

        System.out.println("Number of trees in the path: " + new ThirdOfDecemberPuzzleTwo().calculateNumberOFTrees(inputs, 3, 1));
    }
}
