package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {
    /*
        Driver claass'indan driver'i getDriver methodu ile kullaniyoruz
        sonradan projeye katilan insanlarin Driver class'indan obje olusturarak
        driver kullanmaya calismalarini engellemek icin

        Driver class'ini SINGLEON PATTERN ile duzenleyebiliriz
        Bunun icin Driver class'inin parametresiz consrustor'ini olusturup
        access modifier'ini private yapmamiz yeterli olur
     */

    //kimse bu class'dan obje uretemez
    private Driver(){

    }
    static WebDriver driver;

    public static WebDriver getDriver() {

        String browser= ConfigReader.getProperty("browser");

        if (driver == null) {


            switch (browser) {

                case "chrome":

                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver();
                break;

                case"firefox":
                    WebDriverManager.firefoxdriver().setup();
                    driver=new FirefoxDriver();
                    break;

                default:
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver();
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }

        return driver;

    }

    public static void closeDriver(){
        if(driver!=null){
            driver.close();
            driver=null;
        }

    }
}
