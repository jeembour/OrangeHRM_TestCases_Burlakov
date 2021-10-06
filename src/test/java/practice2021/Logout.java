package practice2021;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Logout extends TestBase {
    @Test
    public void logout(){
        driver.findElement(By.xpath("//a[@id=\"welcome\"]")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.findElement(By.xpath("//a[text()=\"Logout\"]")).click();
        WebElement element = driver.findElement(By.id("btnLogin"));
        boolean isDisplayed = element.isDisplayed();
        Assert.assertEquals(isDisplayed, true);
    }

}
