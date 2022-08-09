package com.bootcamp;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;
import java.util.Random;

public class Runner {
    private static List<WebElement> userInputFields;

    public static void main(String[] args) throws InterruptedException {
        WebDriver driver = new ChromeDriver();
        //go to browser.
        driver.get("https://demo.openmrs.org/openmrs/login.htm");

        // WebElement Find

        String username = "Admin";
        String password = "Admin123";

        // LOCATOR DEFINITIONS - LOGIN PAGE
        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        List<WebElement> locations = driver.findElements(By.cssSelector("ul[id='sessionLocation'] li"));
        WebElement loginButton = driver.findElement(By.cssSelector("input[id='loginButton']"));

        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        locations.get(0).click();
        loginButton.click();

        // PAGE OPERATIONS - DASHBOARD
        WebElement registerPatientButton = driver.findElement(By.partialLinkText("Register a patient"));

        registerPatientButton.click();

        // PAGE OPERATIONS - REGISTER PATIENT
        WebElement patientNameInput = driver.findElement(By.name("givenName"));
        WebElement patientFamilyNameInput = driver.findElement(By.name("familyName"));

        patientNameInput.sendKeys("Patient");
        patientFamilyNameInput.sendKeys("Zero");

        WebElement nextButton = driver.findElement(By.id("next-button"));
        nextButton.click();

        List<WebElement> genderSelectBox = driver.findElements(By.cssSelector("select[id='gender-field'] option"));
        genderSelectBox.get(0).click();
        nextButton.click();

        WebElement birthDateDay = driver.findElement(By.id("birthdateDay-field"));
        WebElement birthDateYear = driver.findElement(By.id("birthdateYear-field"));

        Random rand = new Random();
        int birthDay = rand.nextInt((31 - 1) + 1) + 1;
        int year = rand.nextInt((2000 - 1900) + 1) + 1900;
        int month = rand.nextInt((12 - 1) + 1) + 1;

        WebElement birthDateMonth = driver.findElement((By.cssSelector("select[id='birthdateMonth-field'] > option[value='" + month + "']")));

        birthDateDay.sendKeys("" + birthDay);
        birthDateYear.sendKeys("" + year);
        birthDateMonth.click();
        nextButton.click();

        WebElement postalCodeInput = driver.findElement(By.cssSelector("input[id='postalCode']"));
        postalCodeInput.sendKeys("34000");
        nextButton.click();

        List<WebElement> okIcons = driver.findElements(By.cssSelector("i[class='icon-ok']"));
        Boolean okIconsDisplayed = okIcons.get(1).isDisplayed();
        System.out.println(okIconsDisplayed + "##############");

        WebElement phoneNumberInput = driver.findElement(By.name("phoneNumber"));

        int phoneNumber = rand.nextInt((9999 - 1000) + 1) + 1000;
        phoneNumberInput.sendKeys("+356 9978" + phoneNumber);
        nextButton.click();

        String relativeType = "Parent";

        WebElement relativeSelect = driver.findElement(By.cssSelector("select[id='relationship_type'] option[data-val='" + relativeType +"']"));

        WebElement relativeName = driver.findElement(By.cssSelector("input[placeholder='Person Name']"));
        relativeName.sendKeys("Parent Zero");
        nextButton.click();

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        Thread.sleep(500000);
        driver.quit();

        // HOMEWORK
        /*  Register Patient ID in a variable on the top right corner of page
            Go to main dashboard
            Go to search patient
            Input patient id to search box
            Execute search
         */
    }
}