package com.grid.project.ta.tests;

import com.grid.project.ta.baseTest.BaseTest;
import org.openqa.selenium.Keys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.Test;

import java.io.IOException;

public class GridTests extends BaseTest {
    private static final Logger logger = LoggerFactory.getLogger(GridTests.class);

    public GridTests() throws IOException {
    }


    @Test(priority = 1)
    public void searchHeadphones() {
        logger.debug("Searching for headphones");
        getWebDriverHelper().elementToBeClickableById(CommonPaths.SEARCH_INPUT.path).click();
        getWebDriverHelper().elementToBeClickableById(CommonPaths.SEARCH_INPUT.path).sendKeys("headphones");
        getActions().sendKeys(Keys.ENTER).build().perform();
    }


}
