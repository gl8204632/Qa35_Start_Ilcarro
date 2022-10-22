import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class LoginTests extends TestBase{



    @BeforeMethod
    public void precondition (){
        if (app.getHelperUser().isLogged()){
            app.getHelperUser().logOut();

        }

    }

    @Test
    public void LoginSuccessess(){
        app.getHelperUser().openLoginFormHeader();
        app.getHelperUser().fillLoginForm("kuka@gmail.com","Kuka12345$");
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");
    }

    @Test
    public void LoginSuccessessModels(){
        app.getHelperUser().openLoginFormHeader();
        app.getHelperUser().fillLoginForm("kuka@gmail.com","Kuka12345$");
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");
    }

    @AfterMethod

    public void postCondition(){
        app.getHelperUser().clickOkButton();
    }
}
