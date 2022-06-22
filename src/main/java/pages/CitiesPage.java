package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CitiesPage {
    private WebDriver driver;

    public CitiesPage(WebDriver driver) {
        this.driver = driver;
    }
    public WebElement getNewItemButton(){
        return this.driver.findElement(By.xpath("//button[contains(@class, 'btnNewItem')]"));
    }
    public WebElement getInputSearchButton(){
        return this.driver.findElement(By.id("search"));
    }
    public void waitForNewEditItemBoxToBeVisible(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'dlgNewEditItem')]")));
    }
//    metodu koja ceka da se dijalog za editovanje i kreiranje pojavi
//    VALJDA JE TO SAMO OVA JEDNA A NE DVE

//    metodu koja ceka da se dijalog za brisanje pojavi
//    save dugme iz dijalog za editovanje i kreiranje
//    delete dugme iz dijaloga za brisanje


    public void waitForDeleteBoxToBeVisible(){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(@class, 'v-dialog v-dialog--active')]")));
    }
    public WebElement getSaveButton (){
        return this.driver.findElement(By.xpath("//button[contains(@class, 'btnSave')]"));
    }
    public WebElement getDeleteButton(){
        return this.driver.findElement(By)
    }


}
