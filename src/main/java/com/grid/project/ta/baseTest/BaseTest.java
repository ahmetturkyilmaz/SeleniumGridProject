package com.grid.project.ta.baseTest;

import com.grid.project.ta.config.BrowserSettings;
import com.grid.project.ta.utils.WebDriverHelper;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.IOException;
import java.util.Properties;

public class BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
    private WebDriver webDriver;
    private WebDriverWait webDriverWait;
    private Properties dataDrivenProperties;
    private Actions actions;
    private WebDriverHelper webDriverHelper;

    public BaseTest() throws IOException {
        BrowserSettings browserSettings = new BrowserSettings();
        webDriver = browserSettings.getWebDriver();
        webDriverWait = new WebDriverWait(webDriver, 30);
        actions = new Actions(webDriver);
        webDriverHelper = new WebDriverHelper(webDriver);
        dataDrivenProperties = new Properties();
        try {
            dataDrivenProperties.load(getClass().getClassLoader().getResourceAsStream("datadriven.properties.sample"));
        } catch (IOException e) {
            logger.error(e.getMessage());
            e.printStackTrace();
        }

    }

    protected WebDriver getWebDriver() {
        return webDriver;
    }

    protected Actions getActions() {
        return actions;
    }

    protected WebDriverHelper getWebDriverHelper() {
        return webDriverHelper;
    }

    @BeforeTest
    public void getPage() {
        getWebDriver().manage().window().maximize();
        getWebDriver().get(dataDrivenProperties.getProperty("url"));
        webDriverWait.until(webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
        logger.debug("Getting to Amazon Website");
    }

    @AfterTest
    public void closeBrowser() {
        getWebDriver().close();
    }
}
