public enum Configuration {
    instance;

    public String userDirectory = System.getProperty("user.dir");
    public String fileSeparator = System.getProperty("file.separator");

    public String className = "PrimeNumberSearch";

    public String getJavaArchiveFilePath() {
        return userDirectory + fileSeparator + "component" + fileSeparator + "jar" + fileSeparator + "prime_number_search.jar";
    }
}