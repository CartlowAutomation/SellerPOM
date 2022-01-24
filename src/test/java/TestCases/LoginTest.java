package TestCases;

import Base.Base;
import Pages.Login;
import Pages.SignUp;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginTest extends Base {
    Login l;

    public LoginTest(){
        super();
    }

    @BeforeMethod
    public void Setup(){

        Initialization();
        l= new Login();
    }

    @Test
    public void Login(){

        l.LoginThroughCredentials();

    }


}
