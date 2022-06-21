package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class NavPage {
    private WebDriver driver;

    public NavPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getHomeLink (){
        return this.driver.findElement(By.xpath("//div[contains(@class, 'v-toolbar__items')]/a"));
    }
    public WebElement getAboutLink (){
        return  this.driver.findElement(By.xpath("//div[contains(@class, 'v-toolbar__items')]/a[2]"));
    }
    public WebElement getMyProfileButton(){
        return  this.driver.findElement(By.xpath("//a[contains(@class, 'btnProfile')]"));
    }
    public WebElement getAdminButton() {
        return this.driver.findElement(By.className("btnAdmin"));
    }
    public WebElement getCitiesButton(){
        return this.driver.findElement(By.id("list-item-214"));
    }
    public WebElement getUsersButton (){
        return this.driver.findElement(By.id("list-item-217"));
    }
    public WebElement getLogOutButton(){
        return this.driver.findElement(By.xpath("//button[contains(@class, 'btnLogout')]"));
    }
    public WebElement getLanguageButton(){
        return this.driver.findElement(By.xpath("//button[contains(@class, 'btnLocaleActivation')]"));
    }
    public WebElement getLanguageENButton(){
        return this.driver.findElement(By.xpath("//div[contains(@class, 'btnEN')]"));
    }
    public WebElement getLanguageESButton(){
        return this.driver.findElement(By.xpath("//div[contains(@class, 'btnES')]"));
    }
    public WebElement getLanguageFRButton(){
        return this.driver.findElement(By.xpath("//div[contains(@class, 'btnFR')]"));
    }
    public WebElement getLanguageCNButton(){
        return this.driver.findElement(By.xpath("//div[contains(@class, 'btnCN')]"));
    }
    public WebElement getLoginButton(){
        return this.driver.findElement(By.xpath("//a[contains(@class, 'btnLogin')]"));
    }
    public WebElement getSignUpButton(){
        return this.driver.findElement(By.xpath(""));
    }
// NISI URADILA OVO JER TE JE BUNILO PREKO CEGA DA POVUCES LOKATORE
}
