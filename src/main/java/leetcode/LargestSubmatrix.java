package leetcode;

public class LargestSubmatrix {
    //https://leetcode.com/problems/largest-submatrix-with-rearrangements/
    //LeetCode 1727
    public static void main(String[] args) {
        int maxtix[][] = {
                {0, 0, 1},
                {1, 1, 1},
                {1, 0, 1}
        };
    }

    public int largestSubmatrix(int[][] matrix) {
        int arr[] = new int[matrix[0].length];
        //find all column length where that cell is 1
        //order by descending order of column length
        //rearrange column by descending order of column lenght
        //area= number of 1 in first c
        return 0;
    }
    class Data{
        int colIndex;
        int onCellCount;
        int maxAdjacencyCount;

    }


}
