package booking;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Task1 {
    public static void main(String[] args) {
        Task1 task1 = new Task1();
    }

    public static List<Integer> multiple(int x, int y, int z, int n) {
        List<Integer> result = new ArrayList<>();
        if (x == 0 || y == 0 || z == 0 || n < 1) return result;
        for (int num = 1; num <= n; num++) {
            if ((num % x == 0 || num % y == 0) && num % z != 0) {
                result.add(num);
            }
        }
        return result;
    }

    public static List<Integer> missingReservations(List<List<Integer>> firstReservationList, List<List<Integer>> secondReservationList) {
        List<Integer> result = new ArrayList<>();
        Map<Integer, Integer> firstReservationMap = new HashMap<>();
        for (List<Integer> reservation : firstReservationList) {
            int reservationId = reservation.get(0);
            firstReservationMap.put(reservationId, reservationId);
        }
        for (List<Integer> reservation : secondReservationList) {
            int reservationId = reservation.get(0);
            if (!firstReservationMap.containsKey(reservationId)) {
                result.add(reservationId);
            }
        }
        return result;
    }

    public static List<List<Integer>> employeeWithLesserThanKBreaks(List<List<Integer>> employeeCalls, int k) {
        Map<Integer, Integer> employeeBreakCountMap = new HashMap<>();
        Map<Integer, Integer> employeeLastBreakTimeMap = new HashMap<>();
        for (List<Integer> callInfo : employeeCalls) {
            int employeeId = callInfo.get(0);
            int startTime = callInfo.get(1);
            int endTime = callInfo.get(2);
            if (employeeLastBreakTimeMap.containsKey(employeeId)) {
                int lastBreakTime = employeeLastBreakTimeMap.get(employeeId);
                if (startTime > lastBreakTime) {
                    employeeBreakCountMap.put(employeeId, employeeBreakCountMap.getOrDefault(employeeId, 0) + 1);
                }
                employeeLastBreakTimeMap.put(employeeId, endTime);
            } else {
                employeeLastBreakTimeMap.put(employeeId, endTime);
                employeeBreakCountMap.put(employeeId, 0);
            }
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int key : employeeBreakCountMap.keySet()) {
            int breakCount = employeeBreakCountMap.get(key);
            if (breakCount < k) {
                List<Integer> employeeResult = new ArrayList<>();
                employeeResult.add(key);
                employeeResult.add(breakCount);
                result.add(employeeResult);
            }
        }
        return result;
    }

    public static List<Integer> awardTopKHotels(String positiveKeywords, String negativeKeywords, List<Integer> hotelIds, List<String> reviews, int k) {
        Map<String, String> positiveReviewMap = Arrays.stream(positiveKeywords.split(" ")).collect(Collectors.toMap(Function.identity(), Function.identity()));
        Map<String, String> negativeReviewMap = Arrays.stream(negativeKeywords.split(" ")).collect(Collectors.toMap(Function.identity(), Function.identity()));
        Map<Integer, Integer> hotelMap = new HashMap<>();
        Map<Integer, Integer> resultMap = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < hotelIds.size(); i++) {
            hotelMap.put(i, hotelIds.get(i));
        }
        for (int i = 0; i < reviews.size(); i++) {
            String review = reviews.get(i);
            String[] words = review.split(" ");
            int hotelId = hotelMap.get(i);
            int score = resultMap.getOrDefault(hotelId, 0);
            for (String word : words) {
                if (positiveReviewMap.containsKey(word)) {
                    score += 3;
                }
                if (negativeReviewMap.containsKey(word)) {
                    score -= 1;
                }
            }
            resultMap.put(hotelId, score);
        }
        int resultCount=0;
        resultMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .forEachOrdered(x->{
                    if(resultCount<k){
                        result.add(x.getKey());
                    }
                });
        return result;
    }
}
