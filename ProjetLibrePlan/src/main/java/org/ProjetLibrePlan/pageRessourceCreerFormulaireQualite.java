package org.ProjetLibrePlan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class pageRessourceCreerFormulaireQualite extends AbstractPage {

    public pageRessourceCreerFormulaireQualite (WebDriver driver){
        super (driver);
        PageFactory.initElements(driver, this);
    }


}
