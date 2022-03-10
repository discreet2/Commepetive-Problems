package leetcode;

import java.util.LinkedList;
import java.util.Queue;

//https://leetcode.com/problems/shortest-path-in-binary-matrix/
public class ShortestPathBinaryMatrix {
    public static void main(String[] args) {
        ShortestPathBinaryMatrix shortestPathBinaryMatrix = new ShortestPathBinaryMatrix();
        int grid1[][] = {
                {0, 1},
                {1, 0}
        };
        System.out.println(shortestPathBinaryMatrix.shortestPathBinaryMatrix(grid1));
        int grid2[][] = {
                {0, 0, 0},
                {1, 1, 0},
                {1, 1, 0}
        };
        System.out.println(shortestPathBinaryMatrix.shortestPathBinaryMatrix(grid2));

        int grid3[][] = {
                {1, 0, 0},
                {1, 1, 0},
                {1, 1, 0}
        };
        System.out.println(shortestPathBinaryMatrix.shortestPathBinaryMatrix(grid3));
        int grid4[][] = {
                {0, 1, 1, 0, 0, 0},
                {0, 1, 0, 1, 1, 0},
                {0, 1, 1, 0, 1, 0},
                {0, 0, 0, 1, 1, 0},
                {1, 1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1, 0}
        };
        System.out.println(shortestPathBinaryMatrix.shortestPathBinaryMatrix(grid4));
    }

    class Cell {
        int row;
        int column;
        int visitCount;

        public Cell(int row, int column, int visitCount) {
            this.row = row;
            this.column = column;
            this.visitCount = visitCount;
        }
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int rows = grid.length - 1;
        int cols = grid[0].length - 1;
        if (grid[rows][cols] == 1 || grid[0][0] == 1) return -1;
        int result = Integer.MAX_VALUE;
        Queue<Cell> queue = new LinkedList<>();
        queue.offer(new Cell(0, 0, 1));
        grid[0][0] = 1;
        while (!queue.isEmpty()) {
            Cell currCell = queue.poll();
            if (currCell.row == rows && currCell.column == cols) {
                return currCell.visitCount;
            }
            //left cell
            if (currCell.column - 1 >= 0 && grid[currCell.row][currCell.column - 1] == 0) {
                grid[currCell.row][currCell.column - 1] = 1;
                queue.offer(new Cell(currCell.row, currCell.column - 1, currCell.visitCount + 1));
            }
            //right cell
            if (currCell.column + 1 <= cols && grid[currCell.row][currCell.column + 1] == 0) {
                grid[currCell.row][currCell.column + 1] = 1;
                queue.offer(new Cell(currCell.row, currCell.column + 1, currCell.visitCount + 1));
            }
            //top cell
            if (currCell.row - 1 >= 0 && grid[currCell.row - 1][currCell.column] == 0) {
                grid[currCell.row - 1][currCell.column] = 1;
                queue.offer(new Cell(currCell.row - 1, currCell.column, currCell.visitCount + 1));
            }
            //bottom cell
            if (currCell.row + 1 <= rows && grid[currCell.row + 1][currCell.column] == 0) {
                grid[currCell.row + 1][currCell.column] = 1;
                queue.offer(new Cell(currCell.row + 1, currCell.column, currCell.visitCount + 1));
            }
            //top right corner cell
            if (currCell.row - 1 >= 0 && currCell.column + 1 <= cols && grid[currCell.row - 1][currCell.column + 1] == 0) {
                grid[currCell.row - 1][currCell.column + 1] = 1;
                queue.offer(new Cell(currCell.row - 1, currCell.column + 1, currCell.visitCount + 1));
            }
            //bottom right corner cell
            if (currCell.row + 1 <= rows && currCell.column + 1 <= cols && grid[currCell.row + 1][currCell.column + 1] == 0) {
                grid[currCell.row + 1][currCell.column + 1] = 1;
                queue.offer(new Cell(currCell.row + 1, currCell.column + 1, currCell.visitCount + 1));
            }

            //top left corner cell
            if (currCell.row - 1 >= 0 && currCell.column - 1 >= 0 && grid[currCell.row - 1][currCell.column - 1] == 0) {
                grid[currCell.row - 1][currCell.column - 1] = 1;
                queue.offer(new Cell(currCell.row - 1, currCell.column - 1, currCell.visitCount + 1));
            }
            //bottom left corner cell
            if (currCell.row + 1 <= rows && currCell.column - 1 >= 0 && grid[currCell.row + 1][currCell.column - 1] == 0) {
                grid[currCell.row + 1][currCell.column - 1] = 1;
                queue.offer(new Cell(currCell.row + 1, currCell.column - 1, currCell.visitCount + 1));
            }
        }
        return result == Integer.MAX_VALUE ? -1 : result;
    }
}
