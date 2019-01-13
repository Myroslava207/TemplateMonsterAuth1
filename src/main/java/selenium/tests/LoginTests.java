package selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Sleeper;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.*;

import javax.xml.xpath.XPath;
import java.sql.Driver;

public class LoginTests {
    WebDriver driver;
    LoginPage loginPage;

    @BeforeTest
    public void SetUp(){
        System.setProperty("webdriver.chrome.driver", "C:\\Chromedriver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://account.templatemonster.com/auth/#/");
    }

    @Test
    public void InvalidData(){
        loginPage = new LoginPage(driver);
        loginPage.EnterEmail("example@dm");
        loginPage.ClickContinue();
        loginPage.WaitErrorPopupByLogin();
        Assert.assertTrue(driver.findElement(By.xpath("//span[text() = 'Please specify a valid email']")).isDisplayed());
        Assert.assertEquals(driver.findElement(
               By.xpath("//span[text() = 'Please specify a valid email']")).getText(), "Please specify a valid email" );
    }

    @Test
    public void EmptyEmailField(){

        loginPage = new LoginPage(driver);
        loginPage.ClickContinue();
        loginPage.WaitErrorPopupByLogin2();
        Assert.assertTrue(driver.findElement(By.xpath("//span[text() = 'Please enter Your email']")).isDisplayed());
        Assert.assertEquals( driver.findElement(
                By.xpath("//span[text() = 'Please enter Your email']")).getText(), "Please enter Your email" );
    }

    @Test
    public void ExistEmail(){
        loginPage = new LoginPage(driver);
        loginPage.EnterEmail("Myroslawa95@gmail.com");
        loginPage.ClickContinue();
        loginPage.WaitMessageAboutExistedAccount();
        Assert.assertTrue(driver.findElement(By.xpath("//span[text() = 'You were registered with your Facebook account.']")).isDisplayed());
        Assert.assertTrue(driver.findElement(By.xpath("//span[@id = 'id-general-facebook-button']")).isDisplayed());
    }

    @AfterTest
    public void TearDown(){
        driver.quit();
    }
}
