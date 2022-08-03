package com.test;

import com.test.registration.PrepareRegistrationTestData;
import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class ScreenshotExtension extends PrepareRegistrationTestData implements TestWatcher {
    @Override
    public void testFailed(ExtensionContext context, Throwable cause) {

          Allure.getLifecycle().addAttachment(
                "Screenshot",
                "image/png", "png",
                ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)
        );
        driver.close();
        driver.quit();
    }
/*
    private WebDriver getDriver(ExtensionContext context) {
        Object instance = context.getRequiredTestInstance();

        try {
            Field field = instance.getClass().getDeclaredField("driver");
            field.setAccessible(true);
            return  (WebDriver) field.get(instance);
        } catch (NoSuchFieldException | IllegalAccessException e){
            throw new RuntimeException(e);
        }
    }*/
}
