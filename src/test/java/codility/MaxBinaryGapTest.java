package codility;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaxBinaryGapTest {

    @Test
    public void testMaxBinaryGap() {
        MaxBinaryGap maxBinaryGap = new MaxBinaryGap();
        Assertions.assertEquals(4, maxBinaryGap.solution(74901729));
        Assertions.assertEquals(2, maxBinaryGap.solution(51712));
        Assertions.assertEquals(2, maxBinaryGap.solution(328));
        Assertions.assertEquals(1, maxBinaryGap.solution(20));
        Assertions.assertEquals(2, maxBinaryGap.solution(9));
        Assertions.assertEquals(4, maxBinaryGap.solution(529));
        Assertions.assertEquals(0, maxBinaryGap.solution(15));
        Assertions.assertEquals(0, maxBinaryGap.solution(32));
        Assertions.assertEquals(5, maxBinaryGap.solution(1041));
    }
}
