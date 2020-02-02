package com.grid.project.ta.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverHelper {
    private WebDriver webDriver;

    public WebDriverHelper(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    private WebElement elementToBeClickable(By locator) {
        return new WebDriverWait(webDriver, 30)
                .until(ExpectedConditions.elementToBeClickable(locator));
    }

    public WebElement elementToBeClickableById(String id) {

        return elementToBeClickable(By.id(id));
    }





}
