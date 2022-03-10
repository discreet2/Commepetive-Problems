package leetcode;
//https://leetcode.com/problems/unique-paths/
public class UniquePaths {
    public static void main(String[] args) {
        System.out.println(new UniquePaths().uniquePaths(3, 7));
    }

    public int uniquePaths(int m, int n) {
        //Initialize dp array of grid size
        int dp[][] = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

          /*Now if we are in the last column or last row we only have one choice either we move
          right only in case we are in last row or we can move only bottom in case we are in last column to reach bottom corner*/

                if (i == m - 1 || j == n - 1) {
                    dp[i][j] = 1;
                }
                /*For anywhere else in the grid we can have total paths(unique) that are
                from left+ total paths that are from right */
                else {
                    dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                }
            }
        }

        return dp[0][0];
    }
}
