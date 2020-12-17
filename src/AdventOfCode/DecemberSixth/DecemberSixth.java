package AdventOfCode.DecemberSixth;

import AdventOfCode.AdventOfCodeGlobals;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DecemberSixth {
    public static void main (String[] args) {
        System.out.println("--------- Puzzle One ----------");
        solvePuzzleOne();
        System.out.println("--------- Puzzle Two ----------");
        solvePuzzleTwo();
        System.out.println("-------------------------------");

    }

    private static void solvePuzzleTwo() {
        ArrayList<ArrayList<String>> parsedInputsOfPuzzleTwo = parseInputsForDecemberSixthPuzzleTwo();

        int numberOfPeopleInGroup;
        int numberOfCharOccurrences;
        int sumOfAllAnswers = 0;

        StringBuilder allAnswersString;

        for(ArrayList<String> eachGroupsAnswers : parsedInputsOfPuzzleTwo) {
            numberOfPeopleInGroup = eachGroupsAnswers.size();
            allAnswersString = new StringBuilder();

            for (String eachPersonAnswer : eachGroupsAnswers) {
                allAnswersString.append(eachPersonAnswer);
            }

            for (int i = 0; i < eachGroupsAnswers.get(0).length(); i++) { //We only need to loop the first Person of every group
                numberOfCharOccurrences = 0;
                for (int j = 0; j < allAnswersString.length(); j++) {
                    if (eachGroupsAnswers.get(0).charAt(i) == allAnswersString.charAt(j)) {
                        numberOfCharOccurrences++;
                    }
                }
                if (numberOfCharOccurrences == numberOfPeopleInGroup) {
                    sumOfAllAnswers++;
                }
            }
        }
        System.out.println("Number of answers everybody had: " + sumOfAllAnswers);
    }

    private static void solvePuzzleOne() {
        int sum = 0;
        for (Set<Character> distinctCustomsDeclarationFormAnswers : parseInputsForDecemberSixthPuzzleOne()) {
            sum = sum + distinctCustomsDeclarationFormAnswers.size();
        }
        System.out.println("Sum of all distinct answers " + sum);
    }

    private static ArrayList<String> inputsForDecemberSixth() {
        ArrayList<String> inputsForSixthOfDecember = AdventOfCodeGlobals.getInputsAsString("src/AdventOfCode/DecemberSixth/DecemberSixthInput.txt");
        inputsForSixthOfDecember.add(""); //Scanner does not read last empty line of file, but this is needed for later
        return inputsForSixthOfDecember;
    }

    private static ArrayList<Set<Character>> parseInputsForDecemberSixthPuzzleOne() {
        ArrayList<String> inputsForSixthOfDecember = inputsForDecemberSixth();

        ArrayList<String> customsDeclarationFormAnswers = new ArrayList<>();
        ArrayList<Set<Character>> customsDeclarationFormAnswerOfAllGroups = new ArrayList<>();
        Set<Character> distinctCustomsDeclarationFormAnswers;
        StringBuilder temporaryLineCache = new StringBuilder();

        for(String eachInputLine : inputsForSixthOfDecember) {
            if (!eachInputLine.isBlank()) {
                temporaryLineCache.append(eachInputLine);
            } else {
                customsDeclarationFormAnswers.add(temporaryLineCache.toString());
                temporaryLineCache = new StringBuilder();
            }
        }

        for(String customsDeclarationFormAnswerOfGroup : customsDeclarationFormAnswers) {
            distinctCustomsDeclarationFormAnswers = new HashSet<>(customsDeclarationFormAnswerOfGroup.length());
            for(int i = 0; i < customsDeclarationFormAnswerOfGroup.length(); i++) {
                distinctCustomsDeclarationFormAnswers.add(customsDeclarationFormAnswerOfGroup.charAt(i));
            }
            customsDeclarationFormAnswerOfAllGroups.add(distinctCustomsDeclarationFormAnswers);
        }
        return customsDeclarationFormAnswerOfAllGroups;
    }

    private static ArrayList<ArrayList<String>> parseInputsForDecemberSixthPuzzleTwo() {
        ArrayList<String> inputsForSixthOfDecember = inputsForDecemberSixth();

        ArrayList<String> eachPersonOfGroupInput = new ArrayList<>();
        ArrayList<ArrayList<String>> everyAnswerGroup = new ArrayList<>();

        for(String eachInputLine : inputsForSixthOfDecember) {
            if (!eachInputLine.isBlank()) {
                eachPersonOfGroupInput.add(eachInputLine);
            } else {
                everyAnswerGroup.add(eachPersonOfGroupInput);
                eachPersonOfGroupInput = new ArrayList<>();
            }
        }
        return everyAnswerGroup;
    }

}
