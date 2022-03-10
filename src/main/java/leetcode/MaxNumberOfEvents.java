package leetcode;

import java.util.*;

//https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/
//https://leetcode.com/problems/maximum-number-of-events-that-can-be-attended/discuss/1753756/Simple-Java-solution-using-Tree-Set-with-proper-explanation-!!
public class MaxNumberOfEvents {
    class Event {
        int start;
        int end;

        public Event(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public int maxEvents(int[][] events) {
        int result = 0;
        List<Event> eventList = new ArrayList<>();
        for (int[] event : events) {
            Event e = new Event(event[0], event[1]);
            eventList.add(e);
        }
        eventList.sort(Comparator.comparingInt((Event e) -> e.end).thenComparing((Event e) -> e.start));
        TreeSet<Integer> daysPool = new TreeSet<>();
        for (int i = 1; i <= 100000; i++) {
            daysPool.add(i);
        }

        for (Event event : eventList) {
            // O(LogN)
            Integer lower = daysPool.ceiling(event.start);
            if (lower == null || lower > event.end) {
                continue;
            }
            // LOG N
            daysPool.remove(lower);
            result++;
        }
        return result;
    }
}
