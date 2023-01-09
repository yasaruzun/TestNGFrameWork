package tests.day18_htmlReports;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPAge;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.TestBaseRapor;

public class C01_HTML_Reports extends TestBaseRapor {

    @Test
    public void test01(){

        extentTest=extentReports.createTest("Nutella Testi","kullanici amazonda nutella arayabilmeli");
        extentTest.info("amazon ana sayfaya gidildi");

        //amazon'a gidelim

        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));
        //nutella aratalim
        AmazonPAge amazonPAge=new AmazonPAge();

        amazonPAge.amazonAramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        extentTest.info("arama kutusuna nutella yazip, arama yapildi");

        //sonuclarin nutella icerdigini test edelim

        String actualSonucYazisi=amazonPAge.aramaSonucuElementi.getText();
        String expectedKelime="Nutella";
        extentTest.info("arama sonuclari kaydedildi");

        Assert.assertTrue(actualSonucYazisi.contains(expectedKelime));
        extentTest.pass("arama sonuclarinin nutella icerdigi test edildi");
    }
}
