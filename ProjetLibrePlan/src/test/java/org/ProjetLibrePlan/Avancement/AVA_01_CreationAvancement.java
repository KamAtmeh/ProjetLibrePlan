package org.ProjetLibrePlan.Avancement;

import org.ProjetLibrePlan.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AVA_01_CreationAvancement extends AbstractTest {

    // initiate parameters
    String pathProperties = "src/test/resources/database/testLibrePlan.properties";

    /*
     *********** TESTS START HERE ***********
     */
    @Test
    public void AVA_01_CreationAvancement() throws IOException, InterruptedException {

        LOGGER.info("START OF TEST");

        // set properties file
        LOGGER.info("Loading properties file ...");
        propertyParam.load(new FileInputStream(pathProperties));
        LOGGER.info("Properties file loaded");

        // Driver URL
        driver.get("http://localhost:8080/libreplan/");

        // initialize login page
        PageLogin pageLogin = new PageLogin(driver);
        PagePlanification pagePlanification = pageLogin.seConnecter(propertyParam.getProperty("login"), propertyParam.getProperty("pwd"));
        LOGGER.info("Connexion au site");

//        String onglet = "Ressources";
//        WebElement elementOnglet = driver.findElement(By.xpath("//button[contains(text(), \"" + onglet + "\")]"));
//        //WebElement elementOnglet = driver.findElement(By.xpath("//button[contains(text(), \"Ressources\")]"));
//        action.moveToElement(elementOnglet).perform();
//        Thread.sleep(5000);
//        String option = "Critère";
//        WebElement choixOption = driver.findElement(By.xpath("//ul//a[@class=\"z-menu-item-cnt\" and contains(text(), \"" + option + "\")]"));
//        choixOption.click();
//        Thread.sleep(5000);

        PageRessourceListeFormulaireQualite pagetypeCritere = pagePlanification.clickOption("Ressources","Formulaires qualité", PageRessourceListeFormulaireQualite.class);
        Thread.sleep(5000);
        pagetypeCritere.clickBoutonCreerFormulaireQualite();
        Thread.sleep(5000);
    }
}
