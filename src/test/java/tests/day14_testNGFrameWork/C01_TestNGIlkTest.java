package tests.day14_testNGFrameWork;

import org.testng.annotations.Test;

public class C01_TestNGIlkTest {

    /*
        TestNG test merhodlarini isim sirasina gore calistirir
        priority degeri verilen methodlar priority degeri kucukten buyuge  dogru calisir
        esit olan priority degerlerinde harf sirasina gore calisir
        eger priority degeri yazmazsak priority=0 kabul edilir
     */


    @Test (priority = 5)
    public void ilkTest(){
        System.out.println("ilk test calisti");
    }

    @Test (priority = 7)
    public void ikinciTest(){
        System.out.println("ikinci test calisti");
    }

    @Test (priority = 10)
    public void ucuncuTest(){
        System.out.println("ucuncu test calisti");
    }


}
