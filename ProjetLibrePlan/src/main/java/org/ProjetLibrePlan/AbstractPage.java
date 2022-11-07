package org.ProjetLibrePlan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utils.GenTools;
import utils.Logging;
import utils.OutilsProjet;

public class AbstractPage extends Logging {

    // ***** Variables ***** //
    WebDriver driver;

    // ***** Objects ***** //
    GenTools tools = new GenTools(className);

    // ***** Constructeur ***** //
    public AbstractPage (WebDriver driver){
        this.driver = driver;
    }

}

