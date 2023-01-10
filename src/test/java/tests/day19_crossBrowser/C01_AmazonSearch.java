package tests.day19_crossBrowser;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.ConfigReader;
import utilities.CrossDriver;
import utilities.Driver;
import utilities.TestBaseCross;

public class C01_AmazonSearch extends TestBaseCross {

    @Test
    public void test01(){
        //amazon ana sayfaya gidelim

        driver.get(ConfigReader.getProperty("amazonUrl"));


        //nutella icin arama yapalim
        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("nutella"+ Keys.ENTER);

        //sonuclarin nutella icerdigini test edelim
        WebElement sonucYaziElementi=driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));

        String actualSonucYazisi=sonucYaziElementi.getText();

        Assert.assertTrue(actualSonucYazisi.contains("nutella"));


    }


}
