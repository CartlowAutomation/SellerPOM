package TestCases;

import Base.Base;
import Pages.Login;
import Pages.SignUp;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SignUpTest extends Base {

    SignUp s;

    public SignUpTest(){

        super();
    }

    @BeforeMethod
    public void Setup(){

        Initialization();
        s= new SignUp();
    }

    @Test
    public void SuccessfulLogin() throws InterruptedException {

        s.ValidSignUp();





    }

    @AfterMethod
    public void Close(){
        driver.quit();
    }
}
