package tests.day14_testNGFrameWork;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AmazonPAge;
import utilities.Driver;
import utilities.ReusableMethods;

public class C03_NutellaTesti {

    @Test
    public void test01(){
        ReusableMethods.bekle(3);
        //amazon ana sayfaya gidin
        Driver.getDriver().get("https://www.amazon.com");

        //nutella icin arama yapin
       //WebElement aramaKutusu= Driver.getDriver().findElement(By.id("twotabsearchtextbox"));

        AmazonPAge amazonPAge=new AmazonPAge();

       amazonPAge.amazonAramaKutusu.sendKeys("Nutella"+ Keys.ENTER);

        //sonuclarin nutella icerdigini test edin

        //WebElement aramaSonucuElementi=Driver.getDriver().findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String expectedKelime="Nutella";
        String actualAramaSonucu=amazonPAge.aramaSonucuElementi.getText();

        Assert.assertTrue(actualAramaSonucu.contains(expectedKelime));

        Driver.closeDriver();

    }


}
