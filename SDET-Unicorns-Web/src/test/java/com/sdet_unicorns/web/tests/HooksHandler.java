package com.sdet_unicorns.web.tests;

import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.sdet_unicorns.web.driver.WebDriverSingleton;
import com.sdet_unicorns.web.properties.ReadPropertiesFile;
import com.sdet_unicorns.web.utilities.extent_report.ExtentReport;
import com.sdet_unicorns.web.utilities.extent_report.Screenshot;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.io.IOException;

public class HooksHandler extends BaseTest {

    @Before(order = 1)
    public void setUp() throws IOException {
        sdetUnicornsLink = ReadPropertiesFile.setHomeProperties();
        profileDetails = ReadPropertiesFile.setProfileDetails();
        driver = WebDriverSingleton.getDriverSingleton();

        driver.resetCache();
        driver.maximizeWindow();
        driver.navigateTo(sdetUnicornsLink.getProperty("sdetUnicornsUrl"));

    }

    @Before(order = 1)
    public void startTCHooks(Scenario scenario) {
        ExtentReport.setScenario(scenario);
        ExtentReport.startTC();
    }

    @Before(order = 2)
    public void setStepDefs() throws NoSuchFieldException, IllegalAccessException {
        ExtentReport.setStepDefs();
    }

    @AfterStep()
    public void
    afterStep(Scenario scenario) {
        String stepName = ExtentReport.getCurrentStepName();
        Status logStatus;

        if (scenario.isFailed()) {
            logStatus = Status.FAIL;
            String base64Screenshot = Screenshot.getScreenShot();
            ExtentReport.getTest().log(logStatus, stepName, MediaEntityBuilder.createScreenCaptureFromBase64String(base64Screenshot).build());
        }
        else {
            logStatus = Status.PASS;
            ExtentReport.getTest().log(logStatus,stepName);
        }
    }

    @After(order = 1)
    public void endTC() {
        if (ExtentReport.isCurrentlyUsingReport()) {
            ExtentReport.getExtent().flush();
        }
    }


    @After(order = 0)
    public void tearDownUssd() {
        closeWebDriverAfterAllTestsHook();
    }

    private void closeWebDriverAfterAllTestsHook() {
        Runtime.getRuntime().addShutdownHook(new Thread(WebDriverSingleton::close));
    }
}