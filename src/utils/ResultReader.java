package utils;

import common.Constants;

import java.nio.CharBuffer;
import java.util.List;
import java.util.stream.Collectors;

public class ResultReader {

    public static String preparePermutationsForDisplay(List<List<String>> validPermutations) {
        StringBuilder sb = new StringBuilder();
        int permutationCounter = 0;
        for (List<String> permutationList : validPermutations) {
            for (String permutation : permutationList) {
                permutationCounter++;
                String[] currPermutation = permutation.split(" ");

                sb.append(Constants.HEADER_MESSAGE);
                sb.append("\n");
                sb.append(prepareCubesForDisplay(currPermutation));
                sb.append("\n");
            }
        }
        sb.append(Constants.PERMUTATION_COUNT + permutationCounter);
        return sb.toString();
    }

    private static String prepareCubesForDisplay(String[] currPermutation) {
        StringBuilder sb = new StringBuilder();
        char[] colorArray;
        int cubeNumber;
        for (int i = 0; i < currPermutation.length; i++) {
            colorArray = currPermutation[i].toCharArray();

            String joinedColors = CharBuffer.wrap(colorArray).chars()
                    .mapToObj(intValue -> String.valueOf((char) intValue))
                    .collect(Collectors.joining(Constants.COlOR_SEPARATOR));

            cubeNumber = i + 1;
            sb.append(String.format("%d%s%s\n", cubeNumber, Constants.COlOR_SEPARATOR, joinedColors));
        }
        return sb.toString();
    }
}
