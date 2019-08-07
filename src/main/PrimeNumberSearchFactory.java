import java.io.File;
import java.net.URL;
import java.net.URLClassLoader;

public class PrimeNumberSearchFactory {
    public static Object build() {
        Object componentPort = null;

        try {
            URL[] urlList = {new File(Configuration.instance.getJavaArchiveFilePath()).toURI().toURL()};
            URLClassLoader urlLoader = new URLClassLoader(urlList, PrimeNumberSearchFactory.class.getClassLoader());
            Class componentClass = Class.forName(Configuration.instance.className, true, urlLoader);
            Object componentInstance = componentClass.getMethod("getInstance").invoke(null);
            componentPort = componentClass.getDeclaredField("port").get(componentInstance);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return componentPort;
    }
}