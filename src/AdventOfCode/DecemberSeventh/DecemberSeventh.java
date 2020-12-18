package AdventOfCode.DecemberSeventh;

import AdventOfCode.AdventOfCodeGlobals;

import java.util.*;

public class DecemberSeventh {
    public static void main (String[] args) {
        System.out.println("--------- Puzzle One ----------");
        solvePuzzleOne();
        System.out.println("--------- Puzzle Two ----------");
        solvePuzzleTwo();
        System.out.println("-------------------------------");
    }

    private static void solvePuzzleOne() {
        System.out.println("Number of bags we can use: " + findNumberOfBagsThatLinkToRootBag("shiny gold bag"));
    }

    public static int findNumberOfBagsThatLinkToRootBag (String targetName) {
        int numberOfBags = 0;
        HashMap<String, HashMap<String, Integer>> fullRuleSet = parseInputsForDecemberSeventh();
        for(Map.Entry<String, HashMap<String, Integer>> line : fullRuleSet.entrySet()) {
            if (containsTargetBag(targetName, line.getValue().keySet(), fullRuleSet)) {
                numberOfBags++;
            }
        }
        return numberOfBags;
    }

    public static boolean containsTargetBag (String targetName, Collection<String> insideBags, HashMap<String, HashMap<String, Integer>> fullRuleSet) {
        for(String eachInsideBag : insideBags) {
            if(targetName.equals(eachInsideBag)) {
                return true;
            }
            if(containsTargetBag(targetName, fullRuleSet.get(eachInsideBag).keySet(), fullRuleSet)) {
                return true;
            }
        }
        return false;
    }

    private static int countInsideBags(HashMap<String, Integer> insideBags, HashMap<String, HashMap<String, Integer>> fullRuleSet) {
        if(insideBags.isEmpty()) {
            return 0;
        }
        int total = 0;
        for(String eachInsideBag : insideBags.keySet()) {
            total += (countInsideBags(fullRuleSet.get(eachInsideBag), fullRuleSet) + 1) * insideBags.get(eachInsideBag);
        }
        return total;
    }


    private static void solvePuzzleTwo() {
        System.out.println("Number of bags we can use: " + countInsideBags(parseInputsForDecemberSeventh().get("shiny gold bag"), parseInputsForDecemberSeventh()));
    }

    private static ArrayList<String> inputsForDecemberSeventh() {
        return AdventOfCodeGlobals.getInputsAsString("src/AdventOfCode/DecemberSeventh/DecemberSeventhInput.txt");
    }

    private static ArrayList<String> testInputForDecemberSeventh() {
        return AdventOfCodeGlobals.getInputsAsString("src/AdventOfCode/DecemberSeventh/DecemberSeventhTestInput.txt");
    }

    private static HashMap<String, HashMap<String, Integer>> parseInputsForDecemberSeventh() {
        ArrayList<String> inputsForDecemberSeventh = inputsForDecemberSeventh();

        HashMap<String, HashMap<String, Integer>> bigBagsToContainingBags = new HashMap<>(inputsForDecemberSeventh.size());
        HashMap<String, Integer> smallBagsWithQuantity;

        String[] allBagsInInputLine;
        String[] allSmallBagNames;
        String bigBagName;

        int quantityOfBag;

        for (String eachBagRule : inputsForDecemberSeventh) {
            smallBagsWithQuantity = new HashMap<>();
            quantityOfBag = 0;
            allBagsInInputLine = eachBagRule.split("contain");
            bigBagName = allBagsInInputLine[0];
            bigBagName = bigBagName.substring(0, bigBagName.length() - 2);
            allSmallBagNames = allBagsInInputLine[1].split(",");

            for(String eachSmallBagName : allSmallBagNames) {
                eachSmallBagName = eachSmallBagName.substring(1);
                if(eachSmallBagName.charAt(0) == 'n') {
                    break;
                }
                if(eachSmallBagName.charAt(eachSmallBagName.length() - 1) == '.') {
                    eachSmallBagName = eachSmallBagName.substring(0, eachSmallBagName.length() - 1);
                }
                if (eachSmallBagName.charAt(eachSmallBagName.length() - 1) == 's'){
                    eachSmallBagName = eachSmallBagName.substring(0, eachSmallBagName.length() - 1);
                }
                if (Character.isDigit(eachSmallBagName.charAt(0))) {
                    quantityOfBag = Character.getNumericValue(eachSmallBagName.charAt(0));
                    eachSmallBagName = eachSmallBagName.substring(2);
                }
                smallBagsWithQuantity.put(eachSmallBagName, quantityOfBag);
            }
            bigBagsToContainingBags.put(bigBagName, smallBagsWithQuantity);
        }
        return bigBagsToContainingBags;
    }
}
