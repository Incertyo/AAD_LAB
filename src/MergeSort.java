import java.util.Arrays;

public class MergeSort {
    static void mergeSort(int[] arr, int l, int r) {
        if (l >= r) return;
        int mid = l + (r - l) / 2;

        mergeSort(arr, l, mid);
        mergeSort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    static void merge(int[] arr, int l, int mid, int r) {
        int n1 = mid - l + 1, n2 = r - mid;
        int[] left = new int[n1], right = new int[n2];

        for (int i = 0; i < n1; i++) left[i] = arr[l + i];
        for (int i = 0; i < n2; i++) right[i] = arr[mid + 1 + i];

        int i = 0, j = 0, k = l;
        while (i < n1 && j < n2) arr[k++] = (left[i] < right[j]) ? left[i++] : right[j++];
        while (i < n1) arr[k++] = left[i++];
        while (j < n2) arr[k++] = right[j++];
    }

    public static void main(String[] args) {
        int[] arr = {5, 3, 8, 4, 2};
        mergeSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}