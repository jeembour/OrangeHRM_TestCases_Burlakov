package practice2021;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class AddEmployee extends EmployeeListPage {

    @Test
    public void addNewEmployee() {
        goToEmployeePage();
        waitForEmployeePageJSExecution();
        try {
            driver.findElement(By.id("btnAdd")).click();
            sendKeysToField(empFirstName, "firstName");
            sendKeysToField(empLastName, "lastName");
            sendKeysToField(empId, "employeeId");
            driver.findElement(By.id("btnSave")).click();
            System.out.println("Employee " + empFirstName + " " + empLastName + " added to the Employee list.");
        } catch (Exception e) {
            System.out.println(GREEN_TEXT_COLOR + "Failed to add a new employee to the Employee list.");
            throw (e);
        }
    }
}
