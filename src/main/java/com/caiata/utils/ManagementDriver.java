package com.caiata.utils;

import org.apache.log4j.BasicConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import static com.caiata.utils.GlobalParameters.CHROME_DRIVER_PATH_WIN;

public class ManagementDriver {

    private static ChromeDriver chromeDriver;
    private static boolean mobile = false;

    /**
     * Metodo per startare il driver di Chrome
     * @param defaultChromeOptions per richiamre il chrome options
     */
    public static void startDriver(DefaulChromeOptions defaultChromeOptions){
        System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH_WIN);
        System.setProperty("org.freemarker.loggerLibrary", "none");

        chromeDriver = new ChromeDriver(defaultChromeOptions);

        System.err.close();
        System.setErr(System.out);
        new Utility().loadProp("log4j");
        BasicConfigurator.configure();
    }

    public static boolean isMobile() {
        return mobile;
    }

    public static void setMobile(boolean m) {
        mobile = m;
    }


    public static WebDriver getChromeDriver(){
        return chromeDriver;
    }

    /**
     * Metodo per stoppare il driver
     */
    public static void stopDriver() {
        if (chromeDriver != null) chromeDriver.quit();
    }

}
