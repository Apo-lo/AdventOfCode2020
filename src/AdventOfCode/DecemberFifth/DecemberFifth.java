package AdventOfCode.DecemberFifth;

import AdventOfCode.AdventOfCodeGlobals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.stream.IntStream;

public class DecemberFifth {

    public static void main (String[] args) {
        System.out.println("--------- Puzzle One ----------");
        solvePuzzleOne();
        System.out.println("--------- Puzzle Two ----------");
        solvePuzzleTwo();
        System.out.println("-------------------------------");
    }

    private static int[] initializeRowsArray() {
        return IntStream.rangeClosed(0, 127).toArray();
    }

    private static int[] initializeColumnsArray() {
        return IntStream.rangeClosed(0, 7).toArray();
    }

    public static void solvePuzzleOne() {
        System.out.println("Maximum seat id: " + Collections.max(calculateAllSeatIds()));
    }

    private static ArrayList<Integer> calculateAllSeatIds () {
        ArrayList<String> inputsForDecemberFifth = inputsForDecemberFifth();
        ArrayList<Integer> seatIds = new ArrayList<>(inputsForDecemberFifth.size());

        String rowsSeatPositionIndicator;
        String columnsSeatPositionIndicator;

        int rowId = 0;
        int columnId = 0;

        for(String eachSeatPositionIndicatorString : inputsForDecemberFifth) {
            rowsSeatPositionIndicator = eachSeatPositionIndicatorString.substring(0, 7);
            columnsSeatPositionIndicator = eachSeatPositionIndicatorString.substring(7);
            int[] rowsArray = initializeRowsArray();
            int[] columnsArray = initializeColumnsArray();

            for(int i = 0; i < rowsSeatPositionIndicator.length(); i++) {
                rowsArray = splitArrayAccordingSeatPosition(rowsSeatPositionIndicator.charAt(i), rowsArray);
            }

            for(int i = 0; i < columnsSeatPositionIndicator.length(); i++) {
                columnsArray = splitArrayAccordingSeatPosition(columnsSeatPositionIndicator.charAt(i), columnsArray);
            }
            if (rowsArray.length == 1 && columnsArray.length == 1) {
                rowId = rowsArray[0];
                columnId = columnsArray[0];
            }
            seatIds.add(rowId * 8 + columnId);
        }
        return seatIds;
    }

    private static char frontIndicator() {
        return 'F';
    }

    private static char backIndicator() {
        return 'B';
    }

    private static char rightIndicator() {
        return 'R';
    }

    private static char leftIndicator() {
        return 'L';
    }

    private static void solvePuzzleTwo() {

        ArrayList<Integer> missingSeatIds = new ArrayList<>();
        ArrayList<Integer> seatIds = calculateAllSeatIds();

        for(int rowNumber : initializeRowsArray()) {
            for(int columnsNumber : initializeColumnsArray()) {
                int calculatedSeatId = rowNumber * 8 + columnsNumber;
                if(!seatIds.contains(calculatedSeatId)) {
                    if(seatIds.contains(calculatedSeatId - 1) && seatIds.contains(calculatedSeatId + 1)) {
                        System.out.println("My seat id: " + calculatedSeatId);
                        break;
                    }
                }
            }
        }
    }

    private static int[] splitArrayAccordingSeatPosition(char seatPositionIndicator, int[] rowsOrColumnsArray) {

        if(seatPositionIndicator == frontIndicator()) {
            return Arrays.copyOfRange(rowsOrColumnsArray, 0, rowsOrColumnsArray.length / 2);
        } else if (seatPositionIndicator == backIndicator()) {
            return Arrays.copyOfRange(rowsOrColumnsArray, rowsOrColumnsArray.length / 2, rowsOrColumnsArray.length);
        } else if (seatPositionIndicator == rightIndicator()) {
            return Arrays.copyOfRange(rowsOrColumnsArray, rowsOrColumnsArray.length / 2, rowsOrColumnsArray.length);
        } else if (seatPositionIndicator == leftIndicator()) {
            return Arrays.copyOfRange(rowsOrColumnsArray, 0, rowsOrColumnsArray.length / 2);
        }
        return new int[0];
    }

    private static ArrayList<String> inputsForDecemberFifth() {
        return AdventOfCodeGlobals.getInputsAsString("src/AdventOfCode/DecemberFifth/DecemberFifthInputs.txt");
    }
}
