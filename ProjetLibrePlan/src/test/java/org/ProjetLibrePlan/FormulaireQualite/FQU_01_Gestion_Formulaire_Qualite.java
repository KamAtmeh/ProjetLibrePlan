package org.ProjetLibrePlan.FormulaireQualite;

import org.ProjetLibrePlan.*;
import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.FileInputStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

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
        pageHeader.clickOption(wait, propertyParam.getProperty("menu"), propertyParam.getProperty("option"), PageFormulaireQualite.class);
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
        pagecreerformulairequalite.remplirChampsPrincipauxFormulaireQualitePourcentage(wait, propertyParam.getProperty("nomformulaire"), propertyParam.getProperty("descriptionformulaire"));

        //Verification des champs de liste elements formulaire qualite
        pagecreerformulairequalite.boutonNouvelElementDuFormulaireQualite.click();
        assertEquals("", pagecreerformulairequalite.champNomNouvelElementDuFormulaireQualite.getText());
        assertEquals("1", pagecreerformulairequalite.numeroPositionDuNouvelElementDuFormualireQualite.getText());
        Thread.sleep(10000);
        wait.until(ExpectedConditions.visibilityOf(pagecreerformulairequalite.boutonsupprimeNouvelElementduFormulaire));
        pagecreerformulairequalite.boutonsupprimeNouvelElementduFormulaire.click();

        //Creation de la première lsite d'element formulaire qualite
        pagecreerformulairequalite.remplirNouvelElementDuFormulairePourcentage(wait,propertyParam.getProperty("nvlElementname"), propertyParam.getProperty("pourcentage"));
        pagecreerformulairequalite.boutonNouvelElementDuFormulaireQualite.click();
        Thread.sleep(10000);
        assertTrue( pagecreerformulairequalite.numeroPositionDuNouvelElementDuFormualireQualite.isDisplayed());
        assertEquals("2", pagecreerformulairequalite.numero2position.getText());

        //Creation de la deuxieme liste d'element formulaire qualite
        pagecreerformulairequalite.creerSecondNouvelElementDuFormulaire(wait, propertyParam.getProperty("secondnom"), propertyParam.getProperty("secondpourcentage"));

        //Verification que Element1 reprend bien la position 1 dans la liste par screenshot
        wait.until(ExpectedConditions.visibilityOf(pagecreerformulairequalite.numeroPositionDuNouvelElementDuFormualireQualite));
        tools.takeSnapShot(driver,"VerificationReprisePositionElement1");
        LOGGER.info("Screenshot changement de position pris");

        //Cliquer sur bouton 'sauver' et voir si message apparait bien et si titre de la page est bien Formulaire Test1
        pagecreerformulairequalite.sauvegarder(wait);
        assertTrue(driver.findElement(By.xpath("//div[@class='message_INFO']")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("//td[contains(text(),'Modifier Formulaire qualité: Test1')] ")).isDisplayed());

        //Appuyer sur bouton annuler pour retourner à PageFormulaireQualite et verifier que le formulaire crée est bien présent dans la liste
        pagecreerformulairequalite.annulerPageCreeFormulaireQualite(wait);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//span[contains(text(),'Test1')]) [2]")));

        //Clicker sur nom formulaire et arrivée sur page Modifier, formulaire
        pageformulairequalite.clickerSurNomFormulaire(wait, propertyParam.getProperty("$nomformulaire"));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//td[contains (text(), 'Modifier Formulaire qualité: Test1') ]")));

        //Modifier champ pourcentage en element
        PageModifierFormulaireQualite pageModifierFormulaireQualite = new PageModifierFormulaireQualite(driver);
        pageModifierFormulaireQualite.setMenuDeroulantElement(wait);
        wait.until(ExpectedConditions.visibilityOf(pageModifierFormulaireQualite.menuDeroulantElement));

        //Enregistrement modification et vérification que message d'enregistrement apparait bien
        pageModifierFormulaireQualite.passageEnregistrementPageModifierAListe(wait);
        Thread.sleep(10000);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//span[contains(text(),'Test1')]) [2]")));

        //suppression formulaire
        pageformulairequalite.supprimerFormulairesurPageListeFormulaire(wait);
        Thread.sleep(10000);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//span[@class='z-label'])[1]")));
        LOGGER.info("Formulaire qualite supprime");


















    }
}

