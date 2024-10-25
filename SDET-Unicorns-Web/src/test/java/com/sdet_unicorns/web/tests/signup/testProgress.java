package com.sdet_unicorns.web.tests.signup;

import com.sdet_unicorns.web.driver.WebDriverSingleton;
import com.sdet_unicorns.web.properties.ReadPropertiesFile;
import com.sdet_unicorns.web.tests.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class testProgress extends BaseTest {


    public class SingletonClass
    {

        @BeforeMethod
        public void setup() throws IOException {
            driver = WebDriverSingleton.getDriverSingleton();
            driver.maximizeWindow();
            driver.navigateTo(ReadPropertiesFile.setConfigurations().getProperty("sdetUnicornsUrl"));
        }

        @Test
        public void scenario1(){
            sdetUnicorns.home.clickOnUserProfileDropDown();
            sdetUnicorns.register = sdetUnicorns.home.clickOnRegisterButton();
            sdetUnicorns.register.enterUsername("tagh1");
            sdetUnicorns.register.enterEmail("tagh1@gmail.com");
            sdetUnicorns.register.enterPassword("Taghreed1");
            sdetUnicorns.register.enterGender("Female");
            sdetUnicorns.register.clickOnRegisterButton();
        }

        @AfterMethod
        public void tearDown()
        {
            driver.close();
        }
    }
}
