package tests.day18_htmlReports;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.network.model.DataReceived;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C03_DataProviderIleNegatifLoginTesti {
    @DataProvider
    public static Object[][] kullaniciBilgileri() {

        Object[][] kullaniciBilgileriArr={{"A11","A12345"},{"B12","B12345"},{"C13","C12345"},{"D14","D12345"},{"E15","E12345"}};

        return kullaniciBilgileriArr ;
    }

    //Qualitydemy anasayfaya gidin
    //verilen yanlis kullanici adi ve password kombinasyonlari icin
    //giris yapilamadigini test edin

    //username  password
    //A11       A12345
    //B12       B12345
    //C13       C12345
    //D14       D12345
    //E15       E12345

    @Test(dataProvider = "kullaniciBilgileri")
    public void negatifLoginTest(String username,String password){

        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        QualitydemyPage qualitydemyPage=new QualitydemyPage();

        qualitydemyPage.ilkLoginLinki.click();

        qualitydemyPage.kullaniciEmailKutusu.sendKeys(username);
        qualitydemyPage.passwordKutusu.sendKeys(password);

        if (qualitydemyPage.cookieAccept.isDisplayed()){
            qualitydemyPage.cookieAccept.click();
            ReusableMethods.bekle(1);
        }


        qualitydemyPage.loginButonu.click();

        Assert.assertTrue(qualitydemyPage.kullaniciEmailKutusu.isDisplayed());



    }


}
