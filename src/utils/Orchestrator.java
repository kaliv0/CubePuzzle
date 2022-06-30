package utils;

import common.Constants;

import java.util.*;

public class Orchestrator {

    //loops through positions of all cubes and finds all valid configuration between them if any
    public static List<List<String>> findValidCubeConfigurations(
            List<String> firstCubePositions, List<String> secondCubePositions,
            List<String> thirdCubePositions, List<String> fourthCubePositions) {

        List<List<String>> validPermutations = new ArrayList<>();
        for (int i = 0; i < Constants.VALID_SIDE_COUNT; i++) {
            for (int j = 0; j < Constants.VALID_SIDE_COUNT; j++) {
                for (int k = 0; k < Constants.VALID_SIDE_COUNT; k++) {
                    for (int l = 0; l < Constants.VALID_SIDE_COUNT; l++) {
                        List<String> permutations = Permutator.calculatePermutations(
                                firstCubePositions.get(i), secondCubePositions.get(j),
                                thirdCubePositions.get(k), fourthCubePositions.get(l));

                        List<String> currResult = Extractor.extractValidPermutations(permutations);
                        if (currResult.size() != 0) {
                            validPermutations.add(currResult);
                        }
                    }
                }
            }
        }
        return validPermutations;
    }
}
