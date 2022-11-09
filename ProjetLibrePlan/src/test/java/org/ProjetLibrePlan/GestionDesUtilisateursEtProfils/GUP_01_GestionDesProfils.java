package org.ProjetLibrePlan.GestionDesUtilisateursEtProfils;

import org.ProjetLibrePlan.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.FileInputStream;

import static org.junit.Assert.assertEquals;

public class GUP_01_GestionDesProfils extends AbstractTest {
    String pathProperties = "src/test/resources/database/" + this.className + ".properties";

    @Test
    public void GUP_01_GestionDesProfils() throws Throwable {

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

        //set Page Profil

        PageProfil pageProfil = new PageProfil((driver));

        //Vérifier que champs Nom et Actions sont présents sur la page
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[contains(text(),'Nom de profil')]")));
        assertEquals ("Nom de profil", pageProfil.nomDesProfilsDansListe.getText());
        assertEquals("Actions",pageProfil.actionsSurPageProfils.getText());
        LOGGER.info("Page profil est bien presente");

        //Creer Profils, instancier PageCreeProfil et vérifier qu'on arrive bien sur la page PageCreeProfil avec assert sur présence champ Nom et Association avec les rôles
        pageProfil.creationDeProfil(wait);
        PageCreeProfil pageCreeProfil = new PageCreeProfil(driver);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//span[@class='z-tab-text']")));
        assertEquals("Nom", pageCreeProfil.texteNomPageCreeeProfil.getText());
        assertEquals("Association avec les rôles", pageCreeProfil.texteAssociationRole.getText());
        LOGGER.info("Page pour creer profils est bien presente");

        //Creation d'un Profil et selection des rôles Dépenses et Participants dans la liste
        pageCreeProfil.creerProfil(propertyParam.getProperty("name"),wait);
        Thread.sleep(5000);
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("(//img[@src='/libreplan/common/img/ico_borrar1.png']/parent::*) [7]")));
        Thread.sleep(10000);
        assertEquals("Participants", pageCreeProfil.champNomRole.getText());
        LOGGER.info(("Les roles sont biens inseres"));

        //Presence icone poubelle
        wait.until(ExpectedConditions.elementToBeClickable(pageCreeProfil.boutonSupprimerRole1));
        LOGGER.info("Bouton de supression rôle présent");

        //passer souris sur bouton suppression rôle et verification texte
        //pageCreeProfil.passerSurInfoBulle();

        //ajouter autre role
        pageCreeProfil.ajouterAutrerole(wait);
        Thread.sleep(10000);
        assertEquals("Canevas", pageCreeProfil.champNomRoleCanevas.getText());

        //ajouter role qu'on a deja
        pageCreeProfil.selectionnerMemeRole(wait);
        tools.takeSnapShot(driver, "AucunChangement");
        LOGGER.info("Aucun changement n'a lieu");

        //suppression de tous les rôles
        pageCreeProfil.suppressionRoles();
        //wait.until(ExpectedConditions.invisibilityOf(pageCreeProfil.boutonSupprimerRole2));
        LOGGER.info("Tous les rôles supprimés");

        //enregistrer profil et verifier qu'il est bien présent dans la liste des profils et que le message qui indique son enregistremenet est présent
        pageCreeProfil.enregistrerProfilPageCreeProfil(wait);
        wait.until(ExpectedConditions.visibilityOfElementLocated((By.xpath("//div[@class='message_INFO']"))));
        Thread.sleep(10000);
        assertEquals("Hed", pageProfil.nomProfilTableau.getText());

        //click sur colonne modification et acces à PageModifierProfil
        pageProfil.modificationProfil(wait);

        //set page modification et ajouter roles
        PageModifierProfil pageModifierProfil = new PageModifierProfil(driver);
        pageModifierProfil.ajouterRole(wait);

        //modifier nom et enregistrer modification du nom
        pageModifierProfil.modifierNomProfil(propertyParam.getProperty("name2"), wait);
        pageModifierProfil.enregistrerProfilPageModifierProfil(wait);


    }
}
