package org.ProjetLibrePlan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class pageConfigurationCreeProfil extends AbstractPage {
    public pageConfigurationCreeProfil(WebDriver driver) {
        super(driver);
    }

    public class PageConfigurationListeProfil extends AbstractPage {

        public PageConfigurationListeProfil(WebDriver driver) {
            super(driver);
            PageFactory.initElements(driver, this);
        }
    }


}
