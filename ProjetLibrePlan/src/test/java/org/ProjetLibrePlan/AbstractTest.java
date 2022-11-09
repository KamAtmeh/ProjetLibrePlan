package org.ProjetLibrePlan;

import org.apache.ibatis.jdbc.ScriptRunner;
import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.GenTools;
import utils.Logging;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.*;
import java.util.concurrent.TimeUnit;

public class AbstractTest extends Logging {

    // Driver
    protected WebDriver driver;
    protected String windowPosition = "--window-position=2000,400";
    protected boolean maximizeDriver = true;
    protected WebDriverWait wait;
    protected int implicitWaitingTime = 2;
    protected int explicitWaitingTime = 10;


    // action and utils
    protected GenTools tools = new GenTools(className);
    protected Properties propertyParam;


   // Web Explorer
    String browser = "chrome";

    /*
     *********** DEFINE ACTIONS TO TAKE PLACE BEFORE AND AFTER TESTING ***********
     */

    @Before
//    @BeforeTest
    public void startup() {
        LOGGER.info("Setup LOGGER ...");
        System.setProperty("logFileName", this.className);
        LOGGER.info("Setup LOGGER executed");

        LOGGER.info("Launching " + browser + " ...");

        switch (browser.toLowerCase()) {
            case "firefox" :
                System.setProperty("webdriver.gecko.driver", "src/main/resources/drivers/geckodriver.exe");
                FirefoxOptions firefoxOptions = new FirefoxOptions();
                firefoxOptions.addArguments(windowPosition);
                driver = new FirefoxDriver();
                break;
            case "chrome" :
                System.setProperty("webdriver.chrome.driver", "src/main/resources/drivers/chromedriver.exe");
                ChromeOptions chromeOptions = new ChromeOptions();
                chromeOptions.addArguments(windowPosition); // opens browser on second monitor if possible
                driver = new ChromeDriver(chromeOptions);
                break;
            case "edge" :
                System.setProperty("webdriver.edge.driver", "src/main/resources/drivers/msedgedriver.exe");
                driver = new EdgeDriver();
                driver.manage().window().setPosition(new Point(2000,0)); // open browser on second monitor
                break;
        }
        LOGGER.info(browser + " launched");

        // call properties file
        LOGGER.info("Setup Properties ...");
        propertyParam = new Properties();
        LOGGER.info("Setup properties executed");
        // initiate driver and wait
        LOGGER.info("Setup of implicit wait and driver ...");
        if (maximizeDriver) { driver.manage().window().maximize(); }
        driver.manage().timeouts().implicitlyWait(implicitWaitingTime, TimeUnit.SECONDS);
        wait = new WebDriverWait (driver, explicitWaitingTime);
        LOGGER.info("Setup of implicit wait and driver executed");
    }


    @After
    public void tearDown() throws Exception {

        LOGGER.info("Take screenshot of last page ...");
        tools.takeSnapShot(driver, "test_end.png");
        LOGGER.info("Screenshot taken");
        LOGGER.info("Quit driver ...");
        driver.quit();
        LOGGER.info("Driver stopped");
//        LOGGER.info("************* REINITIALISATION DE LA BASE DE DONNEES *************");
//        LOGGER.info("Connexion à la base de donnée...");
//        //Getting the connection
//        String mysqlUrl = "jdbc:postgresql://localhost:5432/libreplan";
//        Connection con = DriverManager.getConnection(mysqlUrl, "postgres", "eql");
//        LOGGER.info("Connexion établie");
//        LOGGER.info("Initiation du query SQL...");
//        Statement st = con.createStatement();
//        LOGGER.info("Query inité");
//        LOGGER.info("Drop du schema de la base de donnée");
//        st.execute("DROP SCHEMA public CASCADE;");
//        LOGGER.info("Drop exécuté");
//        LOGGER.info("Réinitialisation de la base de donnée");
//        tools.executeSqlFile(con, "src/test/resources/database/backupSchemaLibrePlan.sql");
//        tools.executeSqlFile(con, "src/test/resources/database/backupDataLibrePlan.sql");
//        LOGGER.info("Réinitialisation effectuée");
//        // Closing DB Connection
//        LOGGER.info("Fermeture de la connexion à la base de donnée");
//        con.close();
//        LOGGER.info("Déconnexion de la base de donnée");

    }
}