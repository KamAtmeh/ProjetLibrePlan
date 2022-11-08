package org.ProjetLibrePlan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PagePlanification extends PageHeader {

    public PagePlanification (WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // ********** Variable ************ //
    @FindBy(xpath = "//td[contains(@class, \"current-section\")]//button[contains(text(), \"Calendrier\")]")
    WebElement ongletActifCalendrier;


    // ********** Methodes ************ //
    public boolean displayCalendrierActif(WebDriverWait wait){
        wait.until(ExpectedConditions.visibilityOf(ongletActifCalendrier));
        return ongletActifCalendrier.isDisplayed();
    }



}
