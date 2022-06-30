package Main.utils;


import Main.common.*;

import java.util.Scanner;
import java.util.regex.*;

public class IO {

    //reads input from user and calls validations on input
    public static String[] promptUser() {
        Scanner sc = new Scanner(System.in);
        System.out.println(Constants.PROMPT_MESSAGE);
        String clientInput = sc.nextLine();
        String[] cubeList = clientInput.split(",");

        validateCubeCount(cubeList.length);
        for (String cube : cubeList) {
            validateSideCount(cube);
            validateColors(cube);
        }
        return cubeList;
    }

    //checks if user entered 4 cubes, if not prompts user to enter input again
    private static void validateCubeCount(int cubeCount) {
        if (cubeCount != Constants.VALID_CUBE_COUNT) {
            System.err.println(ErrorMessages.INVALID_INPUT);
            promptUser();
        }
    }

    //checks if all cubes have 6 sides
    private static void validateSideCount(String cube) {
        if (cube.length() != Constants.VALID_SIDE_COUNT) {
            System.err.println(ErrorMessages.INVALID_SIDE_COUNT);
            promptUser();
        }
    }

    //checks cube colors and if each cube contains all the valid colors
    private static void validateColors(String cube) {
        Pattern pattern = Pattern.compile(Constants.CUBE_TESTER);
        Matcher matcher = pattern.matcher(cube);
        boolean matchFound = matcher.find();
        if (!matchFound) {
            System.err.println(ErrorMessages.INVALID_COLORS);
            promptUser();
        }
        if (cube.indexOf('R') == -1 || cube.indexOf('B') == -1
                || cube.indexOf('G') == -1 || cube.indexOf('Y') == -1) {
            System.err.println(ErrorMessages.INVALID_COLORS);
            promptUser();
        }
    }
}
