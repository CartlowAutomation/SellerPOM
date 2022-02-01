package Pages;

import Base.Base;
import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;
import java.util.Random;

public class SellerRegistrationForm extends Base {

    Faker f = new Faker();

    @FindBy(xpath = "//ul[@class='select2-selection__rendered']")
    WebElement categories;

    @FindBy(xpath ="//input[@id='seller_name']")
    WebElement LegalRepresentative;

    @FindBy(xpath ="//input[@id='warehouse']")
    WebElement Address;

    @FindBy(xpath ="//input[@id='company_name']")
    WebElement CompanyName;

    @FindBy(id ="countrySelector")
    WebElement CountryDropdown;

    @FindBy(id = "select2-cityselector-container")
    WebElement CityDropdown;

    @FindBy(id="select2-stateSelector-container")
    WebElement State;

    @FindBy(xpath="//input[@name='trade_license']")
    WebElement TradeLicense;

    @FindBy(xpath = "//input[@name='trade_license_expiry_date']")
    WebElement TLexpiryDate;

    @FindBy(xpath = "//input[@name='emirates_id_expiry_date']")
    WebElement EIDexpiryDate;

    @FindBy(xpath="//input[@name='emirates_id']")
    WebElement EmiratesID;

    @FindBy(xpath ="//input[@name='emirates_id_back']")
    WebElement EmiratesIdBack;

    @FindBy(xpath = "//input[@name='agree']")
    WebElement AgreeCheckbox;

    @FindBy(id="submit_button")
    WebElement Submit;

    @FindBy(xpath = "//img[@style='width: 200px;']")
    WebElement SuccessToast;


//    @FindBy(xpath = "//li[@id='select2-categories-xx-result-5s1m-51003']")
//    WebElement dditem;

    public SellerRegistrationForm() {

        PageFactory.initElements(driver, this);

    }

    public void SelectCategories() {

        for (int i = 0; i < 10; i++) {
            categories.click();
            List<WebElement> ctMenu = driver.findElements(By.xpath("//ul[@class='select2-results__options']/li"));
            Random rand = new Random();
            int val = rand.nextInt(ctMenu.size() - 1);
            ctMenu.get(val).click();

            //For selecting single value
//         int j =300;
//        ctMenu.get(i).click();
        }
    }

        public void SelectMonth(){

            Select month = new Select(CountryDropdown);
            month.selectByIndex(1);

        }

        public void  SelecCity() {

            CityDropdown.click();
            List<WebElement> cdd = driver.findElements(By.xpath("//ul/li[@class='select2-results__option']"));
            int j = 3;
            cdd.get(j).click();


        }

        public void SelectState(){
            State.click();
            List<WebElement> sdd = driver.findElements(By.xpath("//ul/li[@class='select2-results__option']"));
            int j=1 ;
            sdd.get(j).click();

        }

        public void UploadFiles(){
            TradeLicense.sendKeys(System.getProperty("user.dir")+"\\Pictures\\download.jpg");
            EmiratesID.sendKeys(System.getProperty("user.dir")+"\\Pictures\\download.jpg");
            EmiratesIdBack.sendKeys(System.getProperty("user.dir")+"\\Pictures\\download.jpg");;


        }

        public void AddDateandData(){

            TLexpiryDate.sendKeys("02/02/2050");
            EIDexpiryDate.sendKeys("02/02/2050");
            LegalRepresentative.sendKeys(f.name().fullName());
            Address.sendKeys(f.address().fullAddress());
            CompanyName.sendKeys(f.company().name());


        }

        public void Agree(){

            AgreeCheckbox.click();
            Submit.click();
        }


        public  void  Successs(){
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
            SuccessToast.isDisplayed();


        }

    }

