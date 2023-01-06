package tests.day16_smokeTests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class C02_NegatifLoginTest {
    // 3 test method'u olusturun
// 1.de yanlis email, dogru sifre
// 2.de dogru email yanlis sifre
// 3.de yanlis email, yanlis sifre ile giris yapmayi deneyin
// giris yapilamadigini test edin

    @Test
    public void yanlısEmailTesti(){


        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        QualitydemyPage qualitydemyPage=new QualitydemyPage();

        qualitydemyPage.ilkLoginLinki.click();
        qualitydemyPage.kullaniciEmailKutusu.sendKeys(ConfigReader.getProperty("qdGecersizUserName"));
        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecerlipassword"));

        qualitydemyPage.cookieAccept.click();
        ReusableMethods.bekle(2);

        qualitydemyPage.loginButonu.click();
        ReusableMethods.bekle(2);

        Assert.assertTrue(qualitydemyPage.kullaniciEmailKutusu.isDisplayed());


        Driver.closeDriver();
    }
    @Test
    public void dogruEmailTesti(){


        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        QualitydemyPage qualitydemyPage=new QualitydemyPage();

        qualitydemyPage.ilkLoginLinki.click();
        qualitydemyPage.kullaniciEmailKutusu.sendKeys(ConfigReader.getProperty("qdGecerliUserName"));
        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));

        qualitydemyPage.cookieAccept.click();
        ReusableMethods.bekle(2);

        qualitydemyPage.loginButonu.click();
        ReusableMethods.bekle(2);

        Assert.assertTrue(qualitydemyPage.kullaniciEmailKutusu.isDisplayed());


        Driver.closeDriver();
    }
    @Test
    public void yanlisEmailYanlisSifre(){


        Driver.getDriver().get(ConfigReader.getProperty("qdUrl"));
        QualitydemyPage qualitydemyPage=new QualitydemyPage();

        qualitydemyPage.ilkLoginLinki.click();
        qualitydemyPage.kullaniciEmailKutusu.sendKeys(ConfigReader.getProperty("qdGecersizUserName"));
        qualitydemyPage.passwordKutusu.sendKeys(ConfigReader.getProperty("qdGecersizPassword"));

        qualitydemyPage.cookieAccept.click();
        ReusableMethods.bekle(2);

        qualitydemyPage.loginButonu.click();
        ReusableMethods.bekle(2);

        Assert.assertTrue(qualitydemyPage.kullaniciEmailKutusu.isDisplayed());


        Driver.closeDriver();
    }
}
