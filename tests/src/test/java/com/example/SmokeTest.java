package com.example;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import com.example.pages.TradingPage;

public class SmokeTest extends BaseSeleniumTest {

  @Test
  void canPlaceMockOrder() {
    
    driver.get(baseUrl + "/");

    var page = new TradingPage(driver);
    assertEquals("Mock Trading UI", page.getTitle());

    page.setSymbol("NVDA");
    page.setQty("3");
    page.clickPlace();

    new WebDriverWait(driver, Duration.ofSeconds(5))
        .until(d -> page.getResult().contains("Placed order:"));

    assertTrue(page.getResult().contains("NVDA x 3"));
  }
}