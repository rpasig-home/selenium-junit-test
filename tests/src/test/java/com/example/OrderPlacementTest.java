package com.example;

import com.example.pages.TradingPage;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class OrderPlacementTest extends BaseSeleniumTest {

  @ParameterizedTest(name = "places order for {0} x {1}")
  @CsvSource({
      "NVDA, 3",
      "AAPL, 1",
      "TSLA, 10"
  })
  void placesOrderForMultipleSymbols(String symbol, String qty) {
    driver.get(baseUrl + "/");

    var page = new TradingPage(driver);
    page.setSymbol(symbol);
    page.setQty(qty);
    page.clickPlace();

    new WebDriverWait(driver, Duration.ofSeconds(5))
        .until(d -> page.getResult().contains("Placed order:"));

    assertTrue(page.getResult().contains(symbol + " x " + qty));
  }
}