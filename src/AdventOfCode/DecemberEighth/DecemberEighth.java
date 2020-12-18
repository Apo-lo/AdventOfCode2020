package AdventOfCode.DecemberEighth;

import AdventOfCode.AdventOfCodeGlobals;

import java.util.*;

public class DecemberEighth {
    static int accumulator = 0;

    public static void main (String[] args) {
        System.out.println("--------- Puzzle One ----------");
        solvePuzzleOne();
        System.out.println("--------- Puzzle Two ----------");
        solvePuzzleTwo();
        System.out.println("-------------------------------");
    }

    private static void solvePuzzleTwo() {
       System.out.println("Accumulator value with termination: " + changeProgram(parseInputForPuzzleOne()));
    }

    private static void solvePuzzleOne() {
        if(!terminates(parseInputForPuzzleOne())) {
            System.out.println("Accumulator value without termination: " + accumulator);
        }
    }

    private static int changeProgram(HashMap<Integer, HashMap<String, Integer>> programInstructions) {
        for(Map.Entry<Integer, HashMap<String, Integer>> eachInstruction : programInstructions.entrySet()) {
            HashMap<String, Integer> theInstruction = eachInstruction.getValue();
            if(theInstruction.containsKey(jumpInstructions())) {
                theInstruction.put(noOperationInstruction(), theInstruction.get(jumpInstructions()));
                theInstruction.remove(jumpInstructions());
                if (terminates(programInstructions)) {
                    return accumulator;
                } else {
                    theInstruction.put(jumpInstructions(), theInstruction.get(noOperationInstruction()));
                    theInstruction.remove(noOperationInstruction());
                }
            } else if (theInstruction.containsKey(noOperationInstruction())) {
                theInstruction.put(jumpInstructions(), theInstruction.get(noOperationInstruction()));
                theInstruction.remove(noOperationInstruction());
                if (terminates(programInstructions)) {
                    return accumulator;
                } else {
                    theInstruction.put(noOperationInstruction(), theInstruction.get(jumpInstructions()));
                    theInstruction.remove(jumpInstructions());
                }
            }
        }
        return 0;
    }

    private static boolean terminates(HashMap<Integer, HashMap<String, Integer>> programInstructions) {
        accumulator = 0;
        int linePointer = 1;
        Set<Integer> executedLines = new HashSet<>();

        while(linePointer != programInstructions.size() + 1) {
            HashMap<String, Integer>nextInstruction = programInstructions.get(linePointer);
            if(!executedLines.contains(linePointer)) {
                if (nextInstruction.containsKey(accumulatorInstruction())) {
                    accumulator += nextInstruction.get(accumulatorInstruction());
                    executedLines.add(linePointer);
                    linePointer++;
                } else if (nextInstruction.containsKey(jumpInstructions())) {
                    executedLines.add(linePointer);
                    linePointer += nextInstruction.get(jumpInstructions());
                } else if (nextInstruction.containsKey(noOperationInstruction())) {
                    executedLines.add(linePointer);
                    linePointer++;
                }
            } else {
                return false;
            }
        }
        return true;
    }


    private static ArrayList<String> inputsForDecemberEighth() {
        return AdventOfCodeGlobals.getInputsAsString("src/AdventOfCode/DecemberEighth/DecemberEighthInputs.txt");
    }

    private static ArrayList<String> testInputsForDecemberEighth() {
        return AdventOfCodeGlobals.getInputsAsString("src/AdventOfCode/DecemberEighth/DecemberEighthTestInput.txt");
    }

    private static HashMap<Integer, HashMap<String, Integer>> parseInputForPuzzleOne() {
        ArrayList<String> inputForDecemberEighth = inputsForDecemberEighth();

        HashMap<Integer, HashMap<String, Integer>> parsedInputsForDecemberEighth = new HashMap<>();
        HashMap<String, Integer> instructionToValue;

        String[] splitedLine;

        int lineNumber = 1;

        for(String eachInputLine : inputForDecemberEighth) {
            instructionToValue = new HashMap<>();
            splitedLine = eachInputLine.split(" ");
            instructionToValue.put(splitedLine[0], Integer.parseInt(splitedLine[1]));
            parsedInputsForDecemberEighth.put(lineNumber, instructionToValue);
            lineNumber++;
        }
        return parsedInputsForDecemberEighth;
    }

    private static String jumpInstructions() {
        return "jmp";
    }

    private static String accumulatorInstruction() {
        return "acc";
    }

    private static String noOperationInstruction() {
        return "nop";
    }
}
