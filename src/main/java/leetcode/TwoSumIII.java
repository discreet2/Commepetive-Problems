package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TwoSumIII {
    private List<Integer> numbers;

    public TwoSumIII() {
        this.numbers = new ArrayList<>();
    }

    public void add(int n) {
        numbers.add(n);
    }

    public boolean sumTarget(int target) {
        Collections.sort(numbers);
        int i = 0, j = numbers.size() - 1;
        while (i < j) {
            if (numbers.get(i) + numbers.get(j) == target) {
                return true;
            } else if (numbers.get(i) + numbers.get(j) > target) {
                j--;
            } else {
                i++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        TwoSumIII twoSumIII = new TwoSumIII();
        twoSumIII.add(1);
        twoSumIII.add(1);
        twoSumIII.add(5);
        System.out.println(twoSumIII.sumTarget(6));
    }
}
