import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
public class FbLesson11 {

    private static final String HOME_PAGE_URL = "https://www.facebook.com/";
    private static WebDriver driver;
    private String name;

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

    @Test
    public void nameErrorMessageTest() throws InterruptedException {
        driver.findElement(By.xpath("//*[text()='Create new account']")).click();
        assertNotNull(driver.findElement(By.xpath("//*[text()= 'Sign Up']")));
        Thread.sleep(2000);

        driver.findElement(By.xpath("//*[@name='websubmit']")).click();
        driver.findElement(By.xpath("//*[@name='firstname']")).click();
        WebElement errorName = driver.findElement(By.xpath("//*[contains(text(),'your name')]"));
        assertNotNull(errorName);
    }

    @Test
    public void lastNameErrorTest() throws InterruptedException {
        driver.findElement(By.xpath("//*[text()='Create new account']")).click();
        driver.findElement(By.xpath("//*[text()= 'Sign Up']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@name='websubmit']")).click();
        driver.findElement(By.xpath("//*[@name='lastname']")).click();
        WebElement lastName = driver.findElement(By.xpath("//*[contains(text(),'your name')]"));
        assertNotNull(lastName);
    }

    @Test
    public void passwordErrorTest() throws InterruptedException {
        driver.findElement(By.xpath("//*[text()='Create new account']")).click();
        driver.findElement(By.xpath("//*[text()= 'Sign Up']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@name='websubmit']")).click();
        driver.findElement(By.xpath("//*[@aria-label= 'New password']")).click();
        WebElement passwordError = driver.findElement(By.xpath("//*[contains(text(),'your name')]"));
        assertNotNull(passwordError);
    }

    @Test
    public void birthdayErrorTest() throws InterruptedException {
        driver.findElement(By.xpath("//*[text()='Create new account']")).click();
        driver.findElement(By.xpath("//*[text()= 'Sign Up']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@name='websubmit']")).click();
        driver.findElement(By.xpath("//*[@aria-label= 'New password']")).click();
        WebElement birthdayError = driver.findElement(By.xpath("//*[contains(text(),'like you entered')]"));
        assertNotNull(birthdayError);
    }

    @Test
    public void customErrorTest() throws InterruptedException {
        driver.findElement(By.xpath("//*[text()='Create new account']")).click();
        driver.findElement(By.xpath("//*[text()= 'Sign Up']")).click();
        Thread.sleep(1000);

        driver.findElement(By.xpath("//*[@name='websubmit']")).click();
        driver.findElement(By.xpath("//*[@name='sex' and @value=-1]")).click();
        driver.findElement(By.xpath("//*[@data-name='preferred_pronoun']")).click();
        driver.findElement(By.xpath("//*[@name='sex' and @value=-1]")).click();
        driver.findElement(By.xpath("//*[@data-name='preferred_pronoun']")).click();
        WebElement customError = driver.findElement(By.xpath("//*[contains(text(),'pronoun')]"));
        assertNotNull(customError);
    }

        @ParameterizedTest
        @ValueSource(strings = {"Aug", "Dec", "Jun"})
        public void monthDateTest(String monthInput) throws InterruptedException {
            driver.findElement(By.xpath("//*[text()='Create new account']")).click();
            driver.findElement(By.xpath("//*[text()='Sign Up']")).click();
            Thread.sleep(1000);

            WebElement monthDropdown = driver.findElement(By.cssSelector("select[name='birthday_month']"));
            monthDropdown.click();
            Select select = new Select(monthDropdown);
            select.selectByVisibleText(monthInput);
            String selectedMonth = select.getFirstSelectedOption().getText();
            assertEquals(monthInput, selectedMonth);
        }

        @Test
    public void linkTermTest() throws InterruptedException{
            driver.findElement(By.xpath("//*[text()='Create new account']")).click();
            driver.findElement(By.xpath("//*[text()='Sign Up']")).click();
        Thread.sleep(1000);

        driver.findElement(By.id("terms-link")).click();
        for(String str : driver.getWindowHandles()){
                driver.switchTo().window(str);            }
            driver.getCurrentUrl();
            String urlActual= driver.getCurrentUrl();

        driver.get("https://www.facebook.com/legal/terms/update");
        String urlTerms= driver.getCurrentUrl();
        assertEquals(urlTerms,urlActual);
        }

    @Test
    public void linkPrivacyTest() throws InterruptedException{
        driver.findElement(By.xpath("//*[text()='Create new account']")).click();
        driver.findElement(By.xpath("//*[text()='Sign Up']")).click();
        Thread.sleep(1000);

        driver.findElement(By.id("privacy-link")).click();
        for(String str : driver.getWindowHandles()){
            driver.switchTo().window(str);            }
        driver.getCurrentUrl();
        String urlPrivacyActual= driver.getCurrentUrl();

        driver.get("https://www.facebook.com/privacy/policy/?entry_point=data_policy_redirect&entry=0");
        String urlPrivacyTerms= driver.getCurrentUrl();
        assertEquals(urlPrivacyTerms,urlPrivacyActual);
    }
    @Test
    public void linkCookieTest() throws InterruptedException{
        driver.findElement(By.xpath("//*[text()='Create new account']")).click();
        driver.findElement(By.xpath("//*[text()='Sign Up']")).click();
        Thread.sleep(1000);

        driver.findElement(By.id("cookie-use-link")).click();
        for(String str : driver.getWindowHandles()){
            driver.switchTo().window(str);            }
        driver.getCurrentUrl();
        String urlCookieActual= driver.getCurrentUrl();

        driver.get("https://www.facebook.com/privacy/policies/cookies/?entry_point=cookie_policy_redirect&entry=0");
        String urlCookieTerms= driver.getCurrentUrl();
        assertEquals(urlCookieTerms,urlCookieActual);
    }
}