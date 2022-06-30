package utils;

import java.util.*;

public class Orchestrator {
    public static List<List<String>> findValidCubeConfigurations(
            List<String> firstCubePositions, List<String> secondCubePositions,
            List<String> thirdCubePositions, List<String> fourthCubePositions) {

        List<List<String>> validPermutations = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            for (int j = 0; j < 6; j++) {
                for (int k = 0; k < 6; k++) {
                    for (int l = 0; l < 6; l++) {
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
