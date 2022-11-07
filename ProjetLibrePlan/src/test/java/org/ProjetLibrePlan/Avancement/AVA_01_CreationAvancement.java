package org.ProjetLibrePlan.Avancement;

import org.ProjetLibrePlan.*;
import org.junit.Test;
import java.io.FileInputStream;
import java.io.IOException;

public class AVA_01_CreationAvancement extends AbstractTest {

    // initiate parameters
    String pathProperties = "src/test/resources/database/testLibrePlan.properties";

    /*
     *********** TESTS START HERE ***********
     */
    @Test
    public void AVA_01_CreationAvancement() throws Throwable {

        LOGGER.info("START OF TEST");

        // set properties file
        LOGGER.info("Loading properties file ...");
        propertyParam.load(new FileInputStream(pathProperties));
        LOGGER.info("Properties file loaded");

        // Driver URL
        LOGGER.info("Lancement de la page web");
        driver.get("http://localhost:8080/libreplan/");

        // initialize login page
        LOGGER.info("Initialisation du driver à la page login");
        PageLogin pageLogin = new PageLogin(driver);
        LOGGER.info("Connexion au site");
        PagePlanification pagePlanification = pageLogin.seConnecter(wait, propertyParam.getProperty("login"), propertyParam.getProperty("pwd"));
        LOGGER.info("Clique sur le menu Ressources et choix Type d'avancement");
        PageAvancement pageAvancement = pagePlanification.clickOption(wait, "Ressources", "Types d'avancement", PageAvancement.class);
        LOGGER.info("Création d'un type d'avancement");
        pageAvancement.creerAvancement(wait);
    }
}


//th[contains(@class, "z-column-sort")]/div/text()/ancestor::tbody/descendant::div/text()

//th[contains(@class, "z-column")]/div/text()

//tr[contains(@id,"r6kAr5")]/th/div/text()

//div[@class="clickable-rows z-grid"]

//div[@class="clickable-rows z-grid"]//tr[@class="z-columns"]/th