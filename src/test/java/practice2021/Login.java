package practice2021;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class Login extends TestBase {

    @Test (groups = {"checkintest"})
    public void logIn() {
        try {
            openPage(MAIN_PAGE, MAIN_PAGE_TEXT, X_PATH_OF_MAIN_PAGE);
            String usernameLocator = "txtUsername";
            String pwdLocator = "txtPassword";
            String xPathOfPage = "//*[@id=\"welcome\"]";
            sendKeysToField(loginId, usernameLocator);
            sendKeysToField(loginPWD, pwdLocator);
            driver.findElement(By.id("btnLogin")).click();
            driver.findElement(By.xpath(xPathOfPage));
        } catch (Exception e) {
            System.out.println(GREEN_TEXT_COLOR + "Logging in failed.");
            throw (e);
        }
    }
}
