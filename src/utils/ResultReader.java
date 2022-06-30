package utils;

import constants.*;

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
                String[] currPermutation = permutation.split(Separators.PERMUTATION_STRING_SEPARATOR);

                sb.append(PromptMessages.HEADER_MESSAGE)
                        .append(Separators.CUBE_STACK_SEPARATOR)
                        .append(prepareCubesForDisplay(currPermutation))
                        .append(Separators.CUBE_STACK_SEPARATOR);
            }
        }
        sb.append(PromptMessages.PERMUTATION_COUNT)
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
                    .collect(Collectors.joining(Separators.COlOR_SEPARATOR));

            cubeNumber = i + 1;
            sb.append(cubeNumber)
                    .append(Separators.COlOR_SEPARATOR)
                    .append(joinedColors)
                    .append(Separators.CUBE_STACK_SEPARATOR);
        }
        return sb.toString();
    }
}