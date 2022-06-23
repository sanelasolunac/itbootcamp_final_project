package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class SignUpTests extends BasicTest{
    @Test(priority = 1)
    public void visitsTheSignupPage(){
//        Koraci:
//        Klik na sign up dugme iz navigacije
//        Verifikovati da se u url-u stranice javlja /signup ruta

        navPage.getSignUpButton().click();

        Assert.assertEquals(this.driver.getCurrentUrl(),
                baseUrl +"/signup",
                "[ERROR] The URL does not contain /signup.");
    }
    @Test(priority = 2)
    public void checksInputTypes() throws InterruptedException {
//        Koraci:
//        Klik na sign up dugme iz navigacije
//        Verifikovati da polje za unos emaila za atribut type ima vrednost email
//        Verifikovati da polje za unos lozinke za atribut type ima vrednost password
//        Verifikovati da polje za unos lozinke za potvrdu za atribut type ima vrednost password

        navPage.getSignUpButton().click();

        Thread.sleep(3000);

        Assert.assertEquals(signupPage.getInputEmail().getAttribute("type"),
                "email",
                "[ERROR] The attribute does not contain type 'email' .");
        Assert.assertEquals(signupPage.getInputPassword().getAttribute("type"),
                "password",
                "[ERROR] The attribute does not contain type 'password'.");
        Assert.assertEquals(signupPage.getConfirmPassword().getAttribute("type"),
                "password",
                "[ERROR] The attribute does not contain type 'password'." );
    }
    @Test (priority = 3)
    public void displaysErrorsWhenUserAlreadyExists (){
//        Podaci:
//        name: Another User
//        email: admin@admin.com
//        password: 12345
//        confirm password: 12345
//        Koraci:
//        Klik na sign up dugme iz navigacije
//        Verifikovati da se u url-u stranice javlja /signup ruta
//        Popuniti formu za registraciju podacima
//        Klik na sign up dugme
//        Sacekati da popu za prikaz poruke bude vidljiv
//        Verifikovati da greska sadrzi poruku E-mail already exists
//        Verifikovati da se u url-u stranice javlja /signup ruta


        navPage.getSignUpButton().click();

        Assert.assertEquals(this.driver.getCurrentUrl(),
                baseUrl +"/signup",
                "[ERROR] The URL does not contain /signup. ");

        signupPage.getInputName().sendKeys("Another User");
        signupPage.getInputEmail().sendKeys("admin@admin.com");
        signupPage.getInputPassword().sendKeys("12345");
        signupPage.getConfirmPassword().sendKeys("12345");

        signupPage.getSignMeUpButton().click();

        messagePopUpPage.waitForImportantPopUpToBeVisible();

        Assert.assertEquals(this.driver.findElement(By.xpath("//div[contains(@role, 'status')]/ul/li")).getText(),
                "E-mail already exists",
                "[ERROR] Text does not contain 'E-mail already exists'.");

        Assert.assertEquals(this.driver.getCurrentUrl(),
                baseUrl+ "/signup",
                "[ERROR] The URL does not contain /signup.");

    }
    @Test(priority = 4)
    public void signUp() throws InterruptedException {
//        Podaci:
//        name: Ime i prezime polaznika
//        email template: ime.prezime@itbootcamp.rs
//        password: 12345
//        confirm password: 12345
//        Koraci:
//        Klik na sign up dugme iz navigacije
//        Popuniti formu podacima za registraciju
//        Klik na sign up dugme
//        Ucitati stranicu /home
//        Verifikovati da dijalog za obavestenje sadrzi tekst IMPORTANT: Verify your account
//        Kliknuti na Close dugme iz dijaloga
//        Kliknuti na logout

        navPage.getSignUpButton().click();

        signupPage.getInputName().sendKeys("Sanela Kostic Solunacc");
        signupPage.getInputEmail().sendKeys("sanela.kosticsoll@itbootcamp.rs");
        signupPage.getInputPassword().sendKeys("12345");
        signupPage.getConfirmPassword().sendKeys("12345");
        signupPage.getSignMeUpButton().click();

        Thread.sleep(1500);

        Assert.assertEquals(this.driver.findElement(By.xpath("//div[contains(@class, 'v-card__title headline')]")).getText(),
                "IMPORTANT: Verify your account",
                "[ERROR] The popUp does not contain text 'IMPORTANT: Verify your account'!");

        Thread.sleep(1500);

        signupPage.getCloseButton().click();

        navPage.getLogOutButton().click();
    }
}
