package tests.day18_htmlReports;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.AmazonPAge;
import utilities.ConfigReader;
import utilities.Driver;

public class C02_DataProvider {
    @DataProvider
    public static Object[][] AmazonAranacakKelimeler() {
        /*
            @dataProvider istedigimiz test methoduna test datasi saglamak icin kullanilir
            sadece 1 sarti vardir
            iki katli bir object array'i dondurmelidir
         */

        Object[][] amazonAranacaKelimelerArrayi= {{"nutella"},{"java"}, {"apple"},{"samsung"}, {"armut"}};


        return amazonAranacaKelimelerArrayi;
    }

    //amazon'a gidelim
    //nutella,java, apple,samsung, armut kelimeleri icin arama yapalim
    //sonuclarin bu kelimeleri icerdigini test edelim

    @Test(dataProvider = "AmazonAranacakKelimeler")
    public void aramaTesti(String aranacakKelime){
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        AmazonPAge amazonPAge=new AmazonPAge();
        amazonPAge.amazonAramaKutusu.sendKeys(aranacakKelime+ Keys.ENTER);

        String actualSonucYazisi=amazonPAge.aramaSonucuElementi.getText();

        Assert.assertTrue(actualSonucYazisi.contains(aranacakKelime));


    }


}
