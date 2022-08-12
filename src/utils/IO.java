package utils;


import constants.*;

import java.util.Scanner;
import java.util.regex.*;

public class IO {

    //reads input from user and calls validations on input
    public static String[] promptUser() {
        Scanner scanner = new Scanner(System.in);
        System.out.println(PromptMessages.PROMPT_MESSAGE);
        String clientInput = scanner.nextLine();
        String[] cubeList = clientInput.split(Separators.CUBE_LIST_SEPARATOR);

        validateCubeCount(cubeList.length);
        for (String cube : cubeList) {
            validateSideCount(cube);
            validateColors(cube);
        }
        return cubeList;
    }

    //checks if user entered 4 cubes, if not prompts user to enter input again
    private static void validateCubeCount(int cubeCount) {
        if (cubeCount != Counts.VALID_CUBE_COUNT) {
            System.err.println(ErrorMessages.INVALID_INPUT);
            promptUser();
        }
    }

    //checks if all cubes have 6 sides
    private static void validateSideCount(String cube) {
        if (cube.length() != Counts.VALID_SIDE_COUNT) {
            System.err.println(ErrorMessages.INVALID_SIDE_COUNT);
            promptUser();
        }
    }

    //checks cube colors and if each cube contains all the valid colors
    private static void validateColors(String cube) {
        boolean matchFound =
                Pattern.compile(Validations.CUBE_TESTER)
                    .matcher(cube)
                    .find();

        if (!matchFound) {
            System.err.println(ErrorMessages.INVALID_COLORS);
            promptUser();
        }
        if (!cube.contains(Colors.RED) || !cube.contains(Colors.BLUE)
                || !cube.contains(Colors.GREEN) || !cube.contains(Colors.YELLOW)) {
            System.err.println(ErrorMessages.INVALID_COLORS);
            promptUser();
        }
    }
}