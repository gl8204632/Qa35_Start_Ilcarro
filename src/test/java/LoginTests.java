import models.User;
import org.testng.Assert;
import org.testng.annotations.*;

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

        User user=new User().withEmail("kuka@gmail.com").withPassword("Kuka12345$");
        app.getHelperUser().openLoginFormHeader();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");

    }


    @Test

    public void negativeWrongEmail(){
        User user=new User().withEmail("kukagmail.com").withPassword("Kuka12345$");
        app.getHelperUser().openLoginFormHeader();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();
        Assert.assertEquals(app.getHelperUser().getErrorText(),"It'snot look like email");

        Assert.assertFalse(app.getHelperUser().isYallaButtonNotActive());



    }


    @Test

    public void negativeWrongPasswordl(){
        User user=new User().withEmail("kuka@gmail.com").withPassword("karamba");
        app.getHelperUser().openLoginFormHeader();
        app.getHelperUser().fillLoginForm(user);
        app.getHelperUser().submit();

        Assert.assertEquals(app.getHelperUser().getMessage(),"Wrong email or password");

        Assert.assertEquals(app.getHelperUser().getTitleMassege(),"Authorization error");

    }

    @Test
    public void LoginUnSuccessess(){
        app.getHelperUser().openLoginFormHeader();
        app.getHelperUser().fillLoginForm("kuka@gmail.com","karamba");
        app.getHelperUser().submit();

       // Assert.assertEquals(app.getHelperUser().getMessage(),"Logged in success");
    }



  @AfterMethod

   public void postCondition(){
        app.getHelperUser().clickOkButton();
    }


}
