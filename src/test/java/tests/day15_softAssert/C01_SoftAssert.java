package tests.day15_softAssert;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.AmazonPAge;
import utilities.Driver;
import utilities.ReusableMethods;

public class C01_SoftAssert {

    @Test
    public void test01(){

        // amazon ana sayfaya gidin
        Driver.getDriver().get("https://www.amazon.com");

        //amazon anasayfaya gittiginizi dogrulayın
        SoftAssert softAssert=new SoftAssert();

        String expectedUrlKelime="amazon";
        String actualUrl=Driver.getDriver().getCurrentUrl();

        softAssert.assertTrue(actualUrl.contains(expectedUrlKelime),"url amazon içermiyor");///message failed oldugunda çıkyır

        //Nutella aratin
        AmazonPAge amazonPAge=new AmazonPAge();
        amazonPAge.amazonAramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        //arama sonuclarının nutella icerdigini dogrulayin
        String aramaSonucYazisi=amazonPAge.aramaSonucuElementi.getText();
        softAssert.assertTrue(aramaSonucYazisi.contains("Nutella"),"arama sonucunda nutella yazmıyor");

        //java aratin
        amazonPAge.amazonAramaKutusu.clear();
        amazonPAge.amazonAramaKutusu.sendKeys("Java"+Keys.ENTER);
         ReusableMethods.bekle(1);

        //arama sonuclarinin 1000'den fazla oldugunu dogrulayin
        aramaSonucYazisi=amazonPAge.aramaSonucuElementi.getText();
        String [] sonucArr=aramaSonucYazisi.split(" ");
       //[1-48, of, over, 6,000, results, for, "Java"]

        String javaSonucSayisiStr=sonucArr[3];//6,000
        javaSonucSayisiStr=javaSonucSayisiStr.replaceAll("\\W","");//6000

        int sonucSayisiInt=Integer.parseInt(javaSonucSayisiStr);

        softAssert.assertTrue(sonucSayisiInt>1000,"sonuc sayisi 1000 den fazla degildir. ");


        softAssert.assertAll();// 3 tane assertion yaptik, bu yaptigimiz assertionlari failed oldgunda
        // raporlamayi yapar. failed oldugunda kod burda durur.

        Driver.closeDriver();
    }

}
