package org.ProjetLibrePlan.FormulaireQualite;

import org.ProjetLibrePlan.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.FileInputStream;

import static org.junit.Assert.assertEquals;

public class FQU_01_Gestion_Formulaire_Qualite extends AbstractTest {


    String pathProperties = "src/test/resources/database/" + this.className + ".properties";

    @Test
    public void FQU_01_Gestion_Formulaire_Qualite() throws Throwable {

        LOGGER.info("START OF TEST");

        // set properties file
        LOGGER.info("Loading properties file ...");
        propertyParam.load(new FileInputStream(pathProperties));
        LOGGER.info("Properties file loaded");

        // Driver URL
        LOGGER.info("Lancement de la page web");
        driver.get("http://localhost:8081/libreplan/");

        // initialize login page
        LOGGER.info("******************************* INITIALISATION ET CONNEXION AU SITE *******************************");
        LOGGER.info("Initialisation du driver à la page login");
        PageLogin pageLogin = new PageLogin(driver);
        LOGGER.info("Connexion au site");
        PagePlanification pagePlanification = pageLogin.seConnecter(wait, propertyParam.getProperty("login"), propertyParam.getProperty("pwd"));


        //initialisation de page header pour accéder aux onglets et assertion de la présence de l'onglet Calendrier
        assertEquals ("Calendrier", driver.findElement(By.xpath("//button[@class='z-menu-btn'])[1]")).getText());
        PageHeader pageHeader = new PageHeader(driver);

        //Passage de la souris sur l'ongle Ressources et clique sur sous-categorie Formulaire de qualite
        pageHeader.clickOption(wait, "Ressources", "Formualaires qualités", PageFormulaireQualite.class);
        LOGGER.info("Accès à la page Formulaire qualité");

        //Initialisation de pageFormulairequalite et assertion qu'on est bien sur la bonne page
        PageFormulaireQualite pageformulairequalite = new PageFormulaireQualite(driver);
        wait.until(ExpectedConditions.visibilityOf(pageformulairequalite.creerUnFormulaireQualité));
        wait.until(ExpectedConditions.visibilityOf(pageformulairequalite.champRechercheFormulaire));







    }
}

