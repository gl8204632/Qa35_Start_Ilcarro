//package manager;

//import org.openqa.selenium.Alert;
//import org.openqa.selenium.By;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;

//import java.util.List;

//public class HelperUser {
    //public HelperUser(WebDriver wd) {
    //}
//}
//
package manager;

       // import models.User;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class HelperUser extends  HelperBase {

    public HelperUser(WebDriver wd) {
        super(wd);
    }

    public void openLoginFormHeader() {
        wd.findElement(By.cssSelector("a[href ^='/login']")).click();

    }

    public void openLoginFormFooter() {
        wd.findElement(By.xpath("//a[text()='Log in']")).click();

    }

    public void fillLoginForm(String email, String password) {
        type(By.id("email"), email);
        type(By.id("password"), password);
    }


    public String getMessage() {
        //pause(2000);
        WebDriverWait wait = new WebDriverWait(wd, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(wd.findElement(By.cssSelector("div.dialog-container"))));
        return wd.findElement(By.cssSelector("h2.message")).getText();
    }

    public boolean isLogged(){
       return isElementPresent(By.xpath("//a[text()=' logout ']"));
    }

    public void logOut(){
        wd.findElement(By.xpath("//a[text()=' logout ']")).click();
    }

    public void clickOkButton(){
        click(By.xpath("//button[text()='Ok']"));
    }
}

