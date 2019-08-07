import java.lang.reflect.Method;

public class Application {
    private Object primeNumberSearchPort;

    public Application() {
        build();
    }

    public static void main(String... args) {
        Application application = new Application();
        System.out.println("version : " + application.getVersion());
        System.out.println("count   : " + application.count(1, 10000000));
    }

    public void build() {
        primeNumberSearchPort = PrimeNumberSearchFactory.build();
    }

    public String getVersion() {
        String result = "";

        try {
            Method getVersionMethod = primeNumberSearchPort.getClass().getMethod("getVersion");
            result = (String) getVersionMethod.invoke(primeNumberSearchPort);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return result;
    }

    public int count(int minimum, int maximum) {
        int result = -1;

        try {
            Method countMethod = primeNumberSearchPort.getClass().getMethod("count", int.class, int.class);
            result = (int) countMethod.invoke(primeNumberSearchPort, minimum, maximum);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return result;
    }
}