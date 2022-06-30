import common.*;
import utils.*;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        //"RBGYBY,RGGYBB,YBRGYR,YGBRRR" =>invalid?!
        //"RBGYBY,BGYGRB,GRRBYG,YYBRGR" =>valid

        String[] cubes = IO.promptUser();
        List<String> firstCubePositions = Positioner.calculateCubePositions(cubes[0]);
        List<String> secondCubePositions = Positioner.calculateCubePositions(cubes[1]);
        List<String> thirdCubePositions = Positioner.calculateCubePositions(cubes[2]);
        List<String> fourthCubePositions = Positioner.calculateCubePositions(cubes[3]);

        List<List<String>> validPermutations = Orchestrator.findValidCubeConfigurations(
                firstCubePositions, secondCubePositions, thirdCubePositions, fourthCubePositions);

        if (validPermutations.isEmpty()) {
            System.err.println(ErrorMessages.NO_VALID_PERMUTATIONS_FOUND);
        } else {
            System.out.println(ResultReader.preparePermutationsForDisplay(validPermutations));
        }
    }
}
