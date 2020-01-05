package ch8;

import java.util.*;

public class Qns8_2 {
  static final char DOWN = 'D';
  static final char RIGHT = 'R';

  // M(row) * N(col) grid
  private static List<Character> robotGrid(boolean[][] grid) {
    int M = grid.length;
    if (M == 0) {
      return new ArrayList<>();
    }
    int N = grid[0].length;
    if (N == 0) {
      return new ArrayList<>();
    }

    Deque<Character> out = new LinkedList<>();
    if (traverse(grid, 0, 0, M, N, out)) {
      List<Character> res = new ArrayList<>();
      while (out.size() > 0) {
        res.add(out.pop());
      }
      return res;
    }
    return new ArrayList<>();
  }

  private static boolean traverse(boolean[][] grid, int i, int j, int M, int N, Deque<Character> out) {
    if (i >= M || j >= N || !grid[i][j]) {
      return false;
    }

    if (i == M - 1 && j == N - 1) {
      return true;
    }

    if (traverse(grid, i+1, j, M, N, out)) {
      out.push(DOWN);
      return true;
    }

    if (traverse(grid, i, j+1, M, N, out)) {
      out.push(RIGHT);
      return true;
    }

    return false;
  }

  public static void tests() {
    /*
    1 1
    1 1

    [D R]
    */
    boolean[][] grid1 = {{true, true}, {true, true}};
    printHelper(robotGrid(grid1));

    /*
    1 1
    0 1

    [R D]
    */
    boolean[][] grid2 = {{true, true},{false, true}};
    printHelper(robotGrid(grid2));

    /*
    1 0
    0 1

    []
    */
    boolean[][] grid3 = {{true, false},{false, true}};
    printHelper(robotGrid(grid3));



    /*
    1 1 1 1
    0 0 1 0
    0 1 1 0
    0 1 1 0
    0 1 1 1

    [R, R, D, D, D, D, R]
   */
    boolean[][] grid4 = {
        {true, true, true, true},
        {false, false, true, false},
        {false, true, true, false},
        {false, true, true, false},
        {false, true, true, true}
    };
    printHelper(robotGrid(grid4));

    /*
    1 1 1 1 1
     */
    boolean[][] grid5 = {
        {true, true, true, true, true}
    };
    printHelper(robotGrid(grid5));

    /*
    1
    1
    1
    1
    1
     */
    boolean[][] grid6 = {
        {true},
        {true},
        {true},
        {true},
        {true}
    };
    printHelper(robotGrid(grid6));
  }

  private static void printHelper(List<Character> res) {
    StringJoiner sj = new StringJoiner(",", "[", "]");
    for (char c : res) {
      sj.add(Character.toString(c));
    }
    System.out.println(sj.toString());
  }
}
