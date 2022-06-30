package utils;

import constants.*;

import java.util.*;

public class Extractor {

    private static boolean isValidPermutation = false;

    //extracts from possible permutations only valid ones according to given puzzle conditions
    public static List<String> extractValidPermutations(List<String> permutationList) {
        List<String> result = new ArrayList<>();
        for (String permutationString : permutationList) {
            String[] currPermutation = permutationString.split(Separators.PERMUTATION_STRING_SEPARATOR);

            validateColors(currPermutation);
            if (isValidPermutation) {
                result.add(permutationString);
            }
        }
        return result;
    }

    //validates all colors in column of cube stack
    private static void validateColors(String[] currPermutation) {
        for (int row = 0; row < Counts.PERMUTATION_LENGTH; row++) {
            Set<Character> set = new HashSet<>();
            for (int col = 0; col < Counts.PERMUTATION_LENGTH; col++) {
                set.add(currPermutation[col].charAt(row));
            }
            isValidPermutation = set.size() == Counts.VALID_COLOR_COUNT;
            if (!isValidPermutation) {
                break;
            }
        }
    }
}