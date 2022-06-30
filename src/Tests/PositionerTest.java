package Tests;

import Main.utils.Positioner;
import org.junit.jupiter.api.*;

import java.util.List;


class PositionerTest {

    @Test
    void calculateCubePositions() {
        //Arrange
        String initialPosition = "RBGYBY";
        String secondPosition = "BGYBYR";
        String thirdPosition = "GYBYRB";
        String fourthPosition = "YBYRBG";
        String fifthPosition = "BYRBGY";
        String sixthPosition = "YRBGYB";

        //Act
        List<String> result = Positioner.calculateCubePositions(initialPosition);

        //Assert
        Assertions.assertEquals(result.get(0), initialPosition);
        Assertions.assertEquals(result.get(1), secondPosition);
        Assertions.assertEquals(result.get(2), thirdPosition);
        Assertions.assertEquals(result.get(3), fourthPosition);
        Assertions.assertEquals(result.get(4), fifthPosition);
        Assertions.assertEquals(result.get(5), sixthPosition);
    }
}
