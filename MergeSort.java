// https://chatgpt.com/share/ef5f99ee-5d74-4623-a57a-a1e960b6c6e4 for code explanation

import java.util.Arrays;
import java.util.Scanner;

public class MergeSort {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the Array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the elements of the Array: ");
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sc.nextInt();
        }
        System.out.println("Array before Merge Sort: " + Arrays.toString(arr));
        mergersort(arr, 0, arr.length - 1);
        System.out.println("Array after Merge Sort: " + Arrays.toString(arr));
    }

    public static void mergersort(int[] arr, int l, int r) {
        if (l < r) {
            int mid = (l + r) / 2;
            mergersort(arr, l, mid);
            mergersort(arr, mid + 1, r);
            merge(arr, l, mid, r);
        }
    }

    public static void merge(int[] arr, int l, int mid, int r) {
        int n1 = mid - l + 1;
        int n2 = r - mid;

        int[] lArr = new int[n1];
        int[] rArr = new int[n2];

        for (int x = 0; x < n1; x++) {
            lArr[x] = arr[l + x];
        }
        for (int y = 0; y < n2; y++) {
            rArr[y] = arr[mid + 1 + y];
        }

        int i = 0, j = 0, k = l;

        while (i < n1 && j < n2) {
            if (lArr[i] <= rArr[j]) {
                arr[k] = lArr[i];
                i++;
            } else {
                arr[k] = rArr[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = lArr[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = rArr[j];
            j++;
            k++;
        }
    }
}
