package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BasicTest{

//    Test #1: Visits the login page
//    Koraci:
//    Postaviti EN jezik stranice
//    Klik na login dugme iz navigacije
//    Verifikovati da se u url-u stranice javlja ruta /login

    @Test
    public void visitLoginPage(){
        this.driver.get(baseUrl);
        navPage.getLanguageButton().click();
        navPage.getLanguageENButton().click();
        navPage.getLoginButton().click();

        Assert.assertEquals(this.driver.getCurrentUrl(),
                baseUrl + "/login",
                "[ERROR] The URL is not valid.");
    }
}
