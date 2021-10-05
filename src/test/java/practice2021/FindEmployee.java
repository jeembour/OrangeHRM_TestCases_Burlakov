package practice2021;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class FindEmployee extends EmployeeListPageManager {
    @Test (groups = {"checkintest", "funktest"})
    public static void findEmployee() {
        goToEmployeePage();
        waitForEmployeePageJSExecution();
        try {
            String elementPathById = "empsearch_id";       //path to employee name input field
            sendKeysToField(empId, elementPathById);
            driver.findElement(By.id("searchBtn")).click();
            System.out.println(empFirstName + " " + empLastName + " is found on the Employee page");
        } catch (Exception e) {
            System.out.println(GREEN_TEXT_COLOR + "Failed to locate elements on the Employee page");
            throw (e);
        }
    }
}
