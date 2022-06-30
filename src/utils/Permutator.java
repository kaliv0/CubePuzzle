package utils;

import java.util.*;

public class Permutator {

    private static String[] elements;
    private static boolean[] used;
    private static String[] permutation;
    public static List<String> result;

    public static List<String> calculatePermutations(
            String firstCube, String secondCube, String thordCube, String fourthCube) {

        elements = new String[]{firstCube, secondCube, thordCube, fourthCube};
        used = new boolean[elements.length];
        permutation = new String[elements.length];
        result = new ArrayList<>();

        permute(0);
        return result;
    }

    private static void permute(int index) {
        if (index == elements.length) {
            result.add(String.join(" ", permutation));
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
