package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;

public class LoginTests extends BasicTest{

//    Test #1: Visits the login page
//    Koraci:
//    Postaviti EN jezik stranice
//    Klik na login dugme iz navigacije
//    Verifikovati da se u url-u stranice javlja ruta /login

    @Test (priority = 1)
    public void visitLoginPage() throws InterruptedException {
        this.driver.get(baseUrl);
        navPage.getLanguageButton().click();
        navPage.getLanguageENButton().click();
        navPage.getLoginButton().click();

        Thread.sleep(1000);

        Assert.assertEquals(this.driver.getCurrentUrl(),
                baseUrl + "/login",
                "[ERROR] The URL does not contain /login part.");
    }

    @Test (priority = 2)
    public void checkInputTypes (){
        navPage.getLoginButton().click();

        Assert.assertEquals(loginPage.getEmailInput().getAttribute("type"),
                "email",
                "[ERROR] Attributes does not contain type 'email'.");

        Assert.assertEquals(loginPage.getPasswordInput().getAttribute("type"),
                "password",
                "[ERROR] Attributes does not contain type 'password'.");
    }
    @Test(priority = 3)
    public void displayErrorsWhenUserDoesNotExist (){
//        email: non-existing-user@gmal.com
//        password: password123
//        Koraci:
//        Klik na login dugme iz navigacije
//        Popuniti login formu podacima za logovanje
//        Klik na login dugme
//        Sacekati da popu za prikaz greske bude vidljiv
//        Verifikovati da greska sadrzi poruku User does not exists
//        Verifikovati da se u url-u stranice javlja /login ruta

        navPage.getLoginButton().click();

        loginPage.getEmailInput().sendKeys("non-existing-user@gmal.com");
        loginPage.getPasswordInput().sendKeys("password123");
        loginPage.getSubmitLoginButton().click();

        messagePopUpPage.waitForPopUpToBeVisible();

        Assert.assertEquals(this.driver.findElement(By.xpath("//div[contains(@role, 'status')]/ul/li")).getText(),
                "User does not exists",
                "[ERROR] Text does not contain 'User does not exists'.");

        Assert.assertEquals(this.driver.getCurrentUrl(),
                baseUrl + "/login",
                "[ERROR] This URL does not have /login.");
    }
    @Test(priority = 4)
    public void displayErrorsWhenPasswordIsWrong (){
//        Podaci:
//        email: admin@admin.com
//        password: password123
//        Koraci:
//        Klik na login dugme iz navigacije
//        Popuniti login formu podacima za logovanje
//        Klik na login dugme
//        Sacekati da popu za prikaz poruke bude vidljiv
//        Verifikovati da greska sadrzi poruku Wrong password
//        Verifikovati da se u url-u stranice javlja /login ruta

        navPage.getLoginButton().click();

        loginPage.getEmailInput().sendKeys("admin@admin.com");
        loginPage.getPasswordInput().sendKeys("password123");
        loginPage.getSubmitLoginButton().click();

        messagePopUpPage.waitForErrorPopUpToBeVisible();

        Assert.assertEquals(this.driver.findElement(By.xpath("//div[contains(@role, 'status')]/ul/li")).getText(),
                "Wrong password",
                "[ERROR] Text does not contain 'Wrong Password'.");

        Assert.assertEquals(this.driver.getCurrentUrl(),
                baseUrl + "/login",
                "[ERROR] This URL does not have /login.");
    }
    @Test (priority = 5)
    public void logIn () throws InterruptedException {
//        Podaci:
//        email: admin@admin.com
//        password: 12345
//        Koraci:
//        Klik na login dugme iz navigacije
//        Popuniti login formu podacima za logovanje
//        Verifikovati da se u url-u stranice javlja /home ruta

        navPage.getLoginButton().click();

        loginPage.getEmailInput().sendKeys("admin@admin.com");
        loginPage.getPasswordInput().sendKeys("12345");
        loginPage.getSubmitLoginButton().click();


        Thread.sleep(1500);

        Assert.assertEquals(this.driver.getCurrentUrl(),
                baseUrl + "/home",
                "[ERROR] This URL does not have /home.");

//        Assert.assertTrue(this.driver.getCurrentUrl().contains("/home"),
//                "[ERROR] This URL does not have /home.");
    }
    @Test (priority = 6)
    public void logOut (){
//        Koraci:
//        Verifikovati da je dugme logout vidljivo na stranici
//        Kliknuti na logout dugme

        Assert.assertTrue(navPage.getLogOutButton().isDisplayed(),
                "[ERROR] The element does not exists.");

        navPage.getLogOutButton().click();

    }

}
