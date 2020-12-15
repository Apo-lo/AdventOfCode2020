package AdventOfCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class AdventOfCodeGlobals {

    private File inputsFile (String pathToInputTxtFile) {
        return new File(pathToInputTxtFile);
    }

    //--------------- First of December ---------------
    public ArrayList<Integer> inputsForFirstOfDecember() throws FileNotFoundException {

        ArrayList<Integer> inputsForFirstOfDecember = new ArrayList<>();

        Scanner myReader = new Scanner(inputsFile("src/AdventOfCode/FirstOfDecember/FirstOfDecemberInputs.txt"));

        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            inputsForFirstOfDecember.add(Integer.parseInt(data));
        }
        return inputsForFirstOfDecember;
    }

    //--------------- Second of December ---------------
    private ArrayList<String> inputsForSecondOfDecember () throws FileNotFoundException {

        ArrayList<String> inputsForSecondOfDecember = new ArrayList<>();

        Scanner myReader = new Scanner(inputsFile("src/AdventOfCode/SecondOfDecember/SecondOfDecemberInputs.txt"));

        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            inputsForSecondOfDecember.add(data);
        }
        return inputsForSecondOfDecember;
    }

    public ArrayList<ArrayList<String>> parsedInputsForSecondOfDecember () throws FileNotFoundException {

        ArrayList<String> inputs = inputsForSecondOfDecember();
        ArrayList<ArrayList<String>> parsedInputs = new ArrayList<>();
        ArrayList<String> temporaryStringList;

        String minimalAndMaximalNumberOfOccurrences;
        String StringWithCharacterToCheck;
        String password;

        String minimalNumberOfOccurrences;
        String maximalNumberOfOccurrences;

        for (String input : inputs) {
            temporaryStringList = new ArrayList<>();

            String[] splittedInputString = input.split(" ");

            minimalAndMaximalNumberOfOccurrences = splittedInputString[0];
            password = splittedInputString[2];

            minimalNumberOfOccurrences = minimalAndMaximalNumberOfOccurrences.split("-")[0];
            maximalNumberOfOccurrences = minimalAndMaximalNumberOfOccurrences.split("-")[1];

            StringWithCharacterToCheck = splittedInputString[1].split(":")[0];

            temporaryStringList.add(minimalNumberOfOccurrences);
            temporaryStringList.add(maximalNumberOfOccurrences);
            temporaryStringList.add(StringWithCharacterToCheck);
            temporaryStringList.add(password);

            parsedInputs.add(temporaryStringList);
        }
        return parsedInputs;
    }

    //--------------- Third of December ---------------
    public ArrayList<String> inputsForThirdOfDecember() throws FileNotFoundException {

        ArrayList<String> inputsForThirdOfDecember = new ArrayList<>();

        Scanner myReader = new Scanner(inputsFile("src/AdventOfCode/ThirdOfDecember/ThirdOfDecemberInput.txt"));

        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            inputsForThirdOfDecember.add(data);
        }
        return inputsForThirdOfDecember;
    }
}
