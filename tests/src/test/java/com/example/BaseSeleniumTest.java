package com.example;

import com.example.extensions.LoggingExtension;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.URL;
import java.time.Duration;

@ExtendWith(LoggingExtension.class)
public abstract class BaseSeleniumTest {
  protected WebDriver driver;
  protected String baseUrl;

  @BeforeEach
  void setUp() throws Exception {
    baseUrl = System.getenv().getOrDefault("BASE_URL", "http://localhost:3000");
    String seleniumUrl = System.getenv().getOrDefault("SELENIUM_URL", "http://localhost:4444/wd/hub");

    ChromeOptions options = new ChromeOptions();
    options.addArguments("--headless=new");
    options.addArguments("--no-sandbox");
    options.addArguments("--disable-dev-shm-usage");

    driver = new RemoteWebDriver(new URL(seleniumUrl), options);
    driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
  }

  @AfterEach
  void tearDown() {
    if (driver != null) driver.quit();
  }
}
