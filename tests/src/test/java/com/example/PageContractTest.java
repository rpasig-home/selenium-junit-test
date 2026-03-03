package com.example;

import com.example.pages.TradingPage;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

public class PageContractTest extends BaseSeleniumTest {

  @Test
  void pageHasExpectedElements() {
        
    driver.get(baseUrl + "/");

    var page = new TradingPage(driver);
    assertEquals("Mock Trading UI", page.getTitle());

    // “Contract” checks: elements exist
    assertNotNull(driver.findElement(By.id("symbol")));
    assertNotNull(driver.findElement(By.id("qty")));
    assertNotNull(driver.findElement(By.id("place")));
    assertNotNull(driver.findElement(By.id("result")));
  }
}