package practice2021.edit_employee;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import practice2021.app_manager.ApplicationManager;
import practice2021.app_manager.EmpListPageManager;
import practice2021.employee.FindEmp;

public class MaritalStatus extends EmpListPageManager {
    @Test
    public void editEmployeeMaritalStatus() {
        FindEmp.findEmployee();
        ApplicationManager.driver.findElement(By.xpath("//a[text()=\"" + ApplicationManager.empId + "\"]")).click();
        ApplicationManager.driver.findElement(By.id("btnSave")).click();
        Select drpMaritalStatus = new Select(ApplicationManager.driver.findElement(By.xpath("//select[@name=\"personal[cmbMarital]\"]")));
        int ind = Integer.parseInt(ApplicationManager.empMaritalStatus);
        drpMaritalStatus.selectByIndex(ind);
        ApplicationManager.driver.findElement(By.id("btnSave")).click();
        try {
            actionSuccessful();
            System.out.println("Employee's marital status is successfully updated.");
        } catch (Exception e) {
            System.out.println("Cannot update employee's marital status.");
            throw (e);
        }
    }
}
