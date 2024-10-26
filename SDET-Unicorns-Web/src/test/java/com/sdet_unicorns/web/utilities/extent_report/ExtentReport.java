package com.sdet_unicorns.web.utilities.extent_report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.core.backend.TestCaseState;
import io.cucumber.java.Scenario;
import io.cucumber.plugin.event.PickleStepTestStep;
import io.cucumber.plugin.event.TestCase;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class ExtentReport {

    private static final String extentReportPath = System.getProperty("user.dir") + "/reports/";
    private static final String extentReportConfigPath = System.getProperty("user.dir") + "src/test/java/com/sdet_unicorns/web/utilities/extent_report/";
    private static final String delegateFieldName = "delegate";
    private static final String testCaseFieldName = "testCase";
    public static int tcNumber = 1;
    private static ExtentReports extent = new ExtentReports();
    private static ExtentTest test;
    private static int currentStepDefIndex;
    private static Scenario scenario;
    private static List<PickleStepTestStep> stepDefs;
    private static boolean currentlyUsingReport = false;

    @BeforeTest
    @Parameters("ReportName")
    public void startReport(String reportName) throws IOException {
        String extentReportConfigPath = getExtentReportConfigPath();
        currentlyUsingReport = true;
        ExtentSparkReporter sparkReporter = new ExtentSparkReporter(extentReportPath + reportName + ".html");
        sparkReporter.loadXMLConfig(new File(extentReportConfigPath + "extent-config.xml"));
        extent.attachReporter(sparkReporter);

        String cssContent = "";
        String jsContent = "";

        try {
            cssContent = new String(Files.readAllBytes(Paths.get(extentReportConfigPath + "extent.css")));
            jsContent = new String(Files.readAllBytes(Paths.get(extentReportConfigPath + "extent.js")));
        } catch (Exception e) {
            e.printStackTrace();
        }

        sparkReporter.config().setCss(cssContent);
        sparkReporter.config().setJs(jsContent);

//        extent.setSystemInfo("User Name",System.getProperty("user.name"));
        extent.setSystemInfo("Browser",System.getProperty("BROWSERNAME"));
//        extent.setSystemInfo("Pipeline Executor",System.getenv("BUILD_USER"));
//        extent.setSystemInfo("OS",System.getProperty("os.name"));
        extent.setSystemInfo("Java Version",System.getProperty("java.version"));
    }

    public static void setScenario(Scenario currentScenario){
        scenario = currentScenario;
    }

    public static ExtentTest startTC() {
        String testCaseName = tcNumber++ + "-  " + scenario.getName();
        test = extent.createTest(testCaseName);
        currentStepDefIndex = 0;
        test.assignCategory(getFeatureFileName());
        return test;
    }

    public static void setStepDefs() throws NoSuchFieldException, IllegalAccessException {
        TestCase testCase = getTestCase();
        stepDefs = getTestStepsDefs(testCase);
    }

    public static String getExtentReportConfigPath() {
        return extentReportConfigPath;
    }

    public static String getFeatureFileName() {
        Path featureFilePath = Paths.get(scenario.getUri());
        String fileName = featureFilePath.getFileName().toString();
        String[] parts = fileName.split("\\.feature");
        return parts[0];
    }

    private static TestCase getTestCase() throws NoSuchFieldException, IllegalAccessException {
        Field delegateField = scenario.getClass().getDeclaredField(delegateFieldName);
        delegateField.setAccessible(true);
        TestCaseState testCaseState = (TestCaseState) delegateField.get(scenario);

        Field testCaseField = testCaseState.getClass().getDeclaredField(testCaseFieldName);
        testCaseField.setAccessible(true);
        TestCase testCase = (TestCase) testCaseField.get(testCaseState);
        return testCase;
    }

    public static String getCurrentStepName(){
        String currentStepDescription;

        PickleStepTestStep currentStepDef = stepDefs.get(currentStepDefIndex);

        currentStepDescription = currentStepDef.getStep().getText();
        currentStepDefIndex += 1;

        return currentStepDescription ;
    }

    private static List<PickleStepTestStep> getTestStepsDefs(TestCase testCase) {
        return testCase.getTestSteps()
                .stream()
                .filter(x -> x instanceof PickleStepTestStep)
                .map(x -> (PickleStepTestStep) x)
                .collect(Collectors.toList());
    }

    public static ExtentReports getExtent() {
        return extent;
    }

    public static ExtentTest getTest() {
        return test;
    }

    public static boolean isCurrentlyUsingReport() {
        return currentlyUsingReport;
    }
}