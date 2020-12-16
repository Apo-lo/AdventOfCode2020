package AdventOfCode.DecemberSixth;

import AdventOfCode.AdventOfCodeGlobals;

import java.util.ArrayList;
import java.util.Dictionary;
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
    }

    private static void solvePuzzleOne() {
        int sum = 0;
        for (Set<Character> distinctCustomsDeclarationFormAnswers : parseInputsForDecemberSixth()) {
            sum = sum + distinctCustomsDeclarationFormAnswers.size();
        }
        System.out.println("Sum of all distinct answers " + sum);
    }

    private static ArrayList<String> inputsForDecemberSixth() {
        ArrayList<String> inputsForSixthOfDecember = AdventOfCodeGlobals.getInputsAsString("src/AdventOfCode/DecemberSixth/DecemberSixthInput.txt");
        inputsForSixthOfDecember.add(""); //Scanner does not read last empty line of file, but this is needed for later
        return inputsForSixthOfDecember;
    }

    private static ArrayList<Set<Character>> parseInputsForDecemberSixth() {
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

}
