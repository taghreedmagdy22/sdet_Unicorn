package com.sdet_unicorns.web.tests.shop;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/java/com/sdet_unicorns/web/tests/shop",
        glue = {"com.sdet_unicorns.web.tests"},
        plugin = {"html:reports/Purchase-Report.html"}

)

public class TestRunner extends AbstractTestNGCucumberTests {
}
