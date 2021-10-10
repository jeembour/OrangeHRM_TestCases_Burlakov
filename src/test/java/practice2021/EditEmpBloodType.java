package practice2021;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class EditEmpBloodType extends EmpListPageManager {
    @Test
    public void editEmployeeBloodType() {
        FindEmp.findEmployee();
        driver.findElement(By.xpath("//a[text()=\"" + empId + "\"]")).click();
        driver.findElement(By.id("btnEditCustom")).click();
        Select drpBloodType = new Select(driver.findElement(By.xpath("//select[@name=\"custom1\"]")));
        int ind = Integer.parseInt(empBloodType);
        drpBloodType.selectByIndex(ind);
        driver.findElement(By.id("btnEditCustom")).click();
        try {
            actionSuccessful();
            System.out.println("Employee's blood type is successfully updated.");
        } catch (Exception e) {
            System.out.println("Cannot update employee's blood type.");
            throw (e);
        }
    }
}
