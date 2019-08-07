public class Sort {
    // static instance
    private static Sort instance = new Sort();

    // port
    public Port port;

    // private constructor
    private Sort() {
        port = new Port();
    }

    // static method getInstance
    public static Sort getInstance() {
        return instance;
    }

    // inner methods
    private String innerGetVersion() {
        return "merge sort";
    }

    private int[] innerSort(int[] valueList, int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++)
                if (valueList[j] > valueList[j + 1]) {
                    int temp = valueList[j];
                    valueList[j] = valueList[j + 1];
                    valueList[j + 1] = temp;
                }
        }

        return valueList;
    }

    // inner class port
    public class Port implements ISort {
        public String getVersion() {
            return innerGetVersion();
        }

        public int[] sort(int[] valueList, int n) {
            return innerSort(valueList, n);
        }
    }
}