import java.util.*;

public class BubbleSort {
    public static SortResult sort(int[] data) {
        int arr = Arrays.copyOf(data, data.length);
        int steps = 0;
        long start = System.nanoTime();

        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                steps++;
                if (arr[j]) > arr[j + 1] {
                    int temp = arr[j];
                    arr[j] = arr [j + 1];
                    arr[j + 1] = temp;
                }
            }
        }

        long end = System.nanoTime();
        double duration = (end -start) / 1e6;
        return new SortResult(arr, duration, steps);
    }
}