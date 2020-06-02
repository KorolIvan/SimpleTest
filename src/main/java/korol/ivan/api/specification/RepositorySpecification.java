package korol.ivan.api.specification;

import com.jayway.restassured.specification.RequestSpecification;
import korol.ivan.api.BaseApiConfig;
import korol.ivan.util.ApiData;
import korol.ivan.util.DataSaver;

public class RepositorySpecification extends BaseApiConfig {

    @Override
    public String basePath() {
        return ApiData.REPOS_BASE_PATH;
    }

    public RequestSpecification creatNewRepo() {
        return getBaseUrl()
                .setBasePath(basePath())
                .build()
                .authentication()
                .oauth2(
                        DataSaver.getSavedDataOrReturnSelf("gitHubUserToken")
                );
    }

    public RequestSpecification deleteRepository(String repoName) {
        return getBaseUrl()
                .setBasePath(ApiData.DELET_REPO_PATH)
                .build()
                .pathParam("user", DataSaver.getSavedDataOrReturnSelf("gitHubUsername"))
                .pathParam("repoName", repoName)
                .authentication()
                .oauth2(
                        DataSaver.getSavedDataOrReturnSelf("gitHubUserToken")
                );
    }

}
