package practice2021;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FindEmp extends EmpListPageManager {
    @Test(groups = {"checkintest", "functest"})
    public static void findEmployee() {
        goToEmployeePage();
        waitForEmployeePageJSExecution();
        String elementPathById = "empsearch_id";       //path to employee name input field
        sendKeysToField(empId, elementPathById);
        driver.findElement(By.id("searchBtn")).click();
        WebElement element = driver.findElement(By.xpath("//a[text()=\"" + empId + "\"]"));
        boolean isDisplayed = element.isDisplayed();
        if (isDisplayed == true) {
            System.out.println("Employee " + empId + " " + empFirstName + " " + empLastName + " is found.");
        } else {
            System.out.println("Employee " + empId + " " + empFirstName + " " + empLastName + " is not found.");
        }
    }
}
