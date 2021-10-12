package practice2021.edit_employee;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import practice2021.app_manager.ApplicationManager;
import practice2021.app_manager.EmpListPageManager;
import practice2021.FindEmp;


public class DoB extends EmpListPageManager {
    @Test
    public void editEmployeeDoB() {
        String doB = "";
        FindEmp.findEmployee();
        ApplicationManager.driver.findElement(By.xpath("//a[text()=\"" + ApplicationManager.empId + "\"]")).click();
        ApplicationManager.driver.findElement(By.id("btnSave")).click();
        for (int i = 0; i < ApplicationManager.empDoB.length(); i++) {
            if (i == 4 || i == 6) {
                doB = doB + "-";
            }
            doB = doB + ApplicationManager.empDoB.charAt(i);
        }
        ApplicationManager.sendKeysToField(doB, "personal_DOB");
        ApplicationManager.driver.findElement(By.id("btnSave")).click();
        try {
            actionSuccessful();
            System.out.println("Employee's DoB is successfully updated.");
        } catch (Exception e) {
            System.out.println("Cannot update employee's DoB.");
            throw (e);
        }
    }
}
