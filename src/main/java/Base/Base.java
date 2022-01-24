package Base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class Base {

   public static WebDriver driver;
   public static Properties prop;



   public  Base(){

       prop = new Properties();
       try {
           FileInputStream ip = new FileInputStream(
           System.getProperty("user.dir")+"/src/main/java/Config/config.properties");
           prop.load(ip);
       } catch (FileNotFoundException e) {
           e.printStackTrace();
       } catch (IOException e) {
           e.printStackTrace();
       }


   }

   public static void Initialization() {

       String browserName = prop.getProperty("browser");
       if (browserName.equals("chrome")) {
           WebDriverManager.chromedriver().setup();
           driver = new ChromeDriver();
       } else if (browserName.equals("firefox")) {
           WebDriverManager.firefoxdriver().setup();
           driver = new FirefoxDriver();

       }

       driver.manage().window().maximize();
       driver.manage().deleteAllCookies();
       driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
       driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

       driver.get(prop.getProperty("url"));

   }

    public void setvalues(String key, String value)  {
        FileInputStream in = null;
        try {
            in = new FileInputStream(System.getProperty("user.dir")+"/src/main/java/Config/config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        Properties props1 = new Properties();
        try {
            props1.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FileOutputStream out = null;
        try {
            out = new FileOutputStream(System.getProperty("user.dir")+"/src/main/java/Config/config.properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        props1.setProperty(key, value);
        try {
            props1.store(out, null);
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
