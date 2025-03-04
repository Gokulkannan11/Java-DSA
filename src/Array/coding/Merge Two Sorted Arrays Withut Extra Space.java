import java.util.*;


public static void mergeWithoutExtraSpace(int[] a, int[] b) {
        int n = a.length, m = b.length;
        
        int gap = nextGap(n + m);
        
        while (gap > 0) {
            // Compare elements in the first array
            for (int i = 0; i + gap < n; i++) {
                if (a[i] > a[i + gap]) {
                    swap(a, i, i + gap);
                }
            }

            // Compare elements between the two arrays
            for (int i = Math.max(n - gap, 0), j = i + gap - n; j < m; i++, j++) {
                if (a[i] > b[j]) {
                    swap(a, b, i, j);
                }
            }

            // Compare elements in the second array
            for (int j = 0; j + gap < m; j++) {
                if (b[j] > b[j + gap]) {
                    swap(b, j, j + gap);
                }
            }

            gap = nextGap(gap);
        }
    }

    private static int nextGap(int gap) {
        if (gap <= 1) return 0;
        return (gap + 1) / 2;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    private static void swap(int[] a, int[] b, int i, int j) {
        int temp = a[i];
        a[i] = b[j];
        b[j] = temp;
    }

    public static void main(String[] args) {
        int[] a = {2, 4, 7, 10};
        int[] b = {2, 3};
        mergeWithoutExtraSpace(a, b);
        
        System.out.println("Modified a: " + Arrays.toString(a));
        System.out.println("Modified b: " + Arrays.toString(b));
    }

