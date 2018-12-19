package ch1;

import java.util.HashSet;

/**
 * Zero Matrix:
 * Write an algorithm such that if an element in an MxN matrix is 0, its entire row and column are set to 0.
 *
 * Time: O(N^2)
 * Space: O(N)
 */

public class qns8 {
    public static void run() {
        int[][] mtx = {{5,7,4,3}, {2,1,0,1}, {4,8,5,9},{9,0,5,4}};
        int m = mtx.length;
        int n = mtx[0].length;
        int[][] finalMtx = step1(mtx, m, n);
        printMtx(finalMtx);

        System.out.println("===================");
        int[][] mtx1 = {{5,7,0}, {2,8,1}};
        m = mtx1.length;
        n = mtx1[0].length;
        int[][] finalMtx1 = step1(mtx1, m, n);
        printMtx(finalMtx1);
    }

    private static int[][] step1(int[][] mtx, int m, int n){
        HashSet<Integer> myX = new HashSet<>();
        HashSet<Integer> myY = new HashSet<>();

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(mtx[i][j]==0){
                    myX.add(i);
                    myY.add(j);
                }
            }
        }
        for(int a=0; a<m; a++){
            for(int b=0; b<n; b++){
                if(myX.contains(a)){
                    mtx[a][b] = 0;
                }
                else if(myY.contains(b)){
                    mtx[a][b] = 0;
                }
            }
        }
        return mtx;
    }

    private static void printMtx(int[][] mtx) {
        for (int[] y : mtx) {
            for (int x : y) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
    }

}
