package extra;

public class QuickSelect {

    public int select(int[] arr, int k) {
        return quickSelect(arr, 0, arr.length - 1, k - 1);
    }

    private int quickSelect(int[] arr, int start, int end, int k) {
        if (start > end) {
            return Integer.MAX_VALUE;
        }
        int pivotIdx = partition(arr, start, end);

        if (pivotIdx - start < k) {
            return quickSelect(arr, pivotIdx + 1, end, k - pivotIdx - 1);
        } else if (pivotIdx - start> k) {
            return quickSelect(arr, start, pivotIdx - 1, k);
        } else {
            return arr[pivotIdx];
        }
    }

    private int partition(int[] arr, int start, int end) {
        int p = arr[start];
        int m = start;

        for (int k = start + 1; k <= end; k++) {
            if (arr[k] < p) {
                ++m;
                swap(arr, k, m);
            }
        }
        swap(arr, start, m);
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

        int[] arr1 = {7, 10 ,4, 3, 20, 15};
        k = 3;
        System.out.println(qSelect.select(arr1, k));

        int[] arr2 = {7, 10, 4 ,3, 20 ,15};
        k = 4;
        System.out.println(qSelect.select(arr2, k));
    }
}
