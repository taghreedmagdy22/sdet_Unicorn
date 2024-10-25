package com.sdet_unicorns.web.tests.signup;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/com/sdet_unicorns/web/tests",
        glue = {"com.sdet_unicorns.web.tests"},
        plugin = {"html:reports/Signup-Report.html"}

)

public class TestRunner extends AbstractTestNGCucumberTests {
}
