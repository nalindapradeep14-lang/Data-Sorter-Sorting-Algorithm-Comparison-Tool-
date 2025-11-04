import java.util.*;

public class DataSorterMain {
    private static final Map<String, SortResult> results = new LinkedHashMap<>();
    private static final Scanner sc = new Scanner(System.in);
    private static int[] data = new int[0];

    public static void main(String[] args) {
        while (true) {
           System.out.println("\n--- Data Sorter: Sorting Algorithm Comparison Tool ---"); 
           System.out.println("1. Enter numbers manually"); 
           System.out.println("2. Generate random numbers"); 
           System.out.println("3. Perform Bubble Sort"); 
           System.out.println("4. Perform Merge Sort"); 
           System.out.println("5. Perform Quick Sort"); 
           System.out.println("6. Compare all algorithms (show performance table)"); 
           System.out.println("7. Exit"); 
           System.out.print("Enter your Choice:"); 
           int Choice = sc.nextInt();
           sc.nextLine();

               switch (Choice) {
                    case 1 -> enterNumbers();
                    case 2 -> generateNumbers();
                    case 3 -> runAlgorithm("Bubble Sort");
                    case 4 -> runAlgorithm("Merge Sort");
                    case 5 -> runAlgorithm("Quick Sort");
                    case 6 -> showComparison();
                    case 7 ->{
                        System.out.println("Exiting program...");
                        return;
                    }
                }
            }
        }
    
        private static void enterNumbers() {
            System.out.print("Enter numbers separated by spaces: ");
            String[] parts = sc.nextLine().split(" ");
            data = new int[parts.length];
            for (int i = 0; i < parts.length; i++) {
                data[i] = Integer.parseInt(parts[i]);
            }
        }

    private static void generateNumbers() {
        System.out.print("Enter number of elements: ");
        int size = sc.nextInt();
        sc.nextLine();
        Random rand = new Random();
        data = new int[size];
        for (int i = 0; i < size; i++) {
            data[i] = rand.nextInt(1000) + 1;
        }
        System.out.println("Generated Data: " + Arrays.toString(data));
    }

    private static void runAlgorithm(String algo) {
        if (data.length == 0) {
            System.out.println("No data found! Please enter or generate numbers first.");
            return;
        }
        SortResult result;
        switch (algo) {
            case "Bubble Sort" -> result = BubbleSort.sort(data);
            case "Merge Sort" -> result = MergeSort.sort(data);
            case "Quick Sort" -> result = QuickSort.sort(data);
            default -> { return; }
        }
        results.put(algo, result);
        System.out.println("Sorted Data: " + Arrays.toString(data));
        System.out.println("Result: " + result);
    }
    private static void showComparison() {
        System.out.println("\n--- Comparison Table ---");
        System.out.printf("%-15s %-15s %-10s\n", "Algorithm", "Time (ms)", "Steps");
        System.out.println("------------------------------------------");
        for (Map.Entry<String, SortResult> entry : results.entrySet()) {
            SortResult result = entry.getValue();
            System.out.printf("%-15s %-15d %-10d\n",
                    entry.getKey(), result.getTimeTaken(), result.getSteps());
        }
    }
}

