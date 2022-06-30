package Tests;

import Main.utils.Orchestrator;
import org.junit.jupiter.api.*;

import java.util.*;

class OrchestratorTest {

    @Test
    void findValidCubeConfigurations() {
        //Arrange
        List<String> firstCubePositions = new ArrayList(Arrays.asList(
                "AAAAAA", "AAAAAA", "AAAAAA", "AAAAAA", "AAAAAA", "AAAAAA"));
        List<String> secondCubePositions = new ArrayList(Arrays.asList(
                "BBBBBB", "BBBBBB", "BBBBBB", "BBBBBB", "BBBBBB", "BBBBBB"));
        List<String> thirdCubePositions = new ArrayList(Arrays.asList(
                "CCCCCC", "CCCCCC", "CCCCCC", "CCCCCC", "CCCCCC", "CCCCCC"));
        List<String> fourthCubePositions = new ArrayList(Arrays.asList(
                "DDDDDD", "DDDDDD", "DDDDDD", "DDDDDD", "DDDDDD", "DDDDDD"));

        int expectedConfigurationsCount = 1;

        //Act
        List<List<String>> result = Orchestrator.findValidCubeConfigurations(
                firstCubePositions, secondCubePositions, thirdCubePositions, fourthCubePositions);

        //Assert
        Assertions.assertEquals(result.size(), expectedConfigurationsCount);
        Assertions.assertEquals(result.get(0).get(0), "AAAAAA BBBBBB CCCCCC DDDDDD");
        Assertions.assertEquals(result.get(0).get(1), "AAAAAA BBBBBB DDDDDD CCCCCC");
        Assertions.assertEquals(result.get(0).get(2), "AAAAAA CCCCCC BBBBBB DDDDDD");
        Assertions.assertEquals(result.get(0).get(3), "AAAAAA CCCCCC DDDDDD BBBBBB");
    }
}