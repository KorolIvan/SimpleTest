package korol.ivan.model;

import korol.ivan.util.DataSaver;

public class GitHubUser {
    private static final String USERNAME = System.getProperty("github.username");
    private static final String PASSWORD = System.getProperty("github.password");

    static {
        DataSaver.saveData("gitHubUsername", USERNAME);
        DataSaver.saveData("gitHubPassword", PASSWORD);
    }
}
