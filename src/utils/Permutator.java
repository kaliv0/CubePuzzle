package utils;

import constants.Separators;

import java.util.*;

public class Permutator {

    //static fields are used for computational and memory management reasons
    private static String[] elements;
    private static boolean[] used;
    private static String[] permutation;
    public static List<String> result;

    //calculates possible permutations between given cube positions
    public static List<String> calculatePermutations(
            String firstCubePosition, String secondCubePosition,
            String thirdCubePosition, String fourthCubePosition) {

        elements = new String[]{firstCubePosition, secondCubePosition,
                thirdCubePosition, fourthCubePosition};
        used = new boolean[elements.length];
        permutation = new String[elements.length];
        result = new ArrayList<>();

        permute(0);
        return result;
    }

    //creates individual permutation from given cubePositions
    private static void permute(int index) {
        if (index == elements.length) {
            result.add(String.join(Separators.PERMUTATION_STRING_SEPARATOR, permutation));
            return;
        }
        for (int i = 0; i < elements.length; i++) {
            if (used[i]) {
                continue;
            }
            permutation[index] = elements[i];
            used[i] = true;
            permute(index + 1);
            used[i] = false;
        }
    }
}