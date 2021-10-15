package practice2021.employee;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import practice2021.app_manager.EmpListPageManager;

public class AddEmp extends EmpListPageManager {

    @Test(groups = {"checkintest", "funсtest"})
    public void addNewEmployee() {
        goToEmployeePage();
        waitForEmployeePageJSExecution();
        //TODO Verify Employee was not added before;

        app.driver.findElement(By.id("btnAdd")).click();
        app.sendKeysToField(app.empFirstName, "firstName");
        app.sendKeysToField(app.empLastName, "lastName");
        app.sendKeysToField(app.empId, "employeeId");
        app.driver.findElement(By.id("btnSave")).click();
        try {
            FindEmp.findEmployee();
            System.out.println("And is successfully added.");
        } catch (Exception e) {
            System.out.println("Cannot add employee id="+ app.empId + " " + app.empFirstName + " " + app.empLastName);
            throw (e);
        }
    }
}
