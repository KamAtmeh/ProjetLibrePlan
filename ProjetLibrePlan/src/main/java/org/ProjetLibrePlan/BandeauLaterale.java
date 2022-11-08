package org.ProjetLibrePlan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertEquals;

public class BandeauLaterale extends PageHeader {


    public BandeauLaterale(WebDriver driver) {
        super(driver);
    }


    //<editor-fold desc="WebElements">

    //***Accès créer projet***
    @FindBy(xpath="//span[@title='Créer un nouveau projet']")
    WebElement accesCreerProjet;
    @FindBy(xpath="//div[text()='Créer un nouveau projet']")
    WebElement formCreerProjet;

    //***Accès page planification***
    @FindBy(xpath="//td[text()='Planification des projets']")
    WebElement accesPagePlanification;
    @FindBy(xpath="//span[text()='Planification des projets']")
    WebElement cheminPlannification;

    //***Accès page Liste des projets***
    @FindBy(xpath="//td[text()='Liste des projets']")
    WebElement accesPageProjets;
    @FindBy(xpath="//span[text()='Liste des projets']")
    WebElement cheminListeProjets;


    //***Accès page chargement des Ressources***
    @FindBy(xpath="//td[text()='Calendrier des ressources en file']")
    WebElement accesPageChargementRessources;
    @FindBy(xpath="//span[text()='Chargement des ressources']")
    WebElement cheminChargementRessources;



    //***Accès page Calendrier des ressources ***
    @FindBy(xpath="//td[text()='Calendrier des ressources en file']")
    WebElement accesPageCalendrierRessources;
    @FindBy(xpath="//span[text()='Calendrier des ressources en file']")
    WebElement cheminCalendrierRessources;

    //</editor-fold>




    //<editor-fold desc="Méthodes">
    public PageCreerProjet clickVersCreerProjet(WebDriverWait wait){
        LOGGER.info("Click accès formulaire de création d'un projet");
        accesCreerProjet.click();
        wait.until(ExpectedConditions.visibilityOf(formCreerProjet));
        return PageFactory.initElements(driver, PageCreerProjet.class);
    }


    public PagePlanification clickVersPagePlanification(WebDriverWait wait) {

        LOGGER.info("Click accès page planification");
        accesPagePlanification.click();
        wait.until(ExpectedConditions.visibilityOf(cheminPlannification));
        return PageFactory.initElements(driver, PagePlanification.class);
    }


    public PageProjets clickVersPageListeProjets(WebDriverWait wait) {

        LOGGER.info("Click accès page liste des projets");
        accesPageProjets.click();
        wait.until(ExpectedConditions.visibilityOf(cheminListeProjets));
        return PageFactory.initElements(driver, PageProjets.class);
    }


    public PageChargementRessources clickVersPageChargementRessources(WebDriverWait wait) {

        LOGGER.info("Click accès page chargement des ressources");
        accesPageChargementRessources.click();
        wait.until(ExpectedConditions.visibilityOf(cheminChargementRessources));
        return PageFactory.initElements(driver, PageChargementRessources.class);
    }

    public PageCalendrierRessources clickVersPageCalendrierRessources(WebDriverWait wait) {

        LOGGER.info("Click accès page chargement des ressources");
        accesPageChargementRessources.click();
        wait.until(ExpectedConditions.visibilityOf(cheminChargementRessources));
        return PageFactory.initElements(driver, PageCalendrierRessources.class);
    }



    //</editor-fold>



}