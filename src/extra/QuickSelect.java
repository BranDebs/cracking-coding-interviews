package extra;

public class QuickSelect {

    public int select(int[] arr, int k) {
        return quickSelect(arr, 0, arr.length - 1, k);
    }

    public int selectIteratively(int[] arr, int k) {
        return selectIteratively(arr, 0, arr.length - 1, k);
    }

    private int selectIteratively(int[] arr, int start, int end, int k) {
        while (true) {
            if (start > end) {
                return Integer.MAX_VALUE;
            }

            int pivotIdx = partition(arr, start, end);
            int sizeLeft = pivotIdx - start + 1;
            if (sizeLeft == k) {
                return arr[pivotIdx];
            } else if (sizeLeft < k) {
                start = pivotIdx + 1;
                k = k - sizeLeft;
            } else {
                end = pivotIdx - 1;
            }
        }
    }

    private int quickSelect(int[] arr, int start, int end, int k) {
        if (start > end) {
            return Integer.MAX_VALUE;
        }
        int pivotIdx = partition(arr, start, end);
        int sizeLeft = pivotIdx - start + 1;
        if (sizeLeft == k) {
            return arr[pivotIdx];
        } else if (sizeLeft > k) {
            return quickSelect(arr, start, pivotIdx - 1, k);
        } else {
            return quickSelect(arr, pivotIdx + 1, end, k - sizeLeft);
        }
    }

    private int partition(int[] arr, int start, int end) {
        int p = arr[end];
        int m = start;
        for (int i = start ; i < end; i++) {
            if (arr[i] < p) {
                swap(arr, i, m);
                m++;
            }
        }
        swap(arr, m, end);
        return m;
    }

    private void swap(int[] arr, int k, int m) {
        int temp = arr[k];
        arr[k] = arr[m];
        arr[m] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {4, 7, 1, 3, 8, 9, 5};
        int k = 2;
        QuickSelect qSelect = new QuickSelect();
        System.out.println(qSelect.select(arr, k));
        System.out.println(qSelect.selectIteratively(arr, k));

        int[] arr1 = {7, 10 ,4, 3, 20, 15};
        k = 3;
        System.out.println(qSelect.select(arr1, k));
        System.out.println(qSelect.selectIteratively(arr1, k));

        int[] arr2 = {7, 10, 4 ,3, 20 ,15};
        k = 4;
        System.out.println(qSelect.select(arr2, k));
        System.out.println(qSelect.selectIteratively(arr2, k));
    }
}
