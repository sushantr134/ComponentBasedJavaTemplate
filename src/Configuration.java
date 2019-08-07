public enum Configuration {
    instance;

    public String userDirectory = System.getProperty("user.dir");
    public String fileSeparator = System.getProperty("file.separator");

    public String className = "Sort";

    public String getDataPath() {
        return userDirectory + fileSeparator + "data" + fileSeparator;
    }

    public String getJavaArchiveFilePath() {
        return userDirectory + fileSeparator + "component" + fileSeparator + "jar" + fileSeparator + "sort.jar";
    }
}