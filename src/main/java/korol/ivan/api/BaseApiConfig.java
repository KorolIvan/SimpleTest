package korol.ivan.api;

import com.jayway.restassured.builder.RequestSpecBuilder;
import com.jayway.restassured.http.ContentType;
import com.jayway.restassured.internal.RequestSpecificationImpl;
import com.jayway.restassured.specification.AuthenticationSpecification;
import com.jayway.restassured.specification.RequestSpecification;
import korol.ivan.util.ApiData;
import korol.ivan.util.DataSaver;

public abstract class BaseApiConfig {

    public abstract String basePath();

    public static RequestSpecBuilder getBaseUrl() {
        return new RequestSpecBuilder()
                .setBaseUri(ApiData.BASE_URL)
                .setContentType(ContentType.JSON);
    }

}
