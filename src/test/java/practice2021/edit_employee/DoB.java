package practice2021.edit_employee;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import practice2021.app_manager.EmpListPageManager;
import practice2021.employee.FindEmp;


public class DoB extends EmpListPageManager {
    @Test
    public void editEmployeeDoB() {
        String doB = "";
        FindEmp.findEmployee();
        app.driver.findElement(By.xpath("//a[text()=\"" + app.empId + "\"]")).click();
        app.driver.findElement(By.id("btnSave")).click();
        for (int i = 0; i < app.empDoB.length(); i++) {
            if (i == 4 || i == 6) {
                doB = doB + "-";
            }
            doB = doB + app.empDoB.charAt(i);
        }
        app.sendKeysToField(doB, "personal_DOB");
        app.driver.findElement(By.id("btnSave")).click();
        try {
            actionSuccessful();
            System.out.println("Employee's DoB is successfully updated.");
        } catch (Exception e) {
            System.out.println("Cannot update employee's DoB.");
            throw (e);
        }
    }
}
