package com.example.extensions;

import io.qameta.allure.Allure;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.api.extension.TestWatcher;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.ByteArrayInputStream;

public class AllureScreenshotExtension implements TestWatcher {

  @Override
  public void testFailed(ExtensionContext context, Throwable cause) {
    Object testInstance = context.getRequiredTestInstance();

    if (!(testInstance instanceof HasDriver)) return;

    WebDriver driver = ((HasDriver) testInstance).getDriver();
    if (driver == null) return;

    try {
      byte[] png = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
      Allure.addAttachment("Screenshot on Failure", new ByteArrayInputStream(png));
    } catch (Exception ignored) {
      // don't fail the test because reporting failed
    }
  }

  /** Small interface so the extension can access driver safely */
  public interface HasDriver {
    WebDriver getDriver();
  }
}