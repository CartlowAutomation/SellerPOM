package Pages;

import Base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;
import java.util.Random;

public class SellerRegistrationForm extends Base {

    @FindBy(xpath = "//ul[@class='select2-selection__rendered']")
    WebElement categories;

    @FindBy(xpath ="//input[@id='seller_name']")
    WebElement LegalRepresentative;

    @FindBy(xpath ="//input[@id='warehouse']")
    WebElement Address;

    @FindBy(xpath ="//input[@id='company_name']")
    WebElement CompanyName;

//    @FindBy(xpath ="//input[@id='company_name']")
//    WebElement CompanyName;



//    @FindBy(xpath = "//li[@id='select2-categories-xx-result-5s1m-51003']")
//    WebElement dditem;

    public SellerRegistrationForm() {

        PageFactory.initElements(driver, this);

    }

    public void SelectCategories() {

        for(int i=0;i<10;i++){ categories.click();
        List<WebElement> ctMenu = driver.findElements(By.xpath("//ul[@class='select2-results__options']/li"));
        Random rand = new Random();
        int val = rand.nextInt(ctMenu.size()-1);
        ctMenu.get(val).click();

        //For selecting single value
//         int j =300;
//        ctMenu.get(i).click();
    }



    }
}
