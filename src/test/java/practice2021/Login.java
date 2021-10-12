package practice2021;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import practice2021.app_manager.ApplicationManager;

public class Login extends TestBase {

    @Test(groups = {"checkintest"})
    public void logIn() {
        String usernameLocator = "txtUsername";
        String pwdLocator = "txtPassword";
        String xPathToVerifyLoggedin = "//*[@id=\"welcome\"]";
        String pathToLoginBtn = "btnLogin";
        app.openPage(ApplicationManager.MAIN_PAGE, ApplicationManager.MAIN_PAGE_TEXT, ApplicationManager.X_PATH_OF_MAIN_PAGE);
        ApplicationManager.sendKeysToField(ApplicationManager.loginId, usernameLocator);
        ApplicationManager.sendKeysToField(ApplicationManager.loginPWD, pwdLocator);
        ApplicationManager.driver.findElement(By.id(pathToLoginBtn)).click();
        app.verification(xPathToVerifyLoggedin);
    }
}
