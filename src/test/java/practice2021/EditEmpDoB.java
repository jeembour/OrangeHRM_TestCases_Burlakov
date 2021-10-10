package practice2021;

import org.openqa.selenium.By;
import org.testng.annotations.Test;


public class EditEmpDoB extends EmpListPageManager {
    @Test
    public void editEmployeeDoB() {
        String doB = "";
        FindEmp.findEmployee();
        driver.findElement(By.xpath("//a[text()=\"" + empId + "\"]")).click();
        driver.findElement(By.id("btnSave")).click();
        for (int i = 0; i < empDoB.length(); i++) {
            if (i == 4 || i == 6) {
                doB = doB + "-";
            }
            doB = doB + empDoB.charAt(i);
        }
        sendKeysToField(doB, "personal_DOB");
        driver.findElement(By.id("btnSave")).click();
        try {
            actionSuccessful();
            System.out.println("Employee's DoB is successfully updated.");
        } catch (Exception e) {
            System.out.println("Cannot update employee's DoB.");
            throw (e);
        }
    }
}
