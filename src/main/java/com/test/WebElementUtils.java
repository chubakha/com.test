package com.test;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebElementUtils {
    /*protected WebDriverWait getWebDriverWait(long timeoutInSeconds) {
        return (WebDriverWait) new WebDriverWait(AbstractApp.getInstanceDriver(), timeoutInSeconds)
                .pollingEvery(Duration.ofMillis(500))
                .withTimeout(Duration.ofSeconds(timeoutInSeconds))
                .ignoring(NoSuchElementException.class)
                .ignoring(StaleElementReferenceException.class);
    }*/
}
