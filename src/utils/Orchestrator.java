package utils;

import constants.*;

import java.util.*;

public class Orchestrator {

    //loops through positions of all cubes and finds all valid configuration between them if any
    public static List<List<String>> findValidCubeConfigurations(
            List<String> firstCubePositions, List<String> secondCubePositions,
            List<String> thirdCubePositions, List<String> fourthCubePositions) {

        List<List<String>> validPermutations = new ArrayList<>();
        for (int firstIndexer = 0; firstIndexer < Counts.VALID_SIDE_COUNT; firstIndexer++) {
            for (int secondIndexer = 0; secondIndexer < Counts.VALID_SIDE_COUNT; secondIndexer++) {
                for (int thirdIndexer = 0; thirdIndexer < Counts.VALID_SIDE_COUNT; thirdIndexer++) {
                    for (int fourthIndexer = 0; fourthIndexer < Counts.VALID_SIDE_COUNT; fourthIndexer++) {
                        List<String> permutations = Permutator.calculatePermutations(
                                firstCubePositions.get(firstIndexer), secondCubePositions.get(secondIndexer),
                                thirdCubePositions.get(thirdIndexer), fourthCubePositions.get(fourthIndexer));

                        List<String> currResult = Extractor.extractValidPermutations(permutations);
                        //avoids duplicates from symmetric cubes
                        if (currResult.size() != 0 && !validPermutations.contains(currResult)) {
                            validPermutations.add(currResult);
                        }
                    }
                }
            }
        }
        return validPermutations;
    }
}