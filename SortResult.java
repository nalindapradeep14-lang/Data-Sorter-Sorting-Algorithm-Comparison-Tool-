
public class SortResult {
    private final int[] sortedData;
    public SortResult(int[] arr, double duration, int steps) {
        this.sortedData = arr;
    }

    public SortResult(int[] sortedData) {
        this.sortedData = sortedData;
    }
    
    public int[] getSortedData() {
        return sortedData;
    }
    public Object getTimeTaken() {
        throw new UnsupportedOperationException("Unimplemented method 'getTimeTaken'");
    }
    public Object getSteps() {
        throw new UnsupportedOperationException("Unimplemented method 'getSteps'");
    }
}

