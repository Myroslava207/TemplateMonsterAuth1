package selenium.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
    }
     By EmailFiled =  By.xpath("//input[@class ='text-field__input field-style']");
     By ContinueButton = By.xpath("//span[@id = 'id-index-continue-button']");
     By ErrorMessagePopup1 = By.xpath("//span[text() = 'Please specify a valid email']");
     By ErrorMessagePopup2 = By.xpath("//span[text() = 'Please enter Your email']");
     By MessageAboutExistedAccount = By.xpath("//span[text() = 'You were registered with your Facebook account.']");

    public void EnterEmail(String email){
        driver.findElement(EmailFiled).sendKeys(email);
    }
    public void ClickContinue(){
        driver.findElement(ContinueButton).click();
    }
    public void ErrorPopupDisplayed(){
        driver.findElement(ErrorMessagePopup1).isDisplayed();
    }
    public void ErrorPopupGetText(){
        driver.findElement(ErrorMessagePopup1).getText();
    }
    public void WaitErrorPopupByLogin(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(
                ErrorMessagePopup1));
    }
    public void WaitErrorPopupByLogin2(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(
                ErrorMessagePopup2));
    }
    public void WaitMessageAboutExistedAccount(){
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(
                MessageAboutExistedAccount));
    }
    }

