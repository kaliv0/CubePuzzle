package Tests;

import Main.utils.Permutator;
import org.junit.jupiter.api.*;

import java.util.List;

class PermutatorTest {

    @Test
    void calculatePermutations() {
        //Arrange
        String firstCubePosition = "First";
        String secondCubePosition = "Second";
        String thirdCubePosition = "Third";
        String fourthCubePosition = "Fourth";

        int expectedPermutationsCount = 24;

        //Act
        List<String> result = Permutator.calculatePermutations(
                firstCubePosition, secondCubePosition,
                thirdCubePosition, fourthCubePosition);

        //Assert
        Assertions.assertEquals(result.size(), expectedPermutationsCount);

        Assertions.assertTrue(result.get(0).contains("First"));
        Assertions.assertTrue(result.get(0).contains("Second"));
        Assertions.assertTrue(result.get(0).contains("Third"));
        Assertions.assertTrue(result.get(0).contains("Fourth"));

        Assertions.assertFalse(result.get(0).contains("FirstFirst"));
        Assertions.assertFalse(result.get(0).contains("SecondSecond"));
        Assertions.assertFalse(result.get(0).contains("ThirdThird"));
        Assertions.assertFalse(result.get(0).contains("FourthFourth"));
    }
}