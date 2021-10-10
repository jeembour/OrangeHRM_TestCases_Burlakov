package practice2021;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class EditEmpMaritalStatus extends EmpListPageManager {
    @Test
    public void editEmployeeMaritalStatus() {
        FindEmp.findEmployee();
        driver.findElement(By.xpath("//a[text()=\"" + empId + "\"]")).click();
        driver.findElement(By.id("btnSave")).click();
        Select drpMaritalStatus = new Select(driver.findElement(By.xpath("//select[@name=\"personal[cmbMarital]\"]")));
        int ind = Integer.parseInt(empMaritalStatus);
        drpMaritalStatus.selectByIndex(ind);
        driver.findElement(By.id("btnSave")).click();
        try {
            actionSuccessful();
            System.out.println("Employee's marital status is successfully updated.");
        } catch (Exception e) {
            System.out.println("Cannot update employee's marital status.");
            throw (e);
        }
    }
}
