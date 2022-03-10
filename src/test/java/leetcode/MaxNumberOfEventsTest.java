package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaxNumberOfEventsTest {
    @Test
    public void test() {
        MaxNumberOfEvents maxEvents = new MaxNumberOfEvents();
        Assertions.assertEquals(5, maxEvents.maxEvents(new int[][]{{1,5},{1,5},{1,5},{2,3},{2,3}}));
        Assertions.assertEquals(4, maxEvents.maxEvents(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 2}}));
        Assertions.assertEquals(3, maxEvents.maxEvents(new int[][]{{1, 2}, {2, 3}, {3, 4}}));
        Assertions.assertEquals(4, maxEvents.maxEvents(new int[][]{{1, 4}, {4, 4}, {2, 2}, {3, 4}, {1, 1}}));
        Assertions.assertEquals(1, maxEvents.maxEvents(new int[][]{{1, 10000}}));
        Assertions.assertEquals(7, maxEvents.maxEvents(new int[][]{{1, 1}, {1, 2}, {1, 3}, {1, 4}, {1, 5}, {1, 6}, {1, 7}}));
    }
}
