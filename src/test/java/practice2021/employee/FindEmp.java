package practice2021.employee;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import practice2021.app_manager.EmpListPageManager;

public class FindEmp extends EmpListPageManager {
    @Test(groups = {"checkintest", "functest"})
    public static void findEmployee() {
        goToEmployeePage();
        waitForEmployeePageJSExecution();
        String elementPathById = "empsearch_id";       //path to employee name input field
        app.sendKeysToField(app.empId, elementPathById);
        app.driver.findElement(By.id("searchBtn")).click();
        WebElement element = app.driver.findElement(By.xpath("//a[text()=\"" + app.empId + "\"]"));
        boolean isDisplayed = element.isDisplayed();
        if (isDisplayed == true) {
            System.out.println("Employee " + app.empId + " " + app.empFirstName + " " + app.empLastName + " is found.");
        } else {
            System.out.println("Employee " + app.empId + " " + app.empFirstName + " " + app.empLastName + " is not found.");
        }
    }
}
