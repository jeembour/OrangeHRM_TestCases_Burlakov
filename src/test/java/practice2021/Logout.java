package practice2021;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import java.util.concurrent.TimeUnit;

public class Logout extends TestBase {
    @Test
    public void logout(){
        String pathToVerifyLoggedIn = "//a[@id=\"welcome\"]";
        String pathToLogout = "//a[text()=\"Logout\"]";
        String xPathToLoginBtn = "//input[@id=\"btnLogin\"]";
        app.driver.findElement(By.xpath(pathToVerifyLoggedIn)).click();
        app.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        app.driver.findElement(By.xpath(pathToLogout)).click();
        app.verification(xPathToLoginBtn);
    }

}
