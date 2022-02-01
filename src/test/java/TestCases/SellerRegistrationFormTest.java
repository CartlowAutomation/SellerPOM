package TestCases;

import Base.Base;
import Pages.Login;
import Pages.SellerRegistrationForm;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.devtools.v85.log.Log;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.time.Duration;

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
    public void fillRegistrationForm() throws InterruptedException {

        l.LoginThroughCredentials();
        rf.SelectCategories();
        rf.SelectMonth();
        rf.SelecCity();
        rf.SelectState();
//        scroll(500);
        rf.UploadFiles();
        rf.AddDateandData();
        rf.Agree();
        rf.Successs();
    }

    @AfterMethod
    public void Close(){
        driver.quit();
    }






}
