package codility;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TapeEquilibriumTest {
    @Test
    public void test() {
        TapeEquilibrium tapeEquilibrium = new TapeEquilibrium();
        Assertions.assertEquals(0, tapeEquilibrium.solution(new int[]{1,1}));
        Assertions.assertEquals(1, tapeEquilibrium.solution(new int[]{3, 1, 2, 4, 3}));
        Assertions.assertEquals(1, tapeEquilibrium.solution(new int[]{9, 3, 9, -3, 7}));
    }
}
