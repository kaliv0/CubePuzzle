package utils;

import common.*;

import java.util.Scanner;
import java.util.regex.*;

public class IO {
    public static String[] promptUser() {
        Scanner sc = new Scanner(System.in);
        System.out.println(Constants.PROMPT_MESSAGE);
        String clientInput = sc.nextLine();
        String[] inputList = clientInput.split(",");

        if (inputList.length != Constants.VALID_CUBE_COUNT) {
            System.err.println(ErrorMessages.INVALID_INPUT);
            promptUser();
        }
        String firstCube = inputList[0];
        String secondCube = inputList[1];
        String thirdCube = inputList[2];
        String fourthCube = inputList[3];

        if (firstCube.length() != Constants.VALID_SIDE_COUNT
                || secondCube.length() != Constants.VALID_SIDE_COUNT
                || thirdCube.length() != Constants.VALID_SIDE_COUNT
                || fourthCube.length() != Constants.VALID_SIDE_COUNT) {
            System.err.println(ErrorMessages.INVALID_SIDE_COUNT);
            promptUser();
        }

        validateColors(firstCube);
        validateColors(secondCube);
        validateColors(thirdCube);
        validateColors(fourthCube);
        return new String[]{firstCube, secondCube, thirdCube, fourthCube};
    }

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
