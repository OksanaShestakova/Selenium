import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverShared {
    private static WebDriver webDriver;
    public static WebDriver getWevDriver(){
        if (webDriver==null){
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();}

        return webDriver;
    }
public static void closeDriver(){
        if (webDriver !=null){
            webDriver.quit();
            webDriver=null;
        }
}
}
