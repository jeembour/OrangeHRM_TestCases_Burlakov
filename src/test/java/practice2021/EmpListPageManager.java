package practice2021;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class EmpListPageManager extends TestBase {
    public static void goToEmployeePage() {
        try {
            driver.get(EMPLOYEE_LIST_PAGE);
            driver.findElement(By.id("searchBtn"));
        } catch (Exception e) {
            System.out.println(GREEN_TEXT_COLOR + "The Employee list page is not found.");
            throw (e);
        }
    }

    public static void waitForEmployeePageJSExecution() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, 1);
            WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@class=\"ac_input inputFormatHint\"]")));
        } catch (Exception e) {
        }
    }

    protected void actionSuccessful() {
        Assert.assertTrue(wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class=\"message success fadable\"]"))).isDisplayed());
    }
}