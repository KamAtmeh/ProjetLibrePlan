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

        LOGGER.info("******************************* VERIFICATION PRESENCE TABLEAU ET CREER *******************************\"");
        PageTypesCriteres pagetypesCriteres = new PageTypesCriteres(driver);
        pagetypesCriteres.displayTableau(wait);
        pagetypesCriteres.displayColNom(wait);
        pagetypesCriteres.displayColCode(wait);
        pagetypesCriteres.displayColType(wait);
        pagetypesCriteres.displayColActive(wait);
        pagetypesCriteres.displayColOperations(wait);
        pagetypesCriteres.displayBoutCreer(wait);

        LOGGER.info("******************************* CREATION CRITERE *******************************\"");
        LOGGER.info("Clique sur le bouton Créer pour accéder au formulaire de création");
        pagetypesCriteres.clicCreer();
        LOGGER.info("Vérification éléments");
        pagetypesCriteres.verifFormulaire(wait);
        pagetypesCriteres.verifBoutonEnregistrer(wait);
        pagetypesCriteres.verifBoutonSC(wait);
        pagetypesCriteres.verifBoutonAnnuler(wait);

        LOGGER.info("Remplissage formulaire 1");
        pagetypesCriteres.remplissageFormulaireAnnul(wait);
        LOGGER.info("Annulation et Vérification éléments");
        pagetypesCriteres.clicAnnulerCréation(wait);

        LOGGER.info("Remplissage formulaire 2");
        pagetypesCriteres.clicCreer();
        pagetypesCriteres.remplissageFormulaireEnreg(wait);
        LOGGER.info("Enregistrement et Vérification éléments");
        pagetypesCriteres.clicEnregistrerCréation(wait);

        LOGGER.info("Retour formulaire création");
        LOGGER.info("Vérification éléments");
        pagetypesCriteres.clicCreer();
        pagetypesCriteres.verifFormulaire(wait);
        pagetypesCriteres.verifBoutonEnregistrer(wait);
        pagetypesCriteres.verifBoutonSC(wait);
        pagetypesCriteres.verifBoutonAnnuler(wait);

        LOGGER.info("Remplissage formulaire 3");

        pagetypesCriteres.remplissageFormulaireSC(wait);
        LOGGER.info("Sauver et continuer, Vérification éléments et retour page d'administration des critères");
        pagetypesCriteres.clicSCCreation(wait);

        LOGGER.info("******************************* MODIFICATION CRITERE *******************************\"");
        LOGGER.info("accès formulaire modification critères via icône");
        pagetypesCriteres.accesModif(wait);
        LOGGER.info("Remplissage formulaire 1");
        pagetypesCriteres.modifCritereAnnuler(wait);

        LOGGER.info("accès formulaire modification critères via nom");
        pagetypesCriteres.accesModifNom(wait);
        LOGGER.info("Remplissage formulaire 2 puis retour page administration des critères");
        pagetypesCriteres.modifCritereSC(wait);

        LOGGER.info("******************************* SUPPRESSION CRITERE *******************************\"");
        LOGGER.info("accès et vérification popup suppression critères puis annulation");
        //pagetypesCriteres.annulationSuppressionCritere(wait);
        LOGGER.info("accès et vérification popup suppression critères puis confirmation");
        //pagetypesCriteres.confirmationSuppressionCritere(wait);
    }
}


