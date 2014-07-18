package com.example.tests;

import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;
import org.junit.*;
import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class UKPaymentTest {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "https://cashcoin-staging.zipzapinc.com/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testUKPayment() throws Exception {
    driver.get(baseUrl + "/index");
    driver.findElement(By.cssSelector("a.login-btn > span")).click();
    driver.findElement(By.id("SavedProfile_email")).clear();
    driver.findElement(By.id("SavedProfile_email")).sendKeys("valeriy.samiev+test07102@zipzapinc.com");
    driver.findElement(By.id("SavedProfile_mobile_number")).clear();
    driver.findElement(By.id("SavedProfile_mobile_number")).sendKeys("5556780923");
    driver.findElement(By.id("SavedProfile_first_name")).clear();
    driver.findElement(By.id("SavedProfile_first_name")).sendKeys("julia");
    driver.findElement(By.id("SavedProfile_last_name")).clear();
    driver.findElement(By.id("SavedProfile_last_name")).sendKeys("audi");
    driver.findElement(By.name("submit")).click();
    driver.findElement(By.name("submit")).click();
    for (int second = 0;; second++) {
    	if (second >= 60) fail("timeout");
    	try { if (isElementPresent(By.name("amount"))) break; } catch (Exception e) {}
    	Thread.sleep(1000);
    }

    driver.findElement(By.name("amount")).clear();
    driver.findElement(By.name("amount")).sendKeys("5");
    driver.findElement(By.name("yt0")).click();
    driver.findElement(By.name("amount")).clear();
    driver.findElement(By.name("amount")).sendKeys("305");
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.name("amount")).clear();
    driver.findElement(By.name("amount")).sendKeys("305");
    driver.findElement(By.name("yt0")).click();
    driver.findElement(By.name("amount")).clear();
    driver.findElement(By.name("amount")).sendKeys("12");
    driver.findElement(By.name("yt1")).click();
    driver.findElement(By.id("mollie")).click();
    driver.findElement(By.cssSelector("div.span9.text-left > input[name=\"amount\"]")).clear();
    driver.findElement(By.cssSelector("div.span9.text-left > input[name=\"amount\"]")).sendKeys("5");
    driver.findElement(By.cssSelector("button[name=\"payment_type\"]")).click();
    driver.findElement(By.name("amount")).clear();
    driver.findElement(By.name("amount")).sendKeys("305");
    driver.findElement(By.id("mollie")).click();
    driver.findElement(By.cssSelector("div.span9.text-left > input[name=\"amount\"]")).clear();
    driver.findElement(By.cssSelector("div.span9.text-left > input[name=\"amount\"]")).sendKeys("305");
    driver.findElement(By.cssSelector("button[name=\"payment_type\"]")).click();
    driver.findElement(By.id("wire_transfer")).click();
    driver.findElement(By.id("amount")).clear();
    driver.findElement(By.id("amount")).sendKeys("5");
    driver.findElement(By.cssSelector("#wire_transfer_form > div.span3.text-left > #wire_transfer")).click();
    driver.findElement(By.name("amount")).clear();
    driver.findElement(By.name("amount")).sendKeys("2005");
    driver.findElement(By.id("wire_transfer")).click();
    driver.findElement(By.id("amount")).clear();
    driver.findElement(By.id("amount")).sendKeys("305");
    driver.findElement(By.cssSelector("#wire_transfer_form > div.span3.text-left > #wire_transfer")).click();
    driver.findElement(By.id("mollie")).click();
    driver.findElement(By.cssSelector("div.span9.text-left > input[name=\"amount\"]")).clear();
    driver.findElement(By.cssSelector("div.span9.text-left > input[name=\"amount\"]")).sendKeys("5");
    driver.findElement(By.cssSelector("button[name=\"payment_type\"]")).click();
    driver.findElement(By.id("mollie")).click();
    driver.findElement(By.cssSelector("div.span9.text-left > input[name=\"amount\"]")).clear();
    driver.findElement(By.cssSelector("div.span9.text-left > input[name=\"amount\"]")).sendKeys("2005");
    driver.findElement(By.cssSelector("button[name=\"payment_type\"]")).click();
    driver.findElement(By.id("mollie")).click();
    driver.findElement(By.cssSelector("div.span9.text-left > input[name=\"amount\"]")).clear();
    driver.findElement(By.cssSelector("div.span9.text-left > input[name=\"amount\"]")).sendKeys("16");
    driver.findElement(By.cssSelector("button[name=\"payment_type\"]")).click();
    driver.findElement(By.name("method")).click();
    driver.findElement(By.cssSelector("div.confirm > button[type=\"submit\"]")).click();
    driver.findElement(By.xpath("//button[@type='submit']")).click();
    driver.findElement(By.cssSelector("a.login-btn > span")).click();
  }

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
}
