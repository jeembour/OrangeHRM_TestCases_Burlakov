package practice2021;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class AddEmployee extends EmployeeListPageManager {

    @Test(groups = {"checkintest", "funktest"})
    public void addNewEmployee() {
        goToEmployeePage();
        waitForEmployeePageJSExecution();
        driver.findElement(By.id("btnAdd")).click();
        sendKeysToField(empFirstName, "firstName");
        sendKeysToField(empLastName, "lastName");
        sendKeysToField(empId, "employeeId");
        driver.findElement(By.id("btnSave")).click();
    }
}
