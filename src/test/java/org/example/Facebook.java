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

public class Facebook {

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
    public void homePageURLTest() {

        String actualURL = driver.getCurrentUrl();
        assertEquals(HOME_PAGE_URL, actualURL, "error");
    }

    @Test
    public void signUpTest() throws InterruptedException {
        WebElement signUpElement = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div/div[2]/div/div[1]/form/div[5]/a"));
        assertNotNull(signUpElement);
        signUpElement.click();

        Thread.sleep(1000);

        WebElement firstNameElement = driver.findElement(By.xpath("//input[@name='firstname']"));
        assertNotNull(firstNameElement);
        firstNameElement.sendKeys("Nick");
        String firstNameValue = firstNameElement.getAttribute("value");
        assertEquals("Nick", firstNameValue);
        firstNameElement.clear();


        WebElement lastNameElement = driver.findElement(By.xpath("//input[@name='lastname']"));
        assertNotNull(lastNameElement);
        lastNameElement.sendKeys("Smith");
        String lastNameValue = lastNameElement.getAttribute("value");
        assertEquals("Smith", lastNameValue);

        WebElement emailElement = driver.findElement(By.xpath("//input[@name='reg_email__']"));
        assertNotNull(emailElement);
        emailElement.sendKeys("eee@gmail.com");
        String emailValue = emailElement.getAttribute("value");
        assertEquals("eee@gmail.com", emailValue);

        WebElement emailConfElement = driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
        assertNotNull(emailElement);
        emailConfElement.sendKeys("eee@gmail.com");
        String emailConfValue = emailElement.getAttribute("value");
        assertEquals("eee@gmail.com", emailConfValue);

        WebElement passElement = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
        assertNotNull(passElement);
        passElement.sendKeys("123456");
        String passValue = passElement.getAttribute("value");
        assertEquals("123456", passValue);

        WebElement birthDateElement = driver.findElement(By.id("year"));
        Select select = new Select(birthDateElement);
        select.selectByVisibleText("2004");

        WebElement radioButtonElement = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[1]/form/div[1]/div[7]/span/span[1]/input"));
        radioButtonElement.click();

        WebElement webSubmitElement = driver.findElement(By.xpath("//button[@name='websubmit']"));
        assertNotNull(webSubmitElement);
        passElement.click();

    }

