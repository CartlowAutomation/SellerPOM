package Pages;

import Base.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Login extends Base {


    @FindBy(id="email")
    WebElement emaillogin;

    @FindBy(id="password")
    WebElement passwordLogin;

    @FindBy(xpath="//button[contains(text(),'Log In')]")
    WebElement submit;



    public Login(){
            PageFactory.initElements(driver,this);
        }


    public void LoginThroughCredentials(){

        emaillogin.sendKeys(prop.getProperty("email"));
        passwordLogin.sendKeys(prop.getProperty("pass"));
        submit.click();


    }

    }

