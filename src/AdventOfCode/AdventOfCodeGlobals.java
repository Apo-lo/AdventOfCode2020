package AdventOfCode;

import java.io.File;
import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Scanner;

public class AdventOfCodeGlobals {

    public static File inputsFile(String pathToInputTxtFile) {
        return new File(pathToInputTxtFile);
    }

    public static ArrayList<String> getInputsAsString(String pathToInputFile) {

        ArrayList<String> inputsForFourthOfDecember = new ArrayList<>();

        Scanner myReader;
        try {
            myReader = new Scanner(AdventOfCodeGlobals.inputsFile(pathToInputFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return inputsForFourthOfDecember;
        }

        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            inputsForFourthOfDecember.add(data);
        }

        return inputsForFourthOfDecember;
    }

    public static ArrayList<Integer> getInputsAsIntegers(String pathToInputFile) {

        ArrayList<Integer> inputsForFirstOfDecember = new ArrayList<>();

        Scanner myReader;
        try {
            myReader = new Scanner(AdventOfCodeGlobals.inputsFile(pathToInputFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return inputsForFirstOfDecember;
        }

        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            inputsForFirstOfDecember.add(Integer.parseInt(data));
        }
        return inputsForFirstOfDecember;
    }

    public static ArrayList<BigInteger> getInputsAsBigIntegers(String pathToInputFile) {

        ArrayList<BigInteger> inputsForFirstOfDecember = new ArrayList<>();

        Scanner myReader;
        try {
            myReader = new Scanner(AdventOfCodeGlobals.inputsFile(pathToInputFile));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return inputsForFirstOfDecember;
        }

        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            inputsForFirstOfDecember.add(new BigInteger(data));
        }
        return inputsForFirstOfDecember;
    }
}
