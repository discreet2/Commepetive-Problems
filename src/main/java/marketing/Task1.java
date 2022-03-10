package marketing;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

//https://stackoverflow.com/questions/66686574/iterate-array-of-mapstring-object-and-return-maplong-long-using-java-8
public class Task1 {
    public static void main(String[] args) {
        Task1 task1 = new Task1();
        UserStats userStats = new UserStats(1L);
        Map<String, UserStats> map1 = new HashMap<>();


        System.out.println(task1.count(map1));
    }

    Map<Long, Long> count(Map<String, UserStats>... visits) {
        Map<Long, Long> resultMap = new HashMap<>();
        if (visits == null||visits.length==0) return resultMap;
        for (Map<String, UserStats> map : visits) {
            Set<Map.Entry<String, UserStats>> entries = map.entrySet();
            for (Map.Entry<String, UserStats> entry : entries) {
                if (isNumeric(entry.getKey()) && entry.getValue() != null
                        && entry.getValue().getVisitCount().isPresent()) {
                    Long key = Long.parseLong(entry.getKey());
                    Long currentCount = resultMap.get(key);
                    if (resultMap.containsKey(key)) {
                        resultMap.put(key, currentCount + entry.getValue().getVisitCount().get());
                    } else {
                        resultMap.put(key, entry.getValue().getVisitCount().get());
                    }
                }
            }
        }
        return resultMap;
    }

    private boolean isNumeric(String str) {
        try {
            Long.parseLong(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
