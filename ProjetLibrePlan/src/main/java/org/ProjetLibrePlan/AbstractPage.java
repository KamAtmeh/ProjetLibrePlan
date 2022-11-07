package org.ProjetLibrePlan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utils.Logging;
import utils.OutilsProjet;

public class AbstractPage extends Logging {

    WebDriver driver;

    public AbstractPage (WebDriver driver){
        this.driver = driver;
    }

}

