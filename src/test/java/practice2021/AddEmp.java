package practice2021;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import practice2021.app_manager.ApplicationManager;
import practice2021.app_manager.EmpListPageManager;

public class AddEmp extends EmpListPageManager {

    @Test(groups = {"checkintest", "funсtest"})
    public void addNewEmployee() {
        goToEmployeePage();
        waitForEmployeePageJSExecution();
        //TODO Verify Employee was not added before;

        ApplicationManager.driver.findElement(By.id("btnAdd")).click();
        ApplicationManager.sendKeysToField(ApplicationManager.empFirstName, "firstName");
        ApplicationManager.sendKeysToField(ApplicationManager.empLastName, "lastName");
        ApplicationManager.sendKeysToField(ApplicationManager.empId, "employeeId");
        ApplicationManager.driver.findElement(By.id("btnSave")).click();
        try {
            FindEmp.findEmployee();
            System.out.println("And is successfully added.");
        } catch (Exception e) {
            System.out.println("Cannot add employee id="+ ApplicationManager.empId + " " + ApplicationManager.empFirstName + " " + ApplicationManager.empLastName);
            throw (e);
        }
    }
}
