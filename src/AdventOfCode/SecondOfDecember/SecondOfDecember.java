package AdventOfCode.SecondOfDecember;

import java.io.FileNotFoundException;

public class SecondOfDecember {

    public static void main (String[] args) throws FileNotFoundException {
        System.out.println("--------- Puzzle One ----------");
        new SecondOfDecemberPuzzleOne().solvePuzzleOne();
        System.out.println("--------- Puzzle Two ----------");
        new SecondOfDecemberPuzzleTwo().solvePuzzleTwo();
        System.out.println("-------------------------------");
    }
}
