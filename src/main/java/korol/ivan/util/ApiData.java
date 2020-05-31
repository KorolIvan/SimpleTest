package korol.ivan.util;

public class ApiData {
    private ApiData() {
    }

    public static final String BASE_URL = "https://api.github.com";
    public static final String REPOS_BASE_PATH = "/user/repos";
    public static final String DELET_REPO_PATH = "/repos/{user}/{repoName}";
}
