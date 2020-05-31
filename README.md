## Test automation framework tools:
- Selenium WebDriver
- Maven
- RestAssured
- Cucumber


### Use this flow for get accessToken to your gitHub
- https://help.github.com/en/github/authenticating-to-github/creating-a-personal-access-token-for-the-command-line

#### For start the tests execution use command:

```
   mvn clean test -Dgithub.username=<your git hub user name> -Dgithub.password=<your git hub password> -Dgithub.userToken=<generated token on the previous tutorial> 

```