package com.caiata.cucumber;

import com.caiata.utils.DefaulChromeOptions;
import com.caiata.utils.ManagementDriver;
import com.caiata.utils.Modello;
import com.caiata.utils.Utility;
import cucumber.api.java.After;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;


import java.util.Properties;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class CucumberTest {

    static private Modello modello = new Modello();
    static private DefaulChromeOptions defaulChromeOptions;
    static private WebDriver driver = null;
    static private Properties webProp = null;
    static private CucumberSteps steps = null;
    static private boolean mobile = false;

    @Given("start driver")
    public void startDriver(){
        ManagementDriver.setMobile(false);
        mobile = ManagementDriver.isMobile();

        defaulChromeOptions = new DefaulChromeOptions(new ChromeOptions());

        if(mobile){
            webProp = new Utility().loadProp("mobile");
            defaulChromeOptions.addArguments("--window-size=375,812");
            defaulChromeOptions.addArguments("--user-agent=Mozilla/5.0 (iPhone; CPU iPhone OS 10_3 like Mac OS X) AppleWebKit/602.1.50 (KHTML, like Gecko) CriOS/56.0.2924.75 Mobile/14E5239e Safari/602.1");
        }

        if(!mobile){
            webProp = new Utility().loadProp("web");
            defaulChromeOptions.addArguments("--kiosk");
        }

        ManagementDriver.startDriver(defaulChromeOptions);
        driver = ManagementDriver.getChromeDriver();
        steps = new CucumberSteps();
    }

    @Given("open amazon")
    public void openAmazon(){
        if(!mobile) {
            driver.get(webProp.getProperty("amazon.url"));
            steps.closeBanner(webProp);
        }else{
            driver.get(webProp.getProperty("amazon.url"));
            steps.closeBanner(webProp);
        }
    }

    @Then("print the category")
    public void printCategory(){
        if(!mobile) {
            String[] tmp = steps.getMenuCategory();
            System.out.println("----CATEGORIE----");
            for(int i = 0; i < tmp.length; i++){
                System.out.println(tmp[i]);
            }
        }else{
            driver.findElement(By.xpath(webProp.getProperty("xpath.novita"))).click();
            String[] tmp = steps.getMenuCategoryMobile();
            System.out.println("----CATEGORIE----");
            for(int i = 0; i < tmp.length; i++){
                System.out.println(tmp[i]);
            }
        }
    }

    @When("^make a search of item (.*)$")
    public void searchSuggested(String item){
        if (!mobile) {
            steps.searchNoClick(webProp, item);
        }else{
            steps.searchNoClickMobile(webProp, item);
        }
    }

    @Then("click on the suggest item")
    public void suggest(){
        if (!mobile) {
            steps.voceSuggeritaWeb(webProp);
        }else{
            steps.voceSuggeritaMobile(webProp);
        }
    }

    @Then("evidence element are printed")
    public void evidencePrint(){
        if (!mobile) {
            modello.stampaElementi(steps.getElementiEvidenza());
        }else{
            modello.stampaElementi(steps.getEvidenzaMoile());
        }
    }

    @Then("item page 1 are printed")
    public void printItem(){
        if (!mobile) {
            System.out.println("Pagina 1 : ");
            System.out.println("---------------- ");
            modello.stampaElementi(steps.getElementiPagine());
        }else{
            System.out.println("Pagina 1 : ");
            System.out.println("----------------");
            modello.stampaElementi(steps.getElementiPagineMobile());
        }
    }

    @Then("item page 2 are printed")
    public void printItem2() {
        if (!mobile) {
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS) ;
            System.out.println("Pagina 2 : ");
            System.out.println("---------------- ");
            driver.findElement(By.xpath(webProp.getProperty("xpath.button.avanti"))).click();
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS) ;
            modello.stampaElementi(steps.getElementiPagina1());
        } else {
            System.out.println("Pagina 2 : ");
            System.out.println("---------------- ");
            driver.findElement(By.className("a-last")).click();
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS) ;
            modello.stampaElementi(steps.getElementiPagineMobile());
        }
    }

    @Then("item page 3 are printed")
    public void printItem3(){
        if(!mobile){
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS) ;
            System.out.println("Pagina 3 : ");
            System.out.println("-----------------");
            driver.findElement(By.xpath(webProp.getProperty("xpath.button.avanti"))).click();
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS) ;
            modello.stampaElementi(steps.getElementiPagina2());
        }else{
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS) ;
            System.out.println("Pagina 3 : ");
            System.out.println("-----------------");
            driver.findElement(By.className("a-last")).click();
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS) ;
        }
    }

    @When("^search item (.*)$")
    public void search(String item){
        if(!mobile){
            steps.search(webProp, item);
        }else{
            steps.searchMobile(webProp, item);
        }
    }

    @Then("open new tab")
    public void newTab(){
        if(!mobile){
            assertTrue(steps.newTabWeb());
        }else{
            assertTrue(steps.newTabMobile());
        }
    }

    @Then("print number")
    public void printItemNumber(){
       if(!mobile) {
           assertEquals(steps.stampaNumero(webProp), ""+"50");
       }else{
           assertEquals(steps.stampaNumeroMobile(webProp), ""+"40");
       }
    }

    @When("^add item (.*) item (.*) item (.*) at cart$")
    public void addCart(String item1,String item2, String item3){
        if(!mobile){
            steps.addCartWeb(webProp, item1, item2, item3);
        }else{
            steps.addCartMobile(webProp,item1,item2,item3);
        }
    }

    @Then("clear cart")
    public void clearCart(){
       if(!mobile) {
           steps.clearCartWeb();
       }else{
           steps.clearCartMobile();
       }
    }

    @After
    public void stopDriver(){
        ManagementDriver.stopDriver();
    }
}
