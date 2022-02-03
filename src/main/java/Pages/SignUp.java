package Pages;

import Base.Base;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.page.Page;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.time.Duration;
import java.util.List;

public class SignUp extends Base {

    String nFname;
    Faker f = new Faker();



   //Defining page factory(object repository)
   @FindBy(name="first_name")
   WebElement firstName;

    @FindBy(name="last_name")
    WebElement lastName;

    @FindBy(name="email")
    WebElement email;

    @FindBy(name="confirm_email")
    WebElement confirmEmail;

    @FindBy(name="password")
    WebElement password;

    @FindBy(name="confirm_password")
    WebElement confirmPassword;

    @FindBy(name="mobile")
    WebElement mobile;

    @FindBy(name="confirmation")
    WebElement confirmation;

    @FindBy(id="submit_button")
    WebElement register;

    @FindBy(id="phone-error")
    List<WebElement> error;

    @FindBy(xpath = "//div[@class='iti__selected-dial-code']")
    WebElement clickDrList;

    @FindBy (xpath = "//img[@class='img-responsive']")
    WebElement passImage;

    @FindBy(xpath = "//b[contains(text(),'Sign Up')]" )
    WebElement signInButton;



    //initializing page factory
    public SignUp(){

        PageFactory.initElements(driver,this);

    }

    //Actions
    public Login ValidSignUp() throws InterruptedException {


        signInButton.click();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        nFname = f.name().firstName().toLowerCase();
//        context.setAttribute("Name",nFname);
        firstName.sendKeys("Demo" + nFname);
        lastName.sendKeys(f.name().lastName().toLowerCase());
        String emailfield ="demo" + nFname + "@cartlow.com" ;
        email.sendKeys(emailfield);
        confirmEmail.sendKeys("demo" + nFname + "@cartlow.com");
        String passField = "123123";
        password.sendKeys(passField);
        confirmPassword.sendKeys("123123");

        mobile.sendKeys("503");
        mobile.sendKeys(f.number().digits(5));
        setvalues("email",emailfield);
        setvalues("pass", passField);
        Thread.sleep(2000);
        confirmation.click();

        Thread.sleep(2000);
        register.click();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        passImage.isDisplayed();


//        if (error.size() > 0) {
//
//            clickDrList.click();
//            List<WebElement> drmenu = driver.findElements(By.xpath("//ul/li/span[@class='iti__dial-code']"));
//
//            for (int i = 0; i < drmenu.size(); i++) {
//
//                WebElement allElements = drmenu.get(i);
//                String innerHTML = allElements.getAttribute("innerHTML");
//                if (innerHTML.contains("+971")) {
//                    allElements.click();
//                    register.click();
//
//                    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
//
//                    passImage.isDisplayed();
//
//                }
//            }


//        }

        return new Login();
    }


}
