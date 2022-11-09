package org.ProjetLibrePlan;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class PageParticipants extends  PageHeader {

    // ********* Constructeur ******** //
    public PageParticipants (WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // ********** Variables *********** //

}
