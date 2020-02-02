package com.grid.project.ta.config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BrowserSettings {
    private WebDriver driver = null;
    private Properties dataDrivenProperties;
    DesiredCapabilities capability;

    public BrowserSettings() {
        dataDrivenProperties = new Properties();
        try {
            dataDrivenProperties.load(getClass().getClassLoader().getResourceAsStream("datadriven.properties.sample"));
        } catch (IOException e) {

            Logger.getLogger(getClass().getName()).log(Level.SEVERE, e.getMessage(), e);
        }
    }

    public WebDriver getWebDriver() throws IOException {
        capability = DesiredCapabilities.chrome();
        capability.setCapability("--no-sandbox", true);
        capability.setCapability("--disable-impl-side-painting", true);
        capability.setCapability("--disable-gpu", true);
        capability.setCapability("--disable-gpu-sandbox", true);
        capability.setCapability("--test-type=ui", true);
        capability.setCapability("--disable-accelerated-2d-canvas", true);
        capability.setCapability("--disable-accelerated-jpeg-decoding", true);

        if (dataDrivenProperties.getProperty("browser").equals("chrome")) {
            String localhost = "localhost:4444";
            driver = new RemoteWebDriver(new URL("http://" + localhost + "/wd/hub"), capability);

        }
        return driver;
    }
}
