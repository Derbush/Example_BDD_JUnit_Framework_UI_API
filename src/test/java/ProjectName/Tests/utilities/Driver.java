package ProjectName.Tests.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Driver {

    private Driver() {
    }

    private static InheritableThreadLocal<WebDriver> driverPool = new InheritableThreadLocal<>();


    public static WebDriver getDriver() {
        if (driverPool.get() == null) {
            String browser = ConfigurationReader.getProperties("browser");
            browser = browser.trim().toLowerCase();

            switch (browser) {
                case "chrome":
                     WebDriverManager.chromedriver().setup();
                   // ChromeOptions options = new ChromeOptions();
                   // options.addArguments("--remote-allow-origins=*");
                   // driverPool.set(new ChromeDriver(options));
                    driverPool.set(new ChromeDriver());
                    driverPool.get().manage().deleteAllCookies();
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;
                case "firefox":
                    WebDriverManager.firefoxdriver().setup();
                 //   driverPool.set(new FirefoxDriver());
                    driverPool.set(new FirefoxDriver());
                    driverPool.get().manage().deleteAllCookies();
                    driverPool.get().manage().window().maximize();
                    driverPool.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                    break;

            }
        }
        return  driverPool.get();
    }

    public static void closeDriver() {
        if (driverPool.get() != null) {
            driverPool.get().quit();
            driverPool.remove();
        }

    }
}
