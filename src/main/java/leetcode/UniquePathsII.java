package leetcode;
//https://leetcode.com/problems/unique-paths-ii/
public class UniquePathsII {
    public static void main(String[] args) {
        UniquePathsII uniquePathsII = new UniquePathsII();
        int obs[][] = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        System.out.println(uniquePathsII.uniquePathsWithObstacles(obs));
        int obs2[][] = {
                {0, 1},
                {0, 0}
        };
        System.out.println(uniquePathsII.uniquePathsWithObstacles(obs2));
    }

    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        if (obstacleGrid[m - 1][n - 1] == 1) return 0;
        int dp[][] = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {

          /*Now if we are in the last column or last row we only have one choice either we move
          right only in case we are in last row or we can move only bottom in case we are in last column to reach bottom corner*/
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else if (i == m - 1 && j == n - 1) {
                    dp[i][j] = 1;
                } else if (i == m - 1) {
                    dp[i][j] = Math.min(1, dp[i][j + 1]);
                } else if (j == n - 1) {
                    dp[i][j] = Math.min(1, dp[i + 1][j]);
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
