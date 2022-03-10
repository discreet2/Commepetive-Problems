package leetcode;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MaxNumberOfMeeting {

    class Meeting {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int getMaximumMeetings(int s[], int f[]) {
        List<Meeting> meetings = new ArrayList<>();
        for (int i = 0; i < s.length; i++) {
            Meeting meeting = new Meeting(s[i], f[i]);
            meetings.add(meeting);
        }
        meetings.sort(Comparator.comparingInt(i -> i.end));
        int prevMeetingEndTime = Integer.MIN_VALUE;
        int result = 0;
        for (Meeting meeting : meetings) {
            if (meeting.start >= prevMeetingEndTime) {
                prevMeetingEndTime = meeting.end;
                result++;
            }
        }
        return result;
    }
}
