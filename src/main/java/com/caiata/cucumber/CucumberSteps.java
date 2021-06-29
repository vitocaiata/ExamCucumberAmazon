package com.caiata.cucumber;

import com.caiata.utils.ManagementDriver;
import com.caiata.utils.Modello;
import com.caiata.utils.Utility;
import org.openqa.selenium.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class CucumberSteps {

    private WebElement webElement;
    private WebDriver driver ;
    private float val1 = 0;
    private float val2 = 0;
    private float val3 = 0;
    private float val4 = 0;
    private float somma = 0;
    private float totale = 0;

    public CucumberSteps() {
        this.driver = ManagementDriver.getChromeDriver();
    }

    /**
     * Metodo per la ricerca
     * @param prop per caricare le prop
     * @param q stringa usata per la ricerca
     */
    public void search(Properties prop, String q) {
        webElement = driver.findElement(By.id(prop.getProperty("id.search")));
        webElement.clear();
        webElement.sendKeys(q);
        webElement.sendKeys(Keys.ENTER);
    }

    /**
     * Metodo per la ricerca in webMobile
     * @param prop per caricare le prop
     * @param q stringa usata per la ricerca
     */
    public void searchMobile(Properties prop, String q) {
        webElement = driver.findElement(By.xpath(prop.getProperty("xpath.search")));
        webElement.clear();
        webElement.sendKeys(q);
        webElement.sendKeys(Keys.ENTER);
    }

    /**
     * Metodo per la ricerca senza cliccare
     * @param prop per caricare le prop
     * @param q stringa usata per la ricerca
     */
    public void searchNoClick(Properties prop, String q) {
        webElement = driver.findElement(By.id(prop.getProperty("id.search")));
        webElement.clear();
        webElement.sendKeys(q);
    }

    /**
     * Metodo per la ricerca senza cliccare, per il webMobile
     * @param prop per caricare le prop
     * @param q stringa usata per la ricerca
     */
    public void searchNoClickMobile(Properties prop, String q) {
        webElement = driver.findElement(By.xpath(prop.getProperty("xpath.search")));
        webElement.clear();
        webElement.sendKeys(q);
    }

    /**
     * Metodo per chiudere banner cookie
     * @param prop per caricare le prop
     * @return
     */
    public boolean closeBanner(Properties prop) {
        try {
            Thread.sleep(4000);
            webElement = driver.findElement(By.id(prop.getProperty("id.banner")));
            if (webElement.isDisplayed()) {
                driver.findElement(By.id(prop.getProperty("id.btn.accept"))).click();
                System.out.println("Banner trovato e chiuso");
            }
        } catch (NoSuchElementException | TimeoutException | InterruptedException e) {
            System.out.println("Banner non trovato.");
            return false;
        }
        return true;
    }

    /**
     * Metodo per stampare le categorie
     * @return
     */
    public String[] getMenuCategory() {
        List<WebElement> listaElementi = driver.findElements(By.className("nav-search-dropdown"));
        String[] tmp = new String[listaElementi.size()];

        for (int i = 0; i < listaElementi.size(); i++) {
            tmp[i] = listaElementi.get(i).getText();
        }
        return tmp;
    }

    /**
     * Metodo per stampare le categorie in webMobile
     * @return
     */
    public String[] getMenuCategoryMobile(){
        List<WebElement> listaElementi = driver.findElements(By.className("a-padding-base"));
        String[] tmp = new String[listaElementi.size()];
        for (int i = 0; i < listaElementi.size(); i++) {
            tmp[i] = listaElementi.get(i).getText();
        }
        return tmp;
    }

    /**
     * Metodo per cercare la voce suggerita mobile
     */
    public void voceSuggeritaMobile(Properties prop){
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS) ;
        driver.findElement(By.id(prop.getProperty("id.suggerimento"))).click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS) ;
    }

    /**
     * Metodo per cercare la voce suggerita web
     */
    public void voceSuggeritaWeb(Properties prop){
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS) ;
        driver.findElement(By.id(prop.getProperty("id.suggerita"))).click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS) ;
    }

    /**
     * Metodo per stampare gli elementi in evidenza
     */
    public ArrayList<Modello> getElementiEvidenza() {
        ArrayList<Modello> listaModello = new ArrayList<>();
        for (WebElement element : driver.findElement(By.className(("feed-carousel-shelf")))
                .findElements(By.className("feed-carousel-card"))) {
            listaModello.add(new Modello(element.findElement(By.className("product-image")).getAttribute("alt"),
                    element.findElement(By.className("product-image")).getAttribute("src")));
        }
        return listaModello;
    }

    /**
     * Metodo per stampare gli elementi in evidenza in webMobile
     */
    public ArrayList<Modello> getEvidenzaMoile() {
        ArrayList<Modello> listaModello = new ArrayList<>();

        for (WebElement ele : driver.findElements(By.className("gwm-Card--withPadding"))) {
            if (ele.findElement(By.className("gwm-Card-heading")).getText().equals("Offerte in evidenza")) {
                for (WebElement element : ele.findElements(By.className("aok-clearfix"))) {
                    listaModello.add(new Modello(element.findElement(By.className("gwm-DealsCard-salePrice")).getText(),
                            element.findElement(By.className("gwm-DealsCard-title")).getText()));
                }
            }
        }
        return listaModello;
    }

    /**
     * Metodo per verifica presenza prezzo
     */
    public boolean get(WebElement element){
        int j = 0;
        for(WebElement ele : element.findElement(By.className("a-spacing-medium")).
                findElements(By.className("a-section"))){
            j++;
        }
        if(j>4) {
            return true;
        }
        return false;
    }

    /**
     * Metodo per stampare gli elementi delle pagine
     */
    public ArrayList<Modello> getElementiPagine() {
        ArrayList<Modello> listaModello = new ArrayList<>();
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS) ;
        for (WebElement element : driver.findElement(By.className("s-main-slot"))
                .findElements(By.cssSelector("div[data-component-type = 's-search-result']"))){
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS) ;
            /*if(get(element)) {
                driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS) ;
                listaModello.add(new Modello(element.findElement(By.className("a-spacing-none")).getText(),
                        element.findElement(By.className(("a-price-whole"))).getText(),
                        element.findElement(By.className("s-image")).getAttribute("src")));
            }else{

             */
                listaModello.add(new Modello(element.findElement(By.className("a-spacing-none")).getText(),
                        element.findElement(By.className("s-image")).getAttribute("src")));
            //}
        }
        return listaModello;
    }

    /**
     * Metodo per stampare gli elementi delle pagine
     */
    public ArrayList<Modello> getElementiPagina1() {
        ArrayList<Modello> listaModello = new ArrayList<>();
        for (WebElement element : driver.findElement(By.className("s-main-slot"))
                .findElements(By.cssSelector("div[data-component-type = 's-search-result']"))){
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS) ;
            if(get(element)) {
                driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS) ;
                listaModello.add(new Modello(element.findElement(By.className("a-spacing-none")).getText(),
                        element.findElement(By.className(("a-price-whole"))).getText(),
                        element.findElement(By.className("s-image")).getAttribute("src")));
            }else{
                listaModello.add(new Modello(element.findElement(By.className("a-spacing-none")).getText(),
                        element.findElement(By.className("s-image")).getAttribute("src")));
            }
        }
        return listaModello;
    }

    /**
     * Metodo per stampare gli elementi delle pagine
     */
    public ArrayList<Modello> getElementiPagina2() {
        ArrayList<Modello> listaModello = new ArrayList<>();
        for (WebElement element : driver.findElement(By.className("s-main-slot"))
                .findElements(By.cssSelector("div[data-component-type = 's-search-result']"))){
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS) ;
            if(get(element)) {
                driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS) ;
                listaModello.add(new Modello(element.findElement(By.className("a-spacing-none")).getText(),
                        element.findElement(By.className(("a-price-whole"))).getText(),
                        element.findElement(By.className("s-image")).getAttribute("src")));
            }else{
                listaModello.add(new Modello(element.findElement(By.className("a-spacing-none")).getText(),
                        element.findElement(By.className("s-image")).getAttribute("src")));
            }
        }
        return listaModello;
    }

    /**
     * Metodo per stampare gli elementi delle pagine in webMobile
     */
    public ArrayList<Modello> getElementiPagineMobile() {
        ArrayList<Modello> listaModello = new ArrayList<>();
        for (WebElement element : driver.findElements(By.cssSelector("div[data-component-type = 's-search-result']"))){
            driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS) ;
            listaModello.add(new Modello(element.findElement(By.className("a-size-small")).getText(),
                    element.findElement(By.className(("a-price-whole"))).getText(),
                    element.findElement(By.className("s-image")).getAttribute("src")));
        }
        return listaModello;
    }

    /**
     * Metodo per stampare numero di elementi nella pagina
     */
    public String stampaNumero(Properties prop){
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS) ;
        driver.findElement(By.xpath(prop.getProperty("xpath.btn.novita"))).click();
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS) ;
        driver.findElement(By.xpath(prop.getProperty("xpath.videogiochi"))).click();
        int i = 0;
        for(WebElement element : driver.findElements(By.className("zg-item-immersion"))){
            i ++;
        }
        System.out.println("Numero elementi : " + i);
        String strI = ""+i;
        return strI;
    }

    /**
     * Metodo per stampare numero di elementi nella pagina in webMobile
     */
    public String stampaNumeroMobile(Properties prop){
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            driver.findElement(By.xpath(prop.getProperty("xpath.novita"))).click();
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            driver.findElement(By.xpath(prop.getProperty("xpath.videogiochi"))).click();
            driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
            int i = 0;
            for (WebElement element : driver.findElements(By.className("a-fixed-left-grid-col"))) {
                i++;
            }
            System.out.println("Numero elementi : " + i);
            String strI = ""+i;
        return strI;
    }

    /**
     * Metodo per aggiungere al carrello web
     */
    public void addCartWeb(Properties webProp, String item2, String item3, String item4){
        try {
            Thread.sleep(2000);
            String prezzo = driver.findElement(By.className("a-price-whole")).getText();
            val1 = Float.parseFloat(prezzo.replace(',', '.'));
            System.out.println("Prezzo : " + val1);
            driver.findElement(By.cssSelector("div[data-component-type = 's-search-result'")).findElement(By.className("a-text-normal")).click();
            Thread.sleep(2000);
            driver.findElement(By.id(webProp.getProperty("id.btn.addcart"))).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        search(webProp, item2);

        try {
            Thread.sleep(2000);
            String prezzo2 = driver.findElement(By.className("a-price-whole")).getText();
            val2 = Float.parseFloat(prezzo2.replace(',', '.'));
            System.out.println("Prezzo : " + val2);
            driver.findElement(By.cssSelector("div[data-component-type = 's-search-result'")).findElement(By.className("a-text-normal")).click();
            Thread.sleep(2000);
            driver.findElement(By.id(webProp.getProperty("id.btn.addcart"))).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        search(webProp, item3);

        try {
            Thread.sleep(2000);
            String prezzo3 = driver.findElement(By.className("a-price-whole")).getText();
            val3 = Float.parseFloat(prezzo3.replace(',', '.'));
            System.out.println("Prezzo : " + val3);
            driver.findElement(By.cssSelector("div[data-component-type = 's-search-result'")).findElement(By.className("a-text-normal")).click();
            Thread.sleep(2000);
            driver.findElement(By.id(webProp.getProperty("id.btn.addcart"))).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        search(webProp, item4);
        try {
            Thread.sleep(2000);
            String prezzo = driver.findElement(By.className("a-price-whole")).getText();
            val4 = Float.parseFloat(prezzo.replace(',', '.'));
            System.out.println("Prezzo : " + val4);
            driver.findElement(By.cssSelector("div[data-component-type = 's-search-result'")).findElement(By.className("a-text-normal")).click();
            Thread.sleep(2000);
            driver.findElement(By.id(webProp.getProperty("id.btn.addcart"))).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        /*
         **Metodo del test per sommare prezzi e verificare il totale del carrello, problema con l'arrotondamento
         */
        try {
            Thread.sleep(2000);
            driver.findElement(By.id(webProp.getProperty("id.home"))).click();
            Thread.sleep(2000);
            driver.findElement(By.id(webProp.getProperty("id.btn.cart"))).click();

            Thread.sleep(2000);
            System.out.println("Totale carrello : " + driver.findElement(By.xpath(webProp.getProperty("xpath.totale.cart"))).getText());

            somma = val1 + val2 + val3 + val4;
            System.out.println("Somma : " + somma);

            String totale = driver.findElement(By.xpath(webProp.getProperty("xpath.totale.cart"))).getText().substring(0, 5);
            float tot = Float.parseFloat(totale.replace(',', '.'));

            if (Math.round(somma) == Math.round(tot)) {
                System.out.println("Somma del carrello uguale al totale carrello");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo per aggiungere al carrello mobile
     */
    public void addCartMobile(Properties webProp,String item2, String item3, String item4){
        try {
            Thread.sleep(2000);
            String prezzo = driver.findElement(By.className("a-price-whole")).getText();
            val1 = Float.parseFloat(prezzo.replace(',', '.'));
            System.out.println("Prezzo : " + val1);
            driver.findElement(By.cssSelector("div[data-component-type = 's-search-result'")).findElement(By.className("a-text-normal")).click();
            Thread.sleep(2000);
            driver.findElement(By.id(webProp.getProperty("id.add.cart"))).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        searchMobile(webProp, item2);

        try {
            Thread.sleep(2000);
            String prezzo2 = driver.findElement(By.className("a-price-whole")).getText();
            val2 = Float.parseFloat(prezzo2.replace(',', '.'));
            System.out.println("Prezzo : " + val2);
            driver.findElement(By.cssSelector("div[data-component-type = 's-search-result'")).findElement(By.className("a-text-normal")).click();
            Thread.sleep(2000);
            driver.findElement(By.id(webProp.getProperty("id.add.cart"))).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        searchMobile(webProp, item3);

        try {
            Thread.sleep(2000);
            String prezzo3 = driver.findElement(By.className("a-price-whole")).getText();
            val3 = Float.parseFloat(prezzo3.replace(',', '.'));
            System.out.println("Prezzo : " + val3);
            driver.findElement(By.cssSelector("div[data-component-type = 's-search-result'")).findElement(By.className("a-text-normal")).click();
            Thread.sleep(2000);
            driver.findElement(By.id(webProp.getProperty("id.add.cart"))).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        searchMobile(webProp, item4);
        try {
            Thread.sleep(2000);
            String prezzo = driver.findElement(By.className("a-price-whole")).getText();
            val4 = Float.parseFloat(prezzo.replace(',', '.'));
            System.out.println("Prezzo : " + val4);
            driver.findElement(By.cssSelector("div[data-component-type = 's-search-result'")).findElement(By.className("a-text-normal")).click();
            Thread.sleep(2000);
            driver.findElement(By.id(webProp.getProperty("id.add.cart"))).click();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        //Metodo del test per sommare prezzi e verificare il totale del carrello, problema con l'arrotondamento

        try {
            Thread.sleep(2000);
            driver.findElement(By.id(webProp.getProperty("id.home"))).click();
            Thread.sleep(2000);
            driver.findElement(By.id(webProp.getProperty("id.cart"))).click();

            Thread.sleep(2000);
            System.out.println("Totale carrello : " + driver.findElement(By.className("a-price-whole")).getText());

            somma = val1 + val2 + val3 + val4;
            System.out.println("Somma : " + somma);

            String totale = driver.findElement(By.className("a-price-whole")).getText();
            float tot = Float.parseFloat(totale.replace(',', '.'));

            if (Math.floor(somma) == Math.floor(tot)) {
                System.out.println("Somma del carrello uguale al totale carrello");
            }else{
                System.out.println("Somma del carrello NON uguale al totale carrello");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    /**
     * Metodo per eliminare oggetti nel carrello mobile
     */
    public void clearCartMobile(){
        try {
            Thread.sleep(1000);
            if (driver.findElement(By.cssSelector("input[data-action = 'delete']")).isDisplayed()) {
                driver.findElements(By.cssSelector("input[data-action = 'delete']")).get(0).click();
                Thread.sleep(1000);
                driver.findElements(By.cssSelector("input[data-action = 'delete']")).get(1).click();
                Thread.sleep(1000);
                driver.findElements(By.cssSelector("input[data-action = 'delete']")).get(1).click();
                Thread.sleep(1000);
                driver.findElements(By.cssSelector("input[data-action = 'delete']")).get(0).click();
            }
        } catch (InterruptedException | NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo per eliminare oggetti nel carrello web
     */
    public void clearCartWeb(){
        try {
            Thread.sleep(1000);
            if (driver.findElement(By.cssSelector("input[value='Rimuovi']")).isDisplayed()) {
                driver.findElements(By.cssSelector("input[value='Rimuovi']")).get(0).click();
                Thread.sleep(1000);
                driver.findElements(By.cssSelector("input[value='Rimuovi']")).get(1).click();
                Thread.sleep(1000);
                driver.findElements(By.cssSelector("input[value='Rimuovi']")).get(1).click();
                Thread.sleep(1000);
                driver.findElements(By.cssSelector("input[value='Rimuovi']")).get(1).click();
            }
        } catch (InterruptedException | NoSuchElementException e) {
            e.printStackTrace();
        }
    }

    /**
     * Metodo per aprire nuove tab web
     */
    public boolean newTabWeb(){
        try {
            Thread.sleep(1000);
            String principale = driver.getWindowHandle();
            for (int i = 5; i < 8; i++) {
                Thread.sleep(1000);
                driver.findElement(By.cssSelector("div[data-index = '" + i + "']")).findElement(By.className("a-text-normal")).click();
                Thread.sleep(1000);
                String href = driver.getCurrentUrl();
                Thread.sleep(1000);
                driver.navigate().back();
                Thread.sleep(1000);
                driver.switchTo().newWindow(WindowType.TAB);
                driver.get(href);
                Thread.sleep(1000);
                Utility.getScreenCast();
                Thread.sleep(1000);
                driver.switchTo().window(principale);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    /**
     * Metodo per aprire nuove tab mobile
     */
    public boolean newTabMobile(){
        try {
            Thread.sleep(1000);
            String principale = driver.getWindowHandle();
            for (int i = 5; i < 8; i++) {
                Thread.sleep(1000);
                driver.findElement(By.cssSelector("div[data-index = '" + i + "']")).findElement(By.className("a-text-normal")).click();
                Thread.sleep(1000);
                String href = driver.getCurrentUrl();
                Thread.sleep(1000);
                driver.navigate().back();
                Thread.sleep(1000);
                driver.switchTo().newWindow(WindowType.TAB);
                driver.get(href);
                Thread.sleep(1000);
                Utility.getScreenCast();
                Thread.sleep(1000);
                driver.switchTo().window(principale);
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
