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
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("(//button[@class='z-menu-btn'])[1]")));
        PageHeader pageHeader = new PageHeader(driver);

        //Passage de la souris sur l'ongle Ressources et clique sur sous-categorie Formulaire de qualite
        pageHeader.clickOption(wait, "Ressources", "Formulaires qualité", PageFormulaireQualite.class);
        LOGGER.info("Accès à la page Formulaire qualité");

        //Initialisation de pageFormulairequalite et assertion qu'on est bien sur la bonne page
        PageFormulaireQualite pageformulairequalite = new PageFormulaireQualite(driver);
        wait.until(ExpectedConditions.visibilityOf(pageformulairequalite.creerUnFormulaireQualité));
        wait.until(ExpectedConditions.visibilityOf(pageformulairequalite.champRechercheFormulaire));
        LOGGER.info("Voici la page Formulaire qualité");

        //Creation d' un nouveau formulaire et vérification qu'on est bien arrivé sur la page PageCreeFormulaireQualite
        pageformulairequalite.clickBoutonCreerFormulaireQualite(wait);
        PageCreerFormulaireQualite pagecreerformulairequalite = new PageCreerFormulaireQualite(driver);
        wait.until(ExpectedConditions.elementToBeClickable(pagecreerformulairequalite.champNomFormulaireQualite));
        wait.until(ExpectedConditions.elementToBeClickable(pagecreerformulairequalite.champDescriptionFormulaireQualite));

        //Entree des donnees dans le corps principal du formulaire de création de Formulaire Qualité et choix d'utiliser Pourcentage et pas Element
        pagecreerformulairequalite.remplirChampsPrincipauxFormulaireQualitePourcentage(wait,"Test1","Test1");

        //Verification des champs de liste elements formulaire qualite
        pagecreerformulairequalite.boutonNouvelElementDuFormulaireQualite.click();
        assertEquals("", pagecreerformulairequalite.champNomNouvelElementDuFormulaireQualite.getText());
        assertEquals("1", pagecreerformulairequalite.numeroPositionDuNouvelElementDuFormualireQualite.getText());
        wait.until(ExpectedConditions.visibilityOf(pagecreerformulairequalite.boutonsupprimeNouvelElementduFormulaire));
        pagecreerformulairequalite.boutonsupprimeNouvelElementduFormulaire.click();

        //Creation de la première lsite d'element formulaire qualite
        pagecreerformulairequalite.remplirNouvelElementDuFormulairePourcentage(wait,"Element 1","20");
        pagecreerformulairequalite.boutonNouvelElementDuFormulaireQualite.click();
        assertEquals("1", pagecreerformulairequalite.numeroPositionDuNouvelElementDuFormualireQualite.getText());
        assertEquals("2", driver.findElement(By.xpath("(//span[@class='z-label'])[8]")).getText());

        //Creation de la deuxieme liste d'element formulaire qualite
        pagecreerformulairequalite.creerSecondNouvelElementDuFormulaire(wait,"Element 2", "40");

        //




        //creatio de








    }
}

