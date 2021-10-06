package practice2021;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Login extends TestBase {

    @Test(groups = {"checkintest"})
    public void logIn() {
        String usernameLocator = "txtUsername";
        String pwdLocator = "txtPassword";
        String xPathToVerifyLoggedin = "//*[@id=\"welcome\"]";
        String pathToLoginBtn = "btnLogin";
        openPage(MAIN_PAGE, MAIN_PAGE_TEXT, X_PATH_OF_MAIN_PAGE);
        sendKeysToField(loginId, usernameLocator);
        sendKeysToField(loginPWD, pwdLocator);
        driver.findElement(By.id(pathToLoginBtn)).click();
        verification (xPathToVerifyLoggedin);
    }
}
