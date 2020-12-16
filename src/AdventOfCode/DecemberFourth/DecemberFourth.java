package AdventOfCode.DecemberFourth;

import AdventOfCode.AdventOfCodeGlobals;

import java.io.FileNotFoundException;
import java.util.*;

public class DecemberFourth {

    public static void main (String[] args) {
        System.out.println("--------- Puzzle One ----------");
        solvePuzzleOne();
        System.out.println("--------- Puzzle Two ----------");
        solvePuzzleTwo();
        System.out.println("-------------------------------");
    }

    private static String[] requiredFields() {
        return new String[]{"byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid"};
    }

    private static String[] allFields() {
        return new String[]{"byr", "iyr", "eyr", "hgt", "hcl", "ecl", "pid", "cid"};
    }

    private static Dictionary<String, String> passportFieldToRegexDictionary() {
        Dictionary<String, String> passportFieldToRegexDictionary = new Hashtable<>();
        String[] requiredFields = requiredFields();

        passportFieldToRegexDictionary.put(requiredFields[0], "^(19[2-9][0-9]|200[0-2])$");
        passportFieldToRegexDictionary.put(requiredFields[1], "^(20\\d|201\\d|2020)$");
        passportFieldToRegexDictionary.put(requiredFields[2], "^(202\\d|2030)$");
        passportFieldToRegexDictionary.put(requiredFields[3], "^(1[5-8][0-9]cm|19[0-3]cm)|(59in|6[0-9]in|7[0-6]in)$");
        passportFieldToRegexDictionary.put(requiredFields[4], "^(#[0-9a-z]{6})$");
        passportFieldToRegexDictionary.put(requiredFields[5], "^(amb|blu|brn|gry|grn|hzl|oth)$");
        passportFieldToRegexDictionary.put(requiredFields[6], "^([0-9]{9})$");

        return passportFieldToRegexDictionary;
    }

    private static void solvePuzzleOne() {
        System.out.println("Number of valid passports: " + calculateSumOfValidPassportsForPuzzleOne().size());
    }

    public static ArrayList<Dictionary<String, String>> calculateSumOfValidPassportsForPuzzleOne() {

        ArrayList<Dictionary<String, String>> inputs = parseInputsForFourthOfDecember();
        ArrayList<Dictionary<String, String>> validPassports = new ArrayList<>();

        String[] requiredFields = requiredFields();
        String[] allFields = allFields();

        int numberOfValidPassports = 0;

        for(Dictionary<String, String> eachPassportFieldsDictionary : inputs) {
            boolean isValidPassport = true;
            if(eachPassportFieldsDictionary.size() != allFields.length) {
                List<String> eachPassportFields = Collections.list(eachPassportFieldsDictionary.keys());
                for(String eachRequiredField : requiredFields) {
                    if (!eachPassportFields.contains(eachRequiredField)) {
                        isValidPassport = false;
                        break;
                    }
                }
            }
            if(isValidPassport) {
                numberOfValidPassports++;
                validPassports.add(eachPassportFieldsDictionary);
            }
        }
        return validPassports;
    }

    public static ArrayList<String> inputsForFourthOfDecember() {
        ArrayList<String> inputsForFourthOfDecember = AdventOfCodeGlobals.getInputsAsString("src/AdventOfCode/DecemberFourth/DecemberFourthInputs.txt");
        inputsForFourthOfDecember.add(""); //Scanner does not read last empty line of file, but this is needed for later
        return inputsForFourthOfDecember;
    }

    public static ArrayList<Dictionary<String, String>> parseInputsForFourthOfDecember() {

        ArrayList<String> inputs = inputsForFourthOfDecember();

        ArrayList<Dictionary<String, String>> parsedPassportInformation = new ArrayList<>();

        ArrayList<String> passportInformation = new ArrayList<>();
        StringBuilder temporaryLineCache = new StringBuilder();

        for(String eachInputLine : inputs) {
            if (!eachInputLine.isBlank()) {
                temporaryLineCache.append(eachInputLine).append(" ");
            } else {
                passportInformation.add(temporaryLineCache.substring(0, temporaryLineCache.length() - 1));
                temporaryLineCache = new StringBuilder();
            }
        }

        for(String eachPassportInformation : passportInformation) {
            String[] eachPassportField = eachPassportInformation.split(" ");
            Dictionary<String, String> namAndValueOfEachPassportFieldDictionary = new Hashtable<>();

            for(String eachPassportFieldString : eachPassportField) {
                String[] namAndValueOfEachPassportField = eachPassportFieldString.split(":");
                namAndValueOfEachPassportFieldDictionary.put(namAndValueOfEachPassportField[0], namAndValueOfEachPassportField[1]);
            }
            parsedPassportInformation.add(namAndValueOfEachPassportFieldDictionary);
        }
        return parsedPassportInformation;
    }

    public static void solvePuzzleTwo() {
        ArrayList<Dictionary<String, String>> inputs = calculateSumOfValidPassportsForPuzzleOne(); //We only need to check the valid passports
        Dictionary<String, String> passportFieldToRegexDictionary = passportFieldToRegexDictionary();

        int numberOfValidPassports = 0;
        boolean isValidPassport;
        String validRegEx;

        for (Dictionary<String, String> eachPassportFieldsDictionary: inputs) {
            isValidPassport = true;
            List<String> eachPassportFields = Collections.list(eachPassportFieldsDictionary.keys());
            for (String eachPassportField : eachPassportFields) {
                validRegEx = passportFieldToRegexDictionary.get(eachPassportField);
                if (!eachPassportField.equals("cid")) {
                    if (!eachPassportFieldsDictionary.get(eachPassportField).matches(validRegEx)) {
                        isValidPassport = false;
                    }
                }
            }
            if (isValidPassport) {
                numberOfValidPassports++;
            }
        }
        System.out.println("Number of valid passports: " + numberOfValidPassports);
    }
}
