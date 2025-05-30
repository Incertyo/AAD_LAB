public class CountInversions {
    static int mergeSort(int[] arr, int l, int r) {
        if (l >= r) return 0;
        int mid = l + (r - l) / 2;
        int count = mergeSort(arr, l, mid) + mergeSort(arr, mid + 1, r) + merge(arr, l, mid, r);
        return count;
    }

    static int merge(int[] arr, int l, int mid, int r) {
        int[] temp = new int[r - l + 1];
        int i = l, j = mid + 1, k = 0, count = 0;

        while (i <= mid && j <= r) {
            if (arr[i] <= arr[j]) temp[k++] = arr[i++];
            else {
                temp[k++] = arr[j++];
                count += (mid - i + 1); // Count inversions
            }
        }
        while (i <= mid) temp[k++] = arr[i++];
        while (j <= r) temp[k++] = arr[j++];

        System.arraycopy(temp, 0, arr, l, temp.length);
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {8, 4, 2, 1};
        System.out.println("Total Inversions: " + mergeSort(arr, 0, arr.length - 1));
    }
}