package ch1;

public class qns7 {

    private static int replaceCell(int [][] mtx, int res, int x ,int y) {
        System.out.println("X: " + x + " Y: " + y);
        int temp = mtx[y][x];
        mtx[y][x] = res;
        return temp;
    }

    private static int[][] rotate90(int [][] mtx) {
        int n = mtx.length;
        int res = 0;
        for (int ring = 0; ring < n / 2; ring ++) {
            for (int itr = 0; itr < n - 2 * ring - 1; itr++) {
                res = mtx[ring][ring+itr];
                res = replaceCell(mtx, res, n - ring-1, itr + ring);
                res= replaceCell(mtx, res, n-(itr+ring)-1, n-ring-1);
                res = replaceCell(mtx, res, ring, n-(itr+ring)-1);
                res = replaceCell(mtx, res, itr + ring, ring);
                //System.out.println(res);
//                replaceCell();
            }
        }
        return mtx;
    }



    public static void run() {
        System.out.println("=== Running ch1.qns7 ===");

        int mtx[][] = {{1,2,3,4}, {5,6,7,8}, {9,10,11,12}, {13,14,15,16}};
        mtx = rotate90(mtx);
        printMtx(mtx);

        int mtx1[][] = {{1,2,3}, {4,5,6}, {7,8,9} };
        mtx1 = rotate90(mtx1);
        printMtx(mtx1);

        int mtx2[][] = {{1,2,3,4,5,6}, {7,8,9,10,11,12}, {13,14,15,16,17,18}, {19,20,21,22,23,24}, {25,26,27,28,29,30}, {31,32,33,34,35,36}};
        mtx2 = rotate90(mtx2);
        printMtx(mtx2);

        System.out.println("====================");
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
