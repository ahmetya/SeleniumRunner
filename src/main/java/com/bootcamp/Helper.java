package com.bootcamp;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.junit.Assert;

public class Helper {
    static void starter() throws InterruptedException {
    }
    public void callTest() throws InterruptedException {

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--verbose", "--headless", "--disable-web-security", "--ignore-certificate-errors", "--allow-running-insecure-content", "--allow-insecure-localhost", "--no-sandbox", "--disable-gpu");

        WebDriver driver = new ChromeDriver(options);
        driver.get("https://www.google.com");

        WebElement rejectButton = driver.findElement(By.cssSelector("#W0wltc > div"));
        WebElement searchField = driver.findElement(By.name("q"));
        WebElement searchButton = driver.findElement(By.cssSelector("div[class=\"FPdoLc lJ9FBc\"] > center > input[value=\"Google Search\"][role=\"button\"] "));


        rejectButton.click();
        searchField.sendKeys("Boston Coders Land");
        searchButton.click();


        driver.getPageSource().contains("Some text to look for");

        driver.manage().window().maximize();
        driver.getTitle();
        driver.getCurrentUrl();

        Dimension dim = new Dimension(1000, 1200);
        driver.manage().window().setSize(dim);

        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().setScriptTimeout(15, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1024, 768));

        WebElement n = driver.findElement(By.partialLinkText("Refund"));
        //check if element visible
        boolean t = driver.findElement(By.partialLinkText("Refund")).isDisplayed();
        if (t) {
            System.out.println("Element is dispalyed");
        } else {
            System.out.println("Element is not dispalyed");
        }

        int ta = driver.findElements(By.partialLinkText("Refund")).size();
        if (ta > 0) {
            System.out.println("Element is present");
        } else {
            System.out.println("Element is not present");
        }

        driver.get("https://www.tutorialspoint.com/selenium/selenium_automation_practice.htm");
        WebElement chk = driver.findElement(By.xpath("//input[@type='radio']"));

        //div[id^="d"]


        //go to browser.
        driver.get("https://www.google.com");
        driver.navigate().to("https://seleniumatfingertips.wordpress.com/selenium-webdriver/");
        driver.navigate().back();
        driver.navigate().refresh();
        driver.navigate().forward();

        String pageUrl = driver.getCurrentUrl();
        System.out.println(pageUrl);
        String pageTitle = driver.getTitle();
        System.out.println(pageTitle);

        // WebElement usernameInput = driver.findElement(By.name("username"));
        // WebElement usernameInput = driver.findElement(By.id("username"));
        // WebElement usernameInput = driver.findElement(By.cssSelector("input[id='username']"));
        // WebElement usernameInput = driver.findElement(By.cssSelector("html > body > div > div:nth-child(3) > div > div > div > form > fieldset > p:nth-child(2) >  input"));
        // WebElement usernameInput = driver.findElement(By.xpath("//*[@id='password']"));

        // class="form-control form-control-sm form-control-lg form-control-md"

        List<WebElement> userInputFields = driver.findElements(By.cssSelector("input[class='form-control form-control-sm form-control-lg form-control-md']"));
        userInputFields.get(1).sendKeys("username");
        Thread.sleep(2000);
        userInputFields.get(1).clear();
        Thread.sleep(2000);
        driver.manage().window().maximize();
        driver.manage().window().minimize();

        Dimension dimension = new Dimension(1200, 200);
        driver.manage().window().setSize(dimension);

        Point point = driver.manage().window().getPosition();

        System.out.println(point.x);
        System.out.println(point.y);

        // usernameInput.sendKeys("username");
        // usernameInput.sendKeys("bostoncodersland");
        // label[for="username"]

        String elementText = driver.findElement(By.cssSelector("label[for='username']")).getText();
        System.out.println(elementText + "  ###################");

        String elementTagName = userInputFields.get(0).getTagName();
        System.out.println(elementTagName + "  ###################");

        String fontSize = userInputFields.get(0).getCssValue("font-size");
        System.out.println(fontSize + "  ###################");

        Boolean displayStatus = userInputFields.get(0).isDisplayed();
        System.out.println(displayStatus + "  ###################");

        Boolean enableStatus = userInputFields.get(0).isEnabled();
        System.out.println(enableStatus + "  ###################");

        Boolean selectStatus = userInputFields.get(1).isSelected();
        System.out.println(enableStatus + "  ###################");

        Thread.sleep(5000);
    }
    public void createPatient() throws InterruptedException {

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
        Assert.assertEquals(okIconsDisplayed, okIconsDisplayed);


        WebElement phoneNumberInput = driver.findElement(By.name("phoneNumber"));

        int phoneNumber = rand.nextInt((9999 - 1000) + 1) + 1000;
        phoneNumberInput.sendKeys("+356 9978" + phoneNumber);
        nextButton.click();

        String relativeType = "Parent";

        WebElement relativeSelect = driver.findElement(By.cssSelector("select[id='relationship_type'] option[data-val='" + relativeType + "']"));

        WebElement relativeName = driver.findElement(By.cssSelector("input[placeholder='Person Name']"));
        relativeName.sendKeys("Parent Zero");
        nextButton.click();

        WebElement submitButton = driver.findElement(By.id("submit"));
        submitButton.click();

        Thread.sleep(5000);
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
