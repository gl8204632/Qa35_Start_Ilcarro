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
        import org.openqa.selenium.Alert;
        import org.openqa.selenium.By;
        import org.openqa.selenium.WebDriver;
        import org.openqa.selenium.WebElement;

        import java.util.List;

public class HelperUser extends  HelperBase{

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
        type(By.id("email"),email);
        type(By.id("password"),password);
    }
}
}

