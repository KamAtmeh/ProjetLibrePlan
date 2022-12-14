package org.ProjetLibrePlan.ProjetsEtTaches;

import org.ProjetLibrePlan.*;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.io.FileInputStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class PRO_TA_01_CreerUnProjet extends AbstractTest {

    // initiate parameters
    String pathProperties = "src/test/resources/database/"+this.className+".properties";

    /*
     *********** TESTS START HERE ***********
     */
    @Test
    public void PRO_TA_01_CreerUnProjet() throws Throwable {

        LOGGER.info("START OF TEST");

        // set properties file
        LOGGER.info("Loading properties file ...");
        propertyParam.load(new FileInputStream(pathProperties));
        LOGGER.info("Properties file loaded");

        // Driver URL
        LOGGER.info("Lancement de la page web");
        driver.get("http://localhost:8081/libreplan/");

        // initialize login page
        LOGGER.info("Initialisation du driver à la page login");
        PageLogin pageLogin = new PageLogin(driver);
        LOGGER.info("Connexion au site");
        PagePlanification pagePlanification = pageLogin.seConnecter(wait, propertyParam.getProperty("login"), propertyParam.getProperty("pwd"));

        //clic bouton d'accès au formulaire
        LOGGER.info("Click on create a project icon");
        BandeauLateral bandeauLateral = new BandeauLateral(driver);
        PageCreerProjet pageCreerProjet = bandeauLateral.clickVersCreerProjet(wait);
        Thread.sleep(2000);
        //assertTrue("Echec : Non affichage du formulaire de création d'un projet",formCreerProjet.isDisplayed);

        //Remplir les champs du formulaire
        LOGGER.info("clear name field and input projectName");
        pageCreerProjet.RedirectionSuiteCreationProjet(wait,propertyParam.getProperty("projectName"),propertyParam.getProperty("projecCode"));
        LOGGER.info("Uncheck Generer code box");

        //
    }
}

