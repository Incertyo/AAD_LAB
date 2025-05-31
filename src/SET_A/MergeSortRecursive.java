package SET_A;

import java.util.Arrays;
import java.util.Scanner;

public class MergeSortRecursive {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr = {10, 2, 4, 56, 23, 1, 0, 24};

        System.out.println("Original array:");
        printArray(arr);

        mergeSort(arr);

        System.out.println("Sorted array:");
        printArray(arr);
    }

    public static void mergeSort(int[] arr) {
       if(arr.length <= 1){
           return;
       }
       int mid = arr.length/2;
       int[] left = Arrays.copyOfRange(arr, 0, mid);
       int[] right = Arrays.copyOfRange(arr, mid, arr.length);
       mergeSort(left);
       mergeSort(right);
       merge(arr, left, right);
    }

    private static void merge(int[] result, int[] left, int[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            }
            else {
                result[k++] = right[j++];
            }
        }
        while (i < left.length) {
            result[k++] = left[i++];
        }
        while (j < right.length) {
            result[k++] = right[j++];
        }

    }

    private static void printArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}