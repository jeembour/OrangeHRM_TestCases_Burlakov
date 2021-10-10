package practice2021;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

public class EditEmpDoB extends EmpListPageManager {
    @Test
    public void editEmployeeDoB() {
        FindEmp.findEmployee();
        driver.findElement(By.xpath("//a[text()=\"" + empId + "\"]")).click();
        driver.findElement(By.id("btnSave")).click();
        sendKeysToField("1880-05-06", "personal_DOB");
        driver.findElement(By.id("btnSave")).click();
    }
}
