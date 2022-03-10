package leetcode;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class MaxNumberOfMeetingTest {
    @Test
    public void test() {
        MaxNumberOfMeeting m = new MaxNumberOfMeeting();
        Assertions.assertEquals(4, m.getMaximumMeetings(new int[]{1, 3, 0, 5, 8, 5}, new int[]{2, 4, 6, 7, 9, 9}));
        Assertions.assertEquals(3, m.getMaximumMeetings(new int[]{75250, 50074, 43659, 8931, 11273, 27545, 50879, 77924}, new int[]{112960, 114515, 81825, 93424, 54316, 35533, 73383, 160252}));
        Assertions.assertEquals(4, m.getMaximumMeetings(new int[]{1, 3, 3, 5, 7}, new int[]{3, 5, 4, 7, 8}));

    }
}
