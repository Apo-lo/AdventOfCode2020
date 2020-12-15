package AdventOfCode.ThirdOfDecember;

import java.io.FileNotFoundException;

public class ThirdOfDecember {

    public static void main (String[] args) throws FileNotFoundException {
        System.out.println("--------- Puzzle One ----------");
        new ThirdOfDecemberPuzzleOne().solvePuzzleOne();
        System.out.println("--------- Puzzle Two ----------");
        new ThirdOfDecemberPuzzleTwo().solvePuzzleTwo();
        System.out.println("-------------------------------");
    }
}