    @Test
    public void longName() throws InterruptedException {
        WebElement signUpElement = driver.findElement
                (By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div/div[2]/div/div[1]/form/div[5]/a"));
        assertNotNull(signUpElement);
        signUpElement.click();

        Thread.sleep(1000);
        WebElement firstNameElement = driver.findElement(By.xpath("//input[@name='firstname']"));
        String longName = "Stretching nearly 100 kilometres, the Verdon Gorg";
        firstNameElement.sendKeys(longName);
        String longValue = firstNameElement.getAttribute("value");
        assertEquals("Stretching nearly 100 kilometres, the Verdon Gorg", longValue);

        WebElement lastNameElement = driver.findElement(By.xpath("//input[@name='lastname']"));
        assertNotNull(lastNameElement);
        lastNameElement.sendKeys("Smith");

        WebElement emailElement = driver.findElement(By.xpath("//input[@name='reg_email__']"));
        emailElement.sendKeys("eee@gmail.com");
        WebElement emailConfElement = driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
        emailConfElement.sendKeys("eee@gmail.com");


        WebElement passElement = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
        passElement.sendKeys("12345678qa");

        WebElement birthDateElement = driver.findElement(By.id("year"));
        Select select = new Select(birthDateElement);
        select.selectByVisibleText("2004");

        WebElement radioButtonElement = driver.findElement
                (By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[1]/form/div[1]/div[7]/span/span[1]/input"));
        radioButtonElement.click();

        WebElement webSubmitElement = driver.findElement(By.xpath("//button[@name='websubmit']"));
        webSubmitElement.click();

        if (driver.getCurrentUrl().equals("https://www.facebook.com/")) {
            System.out.println("There are more then 50 letters in the Name field ");
        }
    }

    @Test
    public void unvalidEmail() throws InterruptedException {
        WebElement signUpElement = driver.findElement
                (By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div/div[2]/div/div[1]/form/div[5]/a"));
        assertNotNull(signUpElement);
        signUpElement.click();

        Thread.sleep(1000);
        WebElement firstNameElement = driver.findElement(By.xpath("//input[@name='firstname']"));
        firstNameElement.sendKeys("Nick");
        String longValue = firstNameElement.getAttribute("value");
        assertEquals("Nick", longValue);

        WebElement lastNameElement = driver.findElement(By.xpath("//input[@name='lastname']"));
        assertNotNull(lastNameElement);
        lastNameElement.sendKeys("Smith");

        WebElement emailElement = driver.findElement(By.xpath("//input[@name='reg_email__']"));
        emailElement.sendKeys("eeegmail.com");

        WebElement passElement = driver.findElement(By.xpath(
                "//input[@name='reg_passwd__']"));
        passElement.sendKeys("12345678qa");

        WebElement birthDateElement = driver.findElement(By.id("year"));
        Select select = new Select(birthDateElement);
        select.selectByVisibleText("2004");

        WebElement radioButtonElement = driver.findElement
                (By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[1]/form/div[1]/div[7]/span/span[1]/input"));
        radioButtonElement.click();

        WebElement webSubmitElement = driver.findElement(By.xpath("//button[@name='websubmit']"));
        webSubmitElement.click();

        if (driver.getCurrentUrl().equals("https://www.facebook.com/")) {
            System.out.println("There are more then 50 letters in the Name field ");
        }
    }

    @Test
    public void specCharTest() throws InterruptedException {
        WebElement signUpElement = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div/div[2]/div/div[1]/form/div[5]/a"));
        assertNotNull(signUpElement);
        signUpElement.click();

        Thread.sleep(1000);

        WebElement firstNameElement = driver.findElement(By.xpath("//input[@name='firstname']"));
        assertNotNull(firstNameElement);
        firstNameElement.sendKeys("!@#$%");
        String firstNameValue = firstNameElement.getAttribute("value");
        assertEquals("!@#$%", firstNameValue);


        WebElement lastNameElement = driver.findElement(By.xpath("//input[@name='lastname']"));
        assertNotNull(lastNameElement);
        lastNameElement.sendKeys("Smith");
        String lastNameValue = lastNameElement.getAttribute("value");
        assertEquals("Smith", lastNameValue);

        WebElement emailElement = driver.findElement(By.xpath("//input[@name='reg_email__']"));
        assertNotNull(emailElement);
        emailElement.sendKeys("eee@gmail.com");
        String emailValue = emailElement.getAttribute("value");
        assertEquals("eee@gmail.com", emailValue);

        WebElement emailConfElement = driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
        assertNotNull(emailElement);
        emailConfElement.sendKeys("eee@gmail.com");
        String emailConfValue = emailElement.getAttribute("value");
        assertEquals("eee@gmail.com", emailConfValue);

        WebElement passElement = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
        assertNotNull(passElement);
        passElement.sendKeys("123456");
        String passValue = passElement.getAttribute("value");
        assertEquals("123456", passValue);

        WebElement webSubmitElement = driver.findElement(By.xpath("//button[@name='websubmit']"));
        assertNotNull(webSubmitElement);
        passElement.click();

        if (driver.getCurrentUrl().equals("https://www.facebook.com/")) {
            System.out.println("Error");
        }
    }

    @Test
    public void spaceTest() throws InterruptedException {
        WebElement signUpElement = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div/div[2]/div/div[1]/form/div[5]/a"));
        assertNotNull(signUpElement);
        signUpElement.click();

        Thread.sleep(1000);

        WebElement firstNameElement = driver.findElement(By.xpath("//input[@name='firstname']"));
        assertNotNull(firstNameElement);
        firstNameElement.sendKeys("          ");

        WebElement lastNameElement = driver.findElement(By.xpath("//input[@name='lastname']"));
        lastNameElement.sendKeys("Smith");

        WebElement emailElement = driver.findElement(By.xpath("//input[@name='reg_email__']"));
        assertNotNull(emailElement);
        emailElement.sendKeys("eee@gmail.com");

        WebElement emailConfElement = driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']"));
        assertNotNull(emailElement);
        emailConfElement.sendKeys("eee@gmail.com");

        WebElement passElement = driver.findElement(By.xpath("//input[@name='reg_passwd__']"));
        assertNotNull(passElement);
        passElement.sendKeys("123456");

        WebElement webSubmitElement = driver.findElement(By.xpath("//button[@name='websubmit']"));
        assertNotNull(webSubmitElement);
        passElement.click();
        if (driver.getCurrentUrl().equals("https://www.facebook.com/")) {
            System.out.println("Error");
        }
    }

    @Test
    public void customTest() throws InterruptedException {
        WebElement signUpElement = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div/div[2]/div/div[1]/form/div[5]/a"));
        assertNotNull(signUpElement);
        signUpElement.click();

        Thread.sleep(1000);

        WebElement radioButtonCustomElement = driver.findElement
                (By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[1]/form/div[1]/div[7]/span/span[3]/input"));
        radioButtonCustomElement.click();

        WebElement genderElement = driver.findElement(By.xpath("/html/body/div[3]/div[2]/div/div/div[2]/div/div/div[1]/form/div[1]/div[8]/div[1]/select"));
        assertNotNull(genderElement);
        genderElement.click();
        Select sheElement = new Select(genderElement);
        sheElement.selectByVisibleText("She: \"Wish her a happy birthday!\"");
        assertNotNull(sheElement);

        Select heElement = new Select(genderElement);
        heElement.selectByVisibleText("He: \"Wish him a happy birthday!\"");
        assertNotNull(heElement);

        Select theyElement = new Select(genderElement);
        theyElement.selectByVisibleText("They: \"Wish them a happy birthday!\"");
        assertNotNull(theyElement);

        WebElement genderOptionalElement = driver.findElement(By.xpath("//input[@name='custom_gender']"));
        assertNotNull(genderOptionalElement);
    }

    @ParameterizedTest
    @ValueSource(strings = {"Smith", "Long There are more then 50 letters in the Name field ", "!@#$%^&*()_+=-~`:;'<>?/.,'", "         "})
    public void paramTest(String testName) throws InterruptedException {
        WebElement signUpElement = driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div/div/div[2]/div/div[1]/form/div[5]/a"));
        assertNotNull(signUpElement);
        signUpElement.click();
        Thread.sleep(1000);

        WebElement firstNameElement = driver.findElement(By.xpath("//input[@name='firstname']"));
        firstNameElement.clear();
        firstNameElement.sendKeys(testName);
        assertEquals(testName, firstNameElement.getAttribute("value"));
    }
}