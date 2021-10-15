package practice2021;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class Login extends TestBase {

    @Test(groups = {"checkintest"})
    public void logIn() {
        String usernameLocator = "txtUsername";
        String pwdLocator = "txtPassword";
        String xPathToVerifyLoggedin = "//*[@id=\"welcome\"]";
        String pathToLoginBtn = "btnLogin";
        app.openPage(app.MAIN_PAGE, app.MAIN_PAGE_TEXT, app.X_PATH_OF_MAIN_PAGE);
        app.sendKeysToField(app.loginId, usernameLocator);
        app.sendKeysToField(app.loginPWD, pwdLocator);
        app.driver.findElement(By.id(pathToLoginBtn)).click();
        app.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        app.verification(xPathToVerifyLoggedin);
    }
}
