package tests.day15_softAssert;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.QualitydemyPage;
import utilities.Driver;
import utilities.ReusableMethods;

public class C04_NegatifLoginTesti {

    //3 test methodu olusturun
    //1.de yanlis email, dogru sifre
    //2.de dogru email,yanlis sifre
    //3.de yanlis email,yanlis sifre ile giriş yapmayi deneyin
    //ve giris yapilamadigini test edin

    QualitydemyPage qualitydemyPage= new QualitydemyPage();

    @Test
    public void yanlisEmailTesti(){

        Driver.getDriver().get("https://www.qualitydemy.com/");
        qualitydemyPage.cookieAccept.click();
        ReusableMethods.bekle(2);
        qualitydemyPage.ilkLoginLinki.click();

        qualitydemyPage.kullaniciEmailKutusu.sendKeys("mehmet@abc.com");
        qualitydemyPage.passwordKutusu.sendKeys("31488081");

        qualitydemyPage.loginButonu.click();

        Assert.assertTrue(qualitydemyPage.kullaniciEmailKutusu.isDisplayed());
        Driver.closeDriver();
    }


    @Test
    public void yanlisPasswordTesti(){

        Driver.getDriver().get("https://www.qualitydemy.com/");

        qualitydemyPage.ilkLoginLinki.click();

        qualitydemyPage.kullaniciEmailKutusu.sendKeys("user_1106147@login.com");
        qualitydemyPage.passwordKutusu.sendKeys("123456");

        qualitydemyPage.loginButonu.click();

        Assert.assertTrue(qualitydemyPage.kullaniciEmailKutusu.isDisplayed());
        Driver.closeDriver();

    }


    @Test
    public void yanlisEmailYanlisPasswordTesti(){

        Driver.getDriver().get("https://www.qualitydemy.com/");

        qualitydemyPage.ilkLoginLinki.click();

        qualitydemyPage.kullaniciEmailKutusu.sendKeys("mehmet@abc.com");
        qualitydemyPage.passwordKutusu.sendKeys("123456");

        qualitydemyPage.loginButonu.click();

        Assert.assertTrue(qualitydemyPage.kullaniciEmailKutusu.isDisplayed());
        Driver.closeDriver();
    }
}
