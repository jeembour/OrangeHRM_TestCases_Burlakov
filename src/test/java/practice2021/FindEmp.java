package practice2021;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import practice2021.app_manager.ApplicationManager;
import practice2021.app_manager.EmpListPageManager;

public class FindEmp extends EmpListPageManager {
    @Test(groups = {"checkintest", "functest"})
    public static void findEmployee() {
        goToEmployeePage();
        waitForEmployeePageJSExecution();
        String elementPathById = "empsearch_id";       //path to employee name input field
        ApplicationManager.sendKeysToField(ApplicationManager.empId, elementPathById);
        ApplicationManager.driver.findElement(By.id("searchBtn")).click();
        WebElement element = ApplicationManager.driver.findElement(By.xpath("//a[text()=\"" + ApplicationManager.empId + "\"]"));
        boolean isDisplayed = element.isDisplayed();
        if (isDisplayed == true) {
            System.out.println("Employee " + ApplicationManager.empId + " " + ApplicationManager.empFirstName + " " + ApplicationManager.empLastName + " is found.");
        } else {
            System.out.println("Employee " + ApplicationManager.empId + " " + ApplicationManager.empFirstName + " " + ApplicationManager.empLastName + " is not found.");
        }
    }
}
