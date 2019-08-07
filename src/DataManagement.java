import java.io.*;

public class DataManagement {
    public static int[] load() {
        final int maximumNumberOfValues = 100000;
        String[] stringList = new String[maximumNumberOfValues];
        int[] result = new int[maximumNumberOfValues];

        try {
            String line;
            BufferedReader bufferedReader = new BufferedReader(new FileReader(new File(Configuration.instance.getDataPath() + "unsorted_data.csv")));
            while ((line = bufferedReader.readLine()) != null)
                stringList = line.split(",");

            for (int i = 0; i < maximumNumberOfValues; i++)
                result[i] = Integer.parseInt(stringList[i]);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return result;
    }

    public static String convert(int[] valueList) {
        StringBuilder stringBuilder = new StringBuilder();

        for (int i = 0; i < valueList.length; i++)
            stringBuilder.append(valueList[i]).append(",");

        return stringBuilder.toString();
    }

    public static void save(String filename, String data) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(Configuration.instance.getDataPath() + filename)));
            bufferedWriter.write(data.substring(0, data.length() - 1));
            bufferedWriter.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}