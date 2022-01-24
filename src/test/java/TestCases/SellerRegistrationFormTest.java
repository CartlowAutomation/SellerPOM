package TestCases;

import Base.Base;
import Pages.Login;
import Pages.SellerRegistrationForm;
import org.openqa.selenium.devtools.v85.log.Log;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class SellerRegistrationFormTest extends Base {

     SellerRegistrationForm rf;
     Login l;



    public SellerRegistrationFormTest(){
        super();
    }
    @BeforeMethod
    public  void Setup(){
        Initialization();
        rf = new SellerRegistrationForm();
        l=new Login();

    }

    @Test
    public void fillRegistrationForm(){

        l.LoginThroughCredentials();
        rf.SelectCategories();



    }





}
