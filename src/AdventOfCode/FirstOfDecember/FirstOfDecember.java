package AdventOfCode.FirstOfDecember;

import java.io.FileNotFoundException;

public class FirstOfDecember {

    public static void main (String[] args) throws FileNotFoundException {
        System.out.println("--------- Puzzle One ----------");
        new FirstOfDecemberPuzzleOne().solvePuzzleOne();
        System.out.println("--------- Puzzle Two ----------");
        new FirstOfDecemberPuzzleTwo().solvePuzzleTwo();
        System.out.println("-------------------------------");
    }
}
