package Tests;

import Main.utils.Extractor;
import org.junit.jupiter.api.*;

import java.util.*;

class ExtractorTest {

    @Test
    void extractValidPermutations() {
        //Arrange
        String firstValidPermutation = "AAAA BBBB CCCC DDDD";
        String secondValidPermutation = "WWWW XXXX YYYY ZZZZ";
        String InvalidPermutation = "AAAA AAAA BBBB, CDCD";
        List<String> permutationList = new ArrayList<>(Arrays.asList(
                firstValidPermutation, secondValidPermutation, InvalidPermutation));
        int expectedValidPermutationsCount = 2;

        //Act
        List<String> result = Extractor.extractValidPermutations(permutationList);

        //Assert
        Assertions.assertEquals(result.size(), expectedValidPermutationsCount);
        Assertions.assertEquals(result.get(0), firstValidPermutation);
        Assertions.assertEquals(result.get(1), secondValidPermutation);
    }
}