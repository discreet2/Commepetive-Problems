package codility;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class OddOccurrenceInArrayTest {
    @Test
    public void test() {
        OddOccurrenceInArray occurrence = new OddOccurrenceInArray();
        Assertions.assertEquals(7, occurrence.solution(new int[]{9, 3, 9, 3, 9, 7, 9}));
        Assertions.assertEquals(5, occurrence.solution(new int[]{5}));
    }
}
