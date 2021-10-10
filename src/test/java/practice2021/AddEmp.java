package practice2021;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class AddEmp extends EmpListPageManager {

    @Test(groups = {"checkintest", "funсtest"})
    public void addNewEmployee() {
        goToEmployeePage();
        waitForEmployeePageJSExecution();
        driver.findElement(By.id("btnAdd")).click();
        sendKeysToField(empFirstName, "firstName");
        sendKeysToField(empLastName, "lastName");
        sendKeysToField(empId, "employeeId");
        driver.findElement(By.id("btnSave")).click();
        try {
            FindEmp.findEmployee();
            System.out.println("And is successfully added.");
        } catch (Exception e) {
            System.out.println("Cannot add employee id="+empId + " " + empFirstName + " " + empLastName);
            throw (e);
        }
    }
}
