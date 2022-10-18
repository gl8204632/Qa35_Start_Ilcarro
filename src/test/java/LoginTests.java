import org.testng.annotations.Test;

public class LoginTests extends TestBase{




    @Test
    public void LoginSuccessess(){
        app.getHelperUser().openLoginFormHeader();
        app.getHelperUser().fillLoginForm("kuka@gmail.com","Kuka12345$");
    }
}
