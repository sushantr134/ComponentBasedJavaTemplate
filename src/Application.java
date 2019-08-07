public class Application {
    private Object sortPort;

    public Application() {
        build();
    }

    public static void main(String... args) {
        Application application = new Application();
        System.out.println("version : " + application.getVersion());

        application.sort();
    }

    public void build() {
		sortPort=SortFactory.build();
        // please insert code here
    }

    public String getVersion() {
        String result = "";

        try {
			Method getVersionMethod = sortPort.getClass().getMethod("getVersion");
            result = (String) getVersionMethod.invoke(sortPort);
            // please insert code here
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return result;
    }

    public void sort() {
        try {
			int[] valueList = DataManagement.load();
			Method sortMethod = sortPort.getClass().getMethod("sort",int[].class,int.class);
			sortMethod.invoke(sortPort, valueList, valueList.length);
			DataManagement.save("bubble_sort_data.csv", DataManagement.convert(valueList));
            // please insert code here
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}