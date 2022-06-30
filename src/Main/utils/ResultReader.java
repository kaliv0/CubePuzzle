package Main.utils;

import Main.common.Constants;

import java.nio.CharBuffer;
import java.util.List;
import java.util.stream.Collectors;

public class ResultReader {

    //prepares final message for display form given list of permutations
    public static String preparePermutationsForDisplay(List<List<String>> validPermutations) {
        StringBuilder sb = new StringBuilder();
        int permutationCounter = 0;
        for (List<String> permutationList : validPermutations) {
            for (String permutation : permutationList) {
                permutationCounter++;
                String[] currPermutation = permutation.split(" ");

                sb.append(Constants.HEADER_MESSAGE)
                        .append("\n")
                        .append(prepareCubesForDisplay(currPermutation))
                        .append("\n");
            }
        }
        sb.append(Constants.PERMUTATION_COUNT)
                .append(permutationCounter);
        return sb.toString();
    }

    //prepares each cube i.e. row in stack for given permutation
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
            sb.append(cubeNumber)
                    .append(Constants.COlOR_SEPARATOR)
                    .append(joinedColors)
                    .append("\n");
        }
        return sb.toString();
    }
}
