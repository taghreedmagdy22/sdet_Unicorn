package com.sdet_unicorns.web.tests.signup;

import com.sdet_unicorns.web.driver.WebDriverSingleton;
import com.sdet_unicorns.web.properties.ReadPropertiesFile;
import org.testng.annotations.Test;

import java.io.IOException;

public class testProgress {


    public class SingletonClass
    {
        WebDriverSingleton driver = new WebDriverSingleton();
        @Test
        public void openUrl() throws InterruptedException, IOException {
            driver.navigateTo(ReadPropertiesFile.setConfigurations().getProperty("sdetUnicornsUrl"));
        }

    }
}
