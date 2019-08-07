public class PrimeNumberSearch {
    // static instance
    private static PrimeNumberSearch instance = new PrimeNumberSearch();

    // port
    public Port port;

    // private constructor
    private PrimeNumberSearch() {
        port = new Port();
    }

    // static method getInstance
    public static PrimeNumberSearch getInstance() {
        return instance;
    }

    // inner methods
    public String innerGetVersion() {
        return "prime number search";
    }

    public int innerCount(int minimum, int maximum) {
        int numberOfPrimes = 0;
        for (int n = minimum; n <= maximum; n++)
            if (Utility.isPrime(n))
                numberOfPrimes++;
        return numberOfPrimes;
    }

    // inner class port
    public class Port implements IPrimeNumberSearch {
        public String getVersion() {
            return innerGetVersion();
        }

        public int count(int minimum, int maximum) {
            return innerCount(minimum, maximum);
        }
    }
}