package org.ProjetLibrePlan.FormulaireQualite;

import org.junit.Before;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.Logging;
import utils.OutilsProjet;

import java.util.Properties;
import java.util.Random;

public class Creationformulairequalite extends Logging {

    // Driver
    protected WebDriver driver;
    protected String windowPosition = "--window-position=2000,400";
    protected boolean maximizeDriver = true;
    protected WebDriverWait wait;
    protected int implicitWaitingTime = 2;
    protected int explicitWaitingTime = 10;


    // action and utils
    protected Actions action;
    protected OutilsProjet utils;
    protected Properties propertyParam;
    protected Random random;


    // Web Explorer
    String browser = "chrome";

    /*
     *********** DEFINE ACTIONS TO TAKE PLACE BEFORE AND AFTER TESTING ***********
     */

    @Before
    public void startup() {
        LOGGER.info("Setup LOGGER ...");
        System.setProperty("logFileName", this.className);
        LOGGER.info("Setup LOGGER executed");

        LOGGER.info("Launching " + browser + " ...");

        switch (browser.toLowerCase()) {
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments(windowPosition);
                driver = new FirefoxDriver();
                break;
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments(windowPosition); // opens browser on second monitor if possible
                driver = new ChromeDriver(chromeOptions);
                break;
            case "edge":
                System.setProperty("webdriver.edge.driver", "src/main/resources/drivers/msedgedriver.exe");
                driver = new EdgeDriver();
                driver.manage().window().setPosition(new Point(2000, 0)); // open browser on second monitor
                break;

            //driver.get("http://localhost:8081/libreplan/common/layout/login.zul");
            //driver.findElement(By.xpath("//input[@name='button']")).click();
        }

        //@Test
               // public void formulairequalite () {



        }

    }

