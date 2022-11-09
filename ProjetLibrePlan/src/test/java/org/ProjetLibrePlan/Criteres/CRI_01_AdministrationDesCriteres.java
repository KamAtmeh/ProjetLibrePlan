package org.ProjetLibrePlan.Criteres;

import org.ProjetLibrePlan.*;
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

import java.io.FileInputStream;
import java.util.Properties;

public class CRI_01_AdministrationDesCriteres extends AbstractTest {

    // initiate parameters
    String pathProperties = "src/test/resources/database/"+this.className+".properties";

    @Test
    public void CR1_01_AdministrationDesCriteres() throws Throwable {

        LOGGER.info("START OF TEST");

        // set properties file
        LOGGER.info("Loading properties file ...");
        propertyParam.load(new FileInputStream(pathProperties));
        LOGGER.info("Properties file loaded");

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
        LOGGER.info("Clique sur le menu Ressources et choix Critère");
        PageTypesCriteres pageTypesCriteres = pagePlanification.clickOption(wait, "Ressources", "Critère", PageTypesCriteres.class);

        LOGGER.info("******************************* VERIFICATION CONTENU PAGE *******************************\"");
        
    }
}


