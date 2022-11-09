package org.ProjetLibrePlan.Avancement;

import org.ProjetLibrePlan.*;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Locale;

import static org.junit.Assert.*;

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

    ArrayList<String> expectedChampsAvancement = new ArrayList<String>() {
        {
            add("Nom d'unité");
            add("Actif");
            add("Valeur maximum par défaut");
            add("Précision");
            add("Type");
            add("Pourcentage");
        }
    };


    // initiate parameters
    String pathProperties = "src/test/resources/database/" + this.className + ".properties";

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
        LOGGER.info("******************************* INITIALISATION ET CONNEXION AU SITE *******************************");
        LOGGER.info("Initialisation du driver à la page login");
        PageLogin pageLogin = new PageLogin(driver);
        LOGGER.info("Connexion au site");
        PagePlanification pagePlanification = pageLogin.seConnecter(wait, propertyParam.getProperty("login"), propertyParam.getProperty("pwd"));
        LOGGER.info("Vérification que l'onglet Calendrier est actif");
        pagePlanification.displayCalendrierActif(wait);

        LOGGER.info("******************************* CHOIX DE MENU *******************************");
        LOGGER.info("Clique sur le menu Ressources et choix Type d'avancement");
        PageAvancement pageAvancement = pagePlanification.clickOption(wait, "Ressources", "Types d'avancement", PageAvancement.class);

        LOGGER.info("******************************* DEBUT DES VERIFICATIONS SUR LA PAGE *******************************");
        LOGGER.info("Vérification des noms des colonnes de la table");
        assertEquals("Noms des colonnes ne sont pas corrects", expectedColsAvancement, pageAvancement.getNomColonnes(wait));
        LOGGER.info("Vérification de la présence du bouton Créer");
        pageAvancement.displayCreer(wait);
        LOGGER.info("Clique sur le bouton créer d'un type d'avancement");
        pageAvancement.clickCreerAvancement(wait);
        LOGGER.info("Vérification des noms des champs du formulaire");
        assertEquals("Noms des champs du formulaire ne sont pas corrects", expectedChampsAvancement, pageAvancement.getNomChamps(wait));
        LOGGER.info("Vérification que le champ Nom d'unité est vide");
        assertEquals("Champ Nom d'unité n'est pas vide", propertyParam.getProperty("defautNomUnite"), pageAvancement.getNomUnite(wait));
        LOGGER.info("Vérification que la case Actif est cochée");
        assertTrue("Case actif n'est pas cochée par défaut", pageAvancement.isCheckedActif(wait));
        LOGGER.info("Vérification que la valeur par défaut du champ Valeur est 100,00");
        assertEquals("Valeur par défaut de Valeur n'est pas 100,00", propertyParam.getProperty("defautValeur"), pageAvancement.getValeurDefaut(wait));
        LOGGER.info("Vérification que la valeur par défaut du champ Précision est 0,1000");
        assertEquals("Valeur par défaut de Precision n'est pas 0,1000", propertyParam.getProperty("defautPrecision"), pageAvancement.getPrecisionDefaut(wait));
        LOGGER.info("Vérification que la valeur de Type est User");
        assertEquals("Valeur par défaut de Type n'est pas User", propertyParam.getProperty("defautType"), pageAvancement.getTypeDefaut(wait));
        LOGGER.info("Vérification que la valeur de Type n'est pas modifiable");
        assertFalse("Valeur de Type n'est pas modifiable", pageAvancement.isModifiableType(wait));
        LOGGER.info("Vérification que la case pourcentage n'est pas cochée");
        assertFalse("Case pourcentage est cochée par défaut", pageAvancement.isCheckedPourcentage(wait));
        LOGGER.info("Vérification de la présence des boutons enregistrer, sauver et continuer");
        assertTrue("Bouton enregistrer n'est pas visible", pageAvancement.isDisplayEnregister(wait));
        assertTrue("Bouton sauver n'est pas visible", pageAvancement.isDisplaySauver(wait));
        assertTrue("Bouton annuler n'est pas visible", pageAvancement.isDisplayAnnuler(wait));

        LOGGER.info("******************************* CREATION TYPE AVANCEMENT - 1 *******************************");
        LOGGER.info("Créer un type d'avancement");
        pageAvancement.creerAvancement(wait,
                propertyParam.getProperty("nomUnite_1"),
                Boolean.parseBoolean(propertyParam.getProperty("checkActif_1")),
                propertyParam.getProperty("valeurMax_1"),
                propertyParam.getProperty("defautPrecision"),
                Boolean.parseBoolean(propertyParam.getProperty("checkPourcentage_1")));
        pageAvancement.clickEnregistrer(wait);
        LOGGER.info("******************************* VERIFICATION DU TYPE AVANCEMENT *******************************");
        LOGGER.info("Vérifier que le message d'enregistrement est affiché");
        assertEquals("Le message d'enregistrement est conforme",
                "Type d'avancement \"" + propertyParam.getProperty("nomUnite_1") + "\" enregistré",
                pageAvancement.getMessageEnregistrement(wait, propertyParam.getProperty("nomUnite_1")));
        LOGGER.info("Vérification que le nouveau type d'avancement est dans la table");
        assertTrue("Nouveau type d'avancement pas présent dans la table", pageAvancement.isDisplayNouveauType(wait, propertyParam.getProperty("nomUnite_1")));
        LOGGER.info("Vérification de l'état activé du nouveau type d'avancement");
        assertFalse("Case activé est cochée", pageAvancement.isSelectedActiveNouveauAvancement(wait, propertyParam.getProperty("nomUnite_1")));
        assertFalse("Case activé est désactivée", pageAvancement.isEnabledActiveNouveauAvancement(wait, propertyParam.getProperty("nomUnite_1")));
        LOGGER.info("Vérification de l'état prédéfini du nouveau type d'avancement");
        assertFalse("Case prédéfini est cochée", pageAvancement.isSelectedPredefNouveauAvancement(wait, propertyParam.getProperty("nomUnite_1")));
        assertFalse("Case prédéfini est désactivée", pageAvancement.isEnabledPredefNouveauAvancement(wait, propertyParam.getProperty("nomUnite_1")));
        LOGGER.info("Vérification de la présence du bouton Modifier");
        assertTrue("Bouton Modifier n'est pas présent", pageAvancement.isDisplayModifier(wait, propertyParam.getProperty("nomUnite_1")));
        LOGGER.info("Vérification de la présence du bouton Supprimer");
        assertTrue("Bouton Supprimer n'est pas présent", pageAvancement.isDisplaySupprimer(wait, propertyParam.getProperty("nomUnite_1")));

        LOGGER.info("******************************* CREATION TYPE AVANCEMENT - 2 *******************************");
        LOGGER.info("Clique sur le bouton créer d'un type d'avancement");
        pageAvancement.clickCreerAvancement(wait);
        LOGGER.info("Vérifier l'affichage du titre de la page");
        pageAvancement.isDisplayTitreCreerAvancement(wait);
        LOGGER.info("Créer un type d'avancement");
        pageAvancement.creerAvancement(wait,
                propertyParam.getProperty("nomUnite_2"),
                Boolean.parseBoolean(propertyParam.getProperty("defautActif")),
                propertyParam.getProperty("defautValeur"),
                propertyParam.getProperty("defautPrecision"),
                Boolean.parseBoolean(propertyParam.getProperty("checkPourcentage_2")));
        LOGGER.info("Vérifier que la case Valeur maximum est désactivée");
        pageAvancement.isEnabledValeurMax(wait);
        LOGGER.info("Sauvegarder le type d'avancement");
        pageAvancement.clickSauver(wait);
        LOGGER.info("Vérifier que le message d'enregistrement est affiché");
        assertEquals("Le message d'enregistrement est conforme",
                "Type d'avancement \"" + propertyParam.getProperty("nomUnite_2") + "\" enregistré",
                pageAvancement.getMessageEnregistrement(wait, propertyParam.getProperty("nomUnite_2")));
        LOGGER.info("Vérifier titre de la page après sauvegarde");
        assertEquals("Le titre de la page n'est pas correct",
                "Modifier Type d'avancement: " + propertyParam.getProperty("nomUnite_2"), pageAvancement.getTitreModifier(wait));
        LOGGER.info("Clique sur le bouton annuler");
        pageAvancement.clickAnnuler(wait);
        LOGGER.info("Vérifier retour sur la page Types d'avancement Liste");
        pageAvancement.isDisplayTitle(wait);
        LOGGER.info("Vérification que le nouveau type d'avancement est dans la table");
        assertTrue("Nouveau type d'avancement pas présent dans la table", pageAvancement.isDisplayNouveauType(wait, propertyParam.getProperty("nomUnite_2")));
        LOGGER.info("Vérification de l'état activé du nouveau type d'avancement");
        assertTrue("Case activé est cochée", pageAvancement.isSelectedActiveNouveauAvancement(wait, propertyParam.getProperty("nomUnite_2")));
        assertFalse("Case activé est désactivée", pageAvancement.isEnabledActiveNouveauAvancement(wait, propertyParam.getProperty("nomUnite_2")));
        LOGGER.info("Vérification de l'état prédéfini du nouveau type d'avancement");
        assertFalse("Case prédéfini est cochée", pageAvancement.isSelectedPredefNouveauAvancement(wait, propertyParam.getProperty("nomUnite_2")));
        assertFalse("Case prédéfini est désactivée", pageAvancement.isEnabledPredefNouveauAvancement(wait, propertyParam.getProperty("nomUnite_2")));
        LOGGER.info("Vérification de la présence du bouton Modifier");
        assertTrue("Bouton Modifier n'est pas présent", pageAvancement.isDisplayModifier(wait, propertyParam.getProperty("nomUnite_2")));
        LOGGER.info("Vérification de la présence du bouton Supprimer");
        assertTrue("Bouton Supprimer n'est pas présent", pageAvancement.isDisplaySupprimer(wait, propertyParam.getProperty("nomUnite_2")));
        LOGGER.info("******************************* FIN DU TEST *******************************");
    }
}
