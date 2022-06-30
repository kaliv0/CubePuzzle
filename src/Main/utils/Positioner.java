package Main.utils;

import java.util.*;

public class Positioner {

    //calculates all possibles positions of cube in terms of side directions
    public static List<String> calculateCubePositions(String initialPosition) {
        List<String> positionList = new ArrayList<>();
        positionList.add(initialPosition);

        String secondPosition = initialPosition.substring(1) + initialPosition.charAt(0);
        positionList.add(secondPosition);

        String thirdPosition = secondPosition.substring(1) + secondPosition.charAt(0);
        positionList.add(thirdPosition);

        String fourthPosition = thirdPosition.substring(1) + thirdPosition.charAt(0);
        positionList.add(fourthPosition);

        String fifthPosition = fourthPosition.substring(1) + fourthPosition.charAt(0);
        positionList.add(fifthPosition);

        String sixthPosition = fifthPosition.substring(1) + fifthPosition.charAt(0);
        positionList.add(sixthPosition);

        return positionList;
    }
}
