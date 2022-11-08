package org.ProjetLibrePlan.Avancement;

import org.ProjetLibrePlan.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class AVA_01_CreationAvancement extends AbstractTest {

    // variables
    ArrayList<String> expectedColsAvancement = new ArrayList<String>() {
        {
            add("Nom");
            add("Activé");
            add("Prédéfini");
            add("Opérations");
        }
    };


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
        LOGGER.info("Vérification des noms des colonnes de la table");
        assertEquals("Noms des colonnes ne sont pas corrects", expectedColsAvancement, pageAvancement.getNomColonnes(wait));
        LOGGER.info("Création d'un type d'avancement");
        pageAvancement.creerAvancement(wait);
    }
}
