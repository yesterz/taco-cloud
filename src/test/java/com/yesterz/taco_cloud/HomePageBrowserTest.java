package com.yesterz.taco_cloud;

import java.util.concurrent.TimeUnit;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.By;
// import org.openqa.selenium.By.ByTagName;
import org.openqa.selenium.htmlunit.HtmlUnitDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment=WebEnvironment.RANDOM_PORT)
public class HomePageBrowserTest {

  @LocalServerPort
  private int port;
  private static HtmlUnitDriver browser;  
  
  @BeforeAll
  public static void setup() {
    browser = new HtmlUnitDriver();
    
    browser.manage().timeouts()
          .implicitlyWait(10, TimeUnit.SECONDS);
  }
  
  @AfterAll
  public static void teardown() {
    browser.quit();
  }
  
  @Test
  public void testHomePage() {
    String homePage = "http://localhost:" + port;
    browser.get(homePage);
    
    String titleText = browser.getTitle();
    Assertions.assertThat(titleText).isEqualTo("Taco Cloud");
    
    // String h1Text = browser.findElementByTagName("h1").getText();
    String h1Text = browser.findElement(By.tagName("h1")).getText();
    Assertions.assertThat(h1Text).isEqualTo("Welcome to...");

    
    // String imgSrc = browser.findElementByTagName("img")
    String imgSrc = browser.findElement(By.tagName("img"))
                                              .getAttribute("src");
    Assertions.assertThat(imgSrc).isEqualTo(homePage + "/images/TacoCloud.png");
  }
  
  
}
