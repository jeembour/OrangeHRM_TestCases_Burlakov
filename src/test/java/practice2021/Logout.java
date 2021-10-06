package practice2021;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Logout extends TestBase {
    @Test
    public void logout(){
        String pathToVerifyLoggedIn = "//a[@id=\"welcome\"]";
        String pathToLogout = "//a[text()=\"Logout\"]";
        String pathToLoginBtn = "btnLogin";
        driver.findElement(By.xpath(pathToVerifyLoggedIn)).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath(pathToLogout)).click();
        WebElement element = driver.findElement(By.id(pathToLoginBtn));
        boolean isDisplayed = element.isDisplayed();
        Assert.assertEquals(isDisplayed, true);
    }

}
