package codility;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class CyclicRotationTest {
    @Test
    public void test() {
        CyclicRotation cyclicRotation = new CyclicRotation();
        int arr[] = {3, 8, 9, 7, 6};
        int expected[] = {9, 7, 6, 3, 8};
        Assertions.assertArrayEquals(new int[]{3, 5, 1, 1, 2}, cyclicRotation.solution(new int[]{1, 1, 2, 3, 5}, 42));
        Assertions.assertArrayEquals(new int[]{}, cyclicRotation.solution(new int[]{}, 2));
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 4}, cyclicRotation.solution(new int[]{1, 2, 3, 4}, 0));
        Assertions.assertArrayEquals(new int[]{4, 1, 2, 3}, cyclicRotation.solution(new int[]{1, 2, 3, 4}, 1));
        Assertions.assertArrayEquals(new int[]{3, 4, 1, 2}, cyclicRotation.solution(new int[]{1, 2, 3, 4}, 2));
        Assertions.assertArrayEquals(new int[]{2, 3, 4, 1}, cyclicRotation.solution(new int[]{1, 2, 3, 4}, 3));
        Assertions.assertArrayEquals(new int[]{1, 2, 3, 4}, cyclicRotation.solution(new int[]{1, 2, 3, 4}, 4));
        Assertions.assertArrayEquals(new int[]{4, 1, 2, 3}, cyclicRotation.solution(new int[]{1, 2, 3, 4}, 5));
        Assertions.assertArrayEquals(new int[]{0, 0, 0}, cyclicRotation.solution(new int[]{0, 0, 0}, 1));
        Assertions.assertArrayEquals(new int[]{9, 7, 6, 3, 8}, cyclicRotation.solution(new int[]{3, 8, 9, 7, 6}, 3));
        //Assertions.assertArrayEquals(expected, cyclicRotation.solution(arr, 3));
    }
}
