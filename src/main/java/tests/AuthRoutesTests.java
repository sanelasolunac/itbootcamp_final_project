package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BasicTest{
    @Test (priority = 1)
    public void forbidsVisitsToHomeUrlIfNotAuthenticated(){
//        Koraci:
//        Ucitati /home stranu
//        Verifikovati da se u url-u stranice javlja ruta /login

        this.driver.get(baseUrl + "/home");

        Assert.assertTrue(this.driver.getCurrentUrl().contains("/login"),
                "[ERROR] The URL does not contain '/login'.");
    }
    @Test(priority = 2)
    public void forbidsVisitsToProfileUrlIfNotAuthenticated(){

        this.driver.get(baseUrl + "/profile");

        Assert.assertTrue(this.driver.getCurrentUrl().contains("/login"),
                "[ERROR] The URL does not contain '/login'.");
    }
    @Test (priority = 3)
    public void forbidsVisitsToAdminCitiesUrlIfNotAuthenticated (){

        this.driver.get(baseUrl + "/admin/users");

        Assert.assertTrue(this.driver.getCurrentUrl().contains("/login"),
                "[ERROR] The URL does not contain '/login'.");
    }
    @Test (priority = 4)
    public void forbidsVisitsToAdminUsersUrlIfNotAuthenticated(){

        this.driver.get(baseUrl + "/admin/cities");

        Assert.assertTrue(this.driver.getCurrentUrl().contains("/login"), "[ERROR] The URL does not contain '/login'.");

    }

}
