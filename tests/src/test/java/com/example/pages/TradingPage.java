package com.example.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TradingPage {
  private final WebDriver driver;

  private final By title = By.id("title");
  private final By symbol = By.id("symbol");
  private final By qty = By.id("qty");
  private final By place = By.id("place");
  private final By result = By.id("result");

  public TradingPage(WebDriver driver) {
    this.driver = driver;
  }

  public String getTitle() {
    return driver.findElement(title).getText();
  }

  public void setSymbol(String value) {
    var el = driver.findElement(symbol);
    el.clear();
    el.sendKeys(value);
  }

  public void setQty(String value) {
    var el = driver.findElement(qty);
    el.clear();
    el.sendKeys(value);
  }

  public void clickPlace() {
    driver.findElement(place).click();
  }

  public String getResult() {
    return driver.findElement(result).getText();
  }
}