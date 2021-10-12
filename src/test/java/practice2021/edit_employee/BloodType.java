package practice2021.edit_employee;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import practice2021.app_manager.ApplicationManager;
import practice2021.app_manager.EmpListPageManager;
import practice2021.FindEmp;

public class BloodType extends EmpListPageManager {
    @Test
    public void editEmployeeBloodType() {
        FindEmp.findEmployee();
        ApplicationManager.driver.findElement(By.xpath("//a[text()=\"" + ApplicationManager.empId + "\"]")).click();
        ApplicationManager.driver.findElement(By.id("btnEditCustom")).click();
        Select drpBloodType = new Select(ApplicationManager.driver.findElement(By.xpath("//select[@name=\"custom1\"]")));
        int ind = Integer.parseInt(ApplicationManager.empBloodType);
        drpBloodType.selectByIndex(ind);
        ApplicationManager.driver.findElement(By.id("btnEditCustom")).click();
        try {
            actionSuccessful();
            System.out.println("Employee's blood type is successfully updated.");
        } catch (Exception e) {
            System.out.println("Cannot update employee's blood type.");
            throw (e);
        }
    }
}
