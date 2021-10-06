package practice2021;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class EditEmployeeInfo extends EmployeeListPageManager{
    @Test
    public void editEmployeeInfo(){
        goToEmployeePage();
        FindEmployee.findEmployee();
        editEmpPhoto();
        //        editEmployeeBloodType();
//        editEmployeeMaritalStatus();
//        editEmployeeNationality();
//        editEmployeeGender();
//        editEmployeeDoB();

    }

    private void editEmpPhoto() {
        driver.findElement(By.xpath("//a[text()=\"" + empId + "\"]")).click();
        driver.findElement(By.xpath("//img[@alt=\"Employee Photo\"]")).click();
        driver.findElement(By.xpath("//input[@id=\"photofile\"]")).sendKeys(PATH_TO_PHOTO);
        driver.findElement(By.id("btnSave")).click();
        WebElement element = driver.findElement(By.cssSelector("#btnDelete"));
        boolean isDisplayed = element.isDisplayed();
        Assert.assertEquals(isDisplayed, true);
        System.out.println("Now " + empFirstName + " " + empLastName + " has a photo.");
    }
}
