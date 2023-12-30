import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.WebDriver;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.openqa.selenium.WebDriver.*;

public class Davik {

    private static final String HOME_PAGE_URL = "https://daviktapes.com/";
    private static WebDriver driver;

    @BeforeAll
    public static void classSetup() {
        driver = DriverShared.getWevDriver();
        driver.get(HOME_PAGE_URL);
    }

    @AfterAll
    public static void classTearDown() {
        DriverShared.closeDriver();

    }

    @AfterEach
    public void testTearDown() {
        driver.get(HOME_PAGE_URL);
    }

    public void pause() {
        try {
            Thread.sleep(5000);
        } catch (Exception err) {
            System.out.println("Something went wrong");
        }
    }

    @Test
    public void actionCompanyTest() {
        driver.get("https://daviktapes.com/");
        driver.manage().window().maximize();
        pause();
        WebElement elementCompany = driver.findElement(By.xpath("/html/body/nav/div[1]/div[4]/div/ul/li[2]/a"));
        Actions actions = new Actions(driver);
        actions.moveToElement(elementCompany).build().perform();
        WebElement companyDropdown = driver.findElement(By.xpath("//*[contains(text(),'About us')]"));
        assertNotNull(companyDropdown);
    }

    @Test
    public void actionProductsTest() {
        driver.get("https://daviktapes.com/");
        driver.manage().window().maximize();
        pause();
        WebElement elementProducts = driver.findElement(By.xpath("/html/body/nav/div[1]/div[4]/div/ul/li[3]/a"));
        Actions actions = new Actions(driver);
        actions.moveToElement(elementProducts).build().perform();
        WebElement ProductsDropdown = driver.findElement(By.xpath("//*[contains(text(),'Pest Control')]"));
        assertNotNull(ProductsDropdown);

    }
    @Test
    public void actionIndustriesTest() {
        driver.get("https://daviktapes.com/");
        driver.manage().window().maximize();
        pause();
        WebElement elementIndustries = driver.findElement(By.xpath("/html/body/nav/div[1]/div[4]/div/ul/li[3]/a"));
        Actions actions = new Actions(driver);
        actions.moveToElement(elementIndustries).build().perform();
        WebElement industriesDropdown = driver.findElement(By.xpath("//*[contains(text(),'Retail')]"));
        assertNotNull(industriesDropdown);

    }
    @Test
    public void actionKnowledgeTest() {
        driver.get("https://daviktapes.com/");
        driver.manage().window().maximize();
        pause();
        WebElement elementKnowledge = driver.findElement(By.xpath("/html/body/nav/div[1]/div[4]/div/ul/li[5]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(elementKnowledge).build().perform();
        WebElement knowledgeDropdown = driver.findElement(By.xpath("//*[contains(text(),'Events')]"));
        assertNotNull(knowledgeDropdown);
    }

}