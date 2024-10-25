package com.sdet_unicorns.web.tests;

import com.sdet_unicorns.web.driver.WebDriverSingleton;
import com.sdet_unicorns.web.properties.ReadPropertiesFile;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import java.io.IOException;

public class HooksHandler extends BaseTest {

    @Before
    public void setUp() throws IOException {
        sdetUnicornsLink = ReadPropertiesFile.setHomeProperties();
        profileDetails = ReadPropertiesFile.setProfileDetails();
        driver = WebDriverSingleton.getDriverSingleton();

        driver.resetCache();
        driver.maximizeWindow();
        driver.navigateTo(sdetUnicornsLink.getProperty("sdetUnicornsUrl"));

    }

    @After
    public void tearDown()
    {
        driver.resetCache();
        driver.close();
    }
}