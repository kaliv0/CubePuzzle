package Main.utils;

import Main.common.Constants;

import java.util.*;

public class Extractor {

    //extracts from possible permutations only valid ones according to given puzzle conditions
    public static List<String> extractValidPermutations(List<String> permutationList) {
        List<String> result = new ArrayList<>();
        boolean isValidPermutation = false;

        for (String permutationString : permutationList) {
            String[] currPermutation = permutationString.split(" ");
            isValidPermutation = validateColors(isValidPermutation, currPermutation);

            if (isValidPermutation) {
                result.add(permutationString);
            }
        }
        return result;
    }

    //validates all colors in column of cube stack
    private static boolean validateColors(boolean isValidPermutation, String[] currPermutation) {
        for (int row = 0; row < Constants.PERMUTATION_LENGTH; row++) {
            Set<Character> set = new HashSet<>();
            for (int col = 0; col < Constants.PERMUTATION_LENGTH; col++) {
                set.add(currPermutation[col].charAt(row));
            }
            isValidPermutation = set.size() == Constants.VALID_COLOR_COUNT;
            if (!isValidPermutation) {
                break;
            }
        }
        return isValidPermutation;
    }
}
