package ch8;

import javafx.scene.control.Cell;

import java.util.Stack;

/**
 * Robot in a Grid
 * Imagine a robot sitting on the upper left corner of grid with r rows and c columns.
 * The robot can only move in two directions, right and down, but certain cells are "off limits" such that
 * the robot cannot step on them. Design an algorithm to find a path for the robot from the top left to
 * the bottom right.
 */

class Coord {
    int r;
    int c;

    public Coord(int r, int c) {
        this.r = r;
        this.c = c;
    }

    public String toString() {
        return "(" + r + " , " + c + ")";
    }
}

public class qns2 {

    private enum CELL_TYPE {
        NORMAL,
        OBSTACLE,
        GOAL
    }

    public static boolean traverseGrid(CELL_TYPE[][] grid, int r, int c, Stack<Coord> path, Boolean[][] memo) {
        if (r >= grid.length) {
            return false;
        }
        if (c >= grid[0].length) {
            return false;
        }

        if (grid[r][c] == CELL_TYPE.OBSTACLE) {
            return false;
        }

        if (grid[r][c] == CELL_TYPE.GOAL) {
            path.push(new Coord(r, c));
            return true;
        }

        if (memo[r + 1][c] != null) {
            return memo[r+1][c];
        } else {
            memo[r + 1][c] = traverseGrid(grid, r + 1, c, path, memo);
            if (memo[r + 1][c]) {
                path.push(new Coord(r, c));
                return true;
            }
        }

        if (memo[r][c+1] != null) {
            return memo[r][c+1];
        } else {
            memo[r][c + 1] = traverseGrid(grid, r, c + 1, path, memo);
            if (memo[r][c + 1]) {
                path.push(new Coord(r, c));
                return true;
            }
        }

        return false;
    }

    public static void run() {
        CELL_TYPE[][] grid1 = {{CELL_TYPE.NORMAL, CELL_TYPE.NORMAL, CELL_TYPE.NORMAL},
                     {CELL_TYPE.NORMAL, CELL_TYPE.OBSTACLE, CELL_TYPE.NORMAL},
                     {CELL_TYPE.NORMAL, CELL_TYPE.NORMAL, CELL_TYPE.NORMAL},
                     {CELL_TYPE.OBSTACLE, CELL_TYPE.NORMAL, CELL_TYPE.GOAL}};

        Boolean[][] memo = new Boolean[grid1.length + 1][grid1[0].length + 1];
        Stack<Coord> path = new Stack<>();
        boolean hasPath = traverseGrid(grid1, 0, 0, path, memo);
        outputSoln(hasPath, path);

        CELL_TYPE[][] grid2 = {{CELL_TYPE.NORMAL, CELL_TYPE.NORMAL, CELL_TYPE.OBSTACLE},
               {CELL_TYPE.NORMAL, CELL_TYPE.OBSTACLE, CELL_TYPE.NORMAL},
               {CELL_TYPE.NORMAL, CELL_TYPE.OBSTACLE, CELL_TYPE.NORMAL},
               {CELL_TYPE.OBSTACLE, CELL_TYPE.NORMAL, CELL_TYPE.GOAL}};
        memo = new Boolean[grid2.length + 1][grid2[0].length + 1];
        path = new Stack<>();
        hasPath = traverseGrid(grid2, 0, 0, path, memo);
        outputSoln(hasPath, path);
    }

    private static void outputSoln(boolean hasPath, Stack<Coord> path) {
        if (hasPath) {
            System.out.print("The path is: ");
            while (!path.empty()) {
                System.out.print(path.pop() + " ");
            }
            System.out.println();
        } else {
            System.out.println("There is no path");
        }
    }
}
