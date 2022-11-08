package org.ProjetLibrePlan.Criteres;

import org.ProjetLibrePlan.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.GenTools;
import utils.Logging;

import java.util.Properties;

public class CRI_01_AdministrationDesCriteres extends AbstractTest {

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
            }
            LOGGER.info(browser + " launched");
        }

    @After
    public void tearDown() throws Exception {

        LOGGER.info("Take screenshot of last page ...");
        tools.takeSnapShot(driver, "test_end.png");
        LOGGER.info("Screenshot taken");
        LOGGER.info("Quit driver ...");
        driver.quit();
        LOGGER.info("Driver stopped");

    }

    @Test
    public void CR1_01_AdministrationDesCriteres() throws Throwable {

        LOGGER.info("START OF TEST");

        // Driver URL
        LOGGER.info("Lancement de la page web");
        driver.get("http://localhost:8080/libreplan/");

        // initialize login page
        LOGGER.info("******************************* INITIALISATION ET CONNEXION AU SITE *******************************");
        LOGGER.info("Initialisation du driver à la page login");
        PageLogin pageLogin = new PageLogin(driver);
        LOGGER.info("Connexion au site");
        PagePlanification pagePlanification = pageLogin.seConnecter(wait, propertyParam.getProperty("login"), propertyParam.getProperty("pwd"));
        LOGGER.info("Vérification que l'onglet Calendrier est actif");
        pagePlanification.displayCalendrierActif(wait);

        LOGGER.info("******************************* CHOIX DE MENU *******************************");
        LOGGER.info("Clique sur le menu Ressources et choix Type d'avancement");
        PageTypesCriteres pageTypesCriteres = pagePlanification.clickOption(wait, "Ressources", "Critère", PageTypesCriteres.class);

        LOGGER.info("******************************* VERIFICATION CONTENU PAGE *******************************\"");

    }
}


