package tests;

import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BasicTest{
    @Test(priority = 1)
    public void visitsTheAdminCitiesPageAndListCities() throws InterruptedException {
//        Podaci:
//        admin email: admin@admin.com
//        admin password: 12345
//        Koraci:
//        Klik na sign up dugme iz navigacije
//        Prijaviti se na sistem admin kredencijalima
//        Klik na admin dugme iz navigacije
//        Klik na Cities dugme iz padajuceg Admin menija
//        Verifikovati da se u url-u stranice javlja /admin/cities ruta

        navPage.getLoginButton().click();

        loginPage.getEmailInput().sendKeys("admin@admin.com");
        loginPage.getPasswordInput().sendKeys("12345");
        loginPage.getSubmitLoginButton().click();

        navPage.getAdminButton().click();

        Thread.sleep(1000);

        navPage.getCitiesButton().click();

        Assert.assertEquals(this.driver.getCurrentUrl(),
                baseUrl + "/admin/cities",
                "[ERROR] The URL does not contain '/admin/cities'");

    }
    @Test(priority = 2)
    public void checksInputTypesForCreateEditNewCity() throws InterruptedException {
        //    Koraci:
//    Klik na admin dugme iz navigacije
//    Klik na Cities dugme iz padajuceg Admin menija
//    Kliknuti na New Item dugme
//    Sacekati da se dijalog za kreiranje i editovanje grada pojavi
//    Verifikovati da polje za unos grada za atribut type ima tekst text


        navPage.getAdminButton().click();
        navPage.getCitiesButton().click();

        citiesPage.getNewItemButton().click();
        citiesPage.waitForNewEditItemBoxToBeVisible();

        Thread.sleep(1500);


        Assert.assertEquals(citiesPage.getNewItemInput().getAttribute("type"),
                "text",
                "[ERROR] The input button does not contain attribute 'text'.");
    }
    @Test (priority = 3)
    public void createNewCity() throws InterruptedException {
//        Podaci:
//        city: [Ime i prezime polaznika]’s city
//        Koraci:
//
//
//        Klik na admin dugme iz navigacije
//        Klik na Cities dugme iz padajuceg Admin menija
//        Kliknuti na New Item dugme
//        Sacekati da se dijalog za kreiranje i editovanje grada pojavi
//        Uneti ime grada u polje
//        Kliknuti na Save dugme
//        Sacekati da popu za prikaz poruke bude vidljiv
//        Verifikovati da poruka sadrzi tekst Saved successfully

        navPage.getAdminButton().click();
        navPage.getCitiesButton().click();

        citiesPage.getNewItemButton().click();
        citiesPage.waitForNewEditItemBoxToBeVisible();
        citiesPage.getNewItemInput().sendKeys("Graz");
        citiesPage.getSaveButton().click();
        citiesPage.waitForSuccessfullyPopUpToBeVisible();

        Thread.sleep(1500);

        Assert.assertTrue(messagePopUpPage.getMessageTextFromSuccesPopUp().getText().contains("Saved successfully"),
                "[ERROR] The pop up does not contain text 'Saved successfully'.");



    }

    @Test(priority = 4)
    public void editCity() throws InterruptedException {
//        Podaci:
//        old city name: [Ime i prezime polaznika]’s city
//        new city name: [Ime i prezime polaznika]’s city Edited
//        Koraci:
//        Klik na admin dugme iz navigacije
//        Klik na Cities dugme iz padajuceg Admin menija
//        U polje za pretragu uneti staro ime grada
//        Sacekati da broj redova u tabeli bude 1
//        Kliknuti na dugme Edit iz prvog reda
//        Uneti novo ime za grad
//        Kliknuti na dugme Save
//        Sacekati da popu za prikaz poruke bude vidljiv
//        Verifikovati da poruka sadrzi tekst Saved successfully

        navPage.getAdminButton().click();
        navPage.getCitiesButton().click();

        citiesPage.getInputSearchButton().sendKeys("Graz");
        citiesPage.waitForNumbersOfRowsToBe(1);
        citiesPage.getEditButtonFromRow(1).click();
        citiesPage.getNewItemInput().click();

        Thread.sleep(1500);

        new Actions(driver)
                .keyDown(Keys.CONTROL)
                .sendKeys("a")
                .sendKeys(Keys.BACK_SPACE)
                .perform();


        citiesPage.getNewItemInput().sendKeys("");
        citiesPage.getNewItemInput().sendKeys("Bec");
        citiesPage.getSaveButton().click();



        citiesPage.waitForSuccessfullyPopUpToBeVisible();
        Assert.assertTrue(messagePopUpPage.getMessageTextFromSuccesPopUp().getText().contains("Saved successfully"),
                "[ERROR] The message from pop-up should be 'Saved successfully'" );

        Thread.sleep(2000);
    }
    @Test(priority = 5)
    public void searchCity() throws InterruptedException {


//    Podaci:
//    city name: [Ime i prezime polaznika]’s city Edited
//    Koraci:
//    Klik na admin dugme iz navigacije
//    Klik na Cities dugme iz padajuceg Admin menija
//    U polje za pretragu uneti staro ime grada
//    Sacekati da broj redova u tabeli bude 1
//    Verifikovati da se u Name koloni prvog reda nalazi tekst iz pretrage


        navPage.getAdminButton().click();
        navPage.getCitiesButton().click();

        citiesPage.getInputSearchButton().sendKeys("Bec");
        citiesPage.waitForNumbersOfRowsToBe(1);

        Thread.sleep(1500);

        Assert.assertTrue(citiesPage.getTableCell(1,2).getText().contains("Bec"),
                "[ERROR] The names do not match.");
    }
    @Test (priority = 6)
    public void  deleteCity (){
//        Podaci:
//        city name: [Ime i prezime polaznika]’s city Edited
//        Koraci:
//        Klik na admin dugme iz navigacije
//        Klik na Cities dugme iz padajuceg Admin menija
//        U polje za pretragu uneti staro ime grada
//        Sacekati da broj redova u tabeli bude 1
//        Verifikovati da se u Name koloni prvog reda nalazi tekst iz pretrage
//        Kliknuti na dugme Delete iz prvog reda
//        Sacekati da se dijalog za brisanje pojavi
//        Kliknuti na dugme Delete iz dijaloga
//        Sacekati da popu za prikaz poruke bude vidljiv
//        Verifikovati da poruka sadrzi tekst Deleted successfully

        navPage.getAdminButton().click();
        navPage.getCitiesButton().click();

        citiesPage.getInputSearchButton().sendKeys("Bec");
        citiesPage.waitForNumbersOfRowsToBe(1);

        Assert.assertTrue(citiesPage.getTableCell(1,2).getText().contains("Bec"),
                "[ERROR] The names do not match.");

        citiesPage.getDeleteButtonFromRow(1).click();
        citiesPage.waitForDeleteBoxToBeVisible();
        citiesPage.getDeleteButton().click();

        messagePopUpPage.waitForPopUpDeleteCityToBeVisible();

        Assert.assertTrue(messagePopUpPage.getElementsWithVisibleMessagesForCities().getText().contains("Deleted"),
                "[ERROR] City is not deleted");

    }
}
