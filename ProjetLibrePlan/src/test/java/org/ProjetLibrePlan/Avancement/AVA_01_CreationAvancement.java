package org.ProjetLibrePlan.Avancement;

import org.ProjetLibrePlan.AbstractTest;
import org.ProjetLibrePlan.PageLogin;
import org.ProjetLibrePlan.PagePlanification;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.IOException;

public class AVA_01_CreationAvancement extends AbstractTest {

    // initiate parameters
    String pathProperties = "src/test/resources/database/testJPetStore.properties";

    /*
     *********** TESTS START HERE ***********
     */
    @Test
    public void AVA_01_CreationAvancement() throws InterruptedException, IOException {

        LOGGER.info("START OF TEST");

        // set properties file
        LOGGER.info("Loading properties file ...");
        propertyParam.load(new FileInputStream(pathProperties));
        LOGGER.info("Properties file loaded");

        // Driver URL
        driver.get("http://localhost:8080/libreplan");

        // initialize welcome page
        PageLogin pageLogin = new PageLogin(driver);
        PagePlanification pagePlanification = pageLogin.seConnecter(propertyParam.getProperty("login"), propertyParam.getProperty("pwd"));
        LOGGER.info("Connexion au site");
    }
}
