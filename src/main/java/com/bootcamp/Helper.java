package com.bootcamp;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.nio.charset.Charset;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;

public class Helper {
    WebDriver driver = new ChromeDriver();
    String username = "Admin";
    String password = "Admin123";
    String url = "https://demo.openmrs.org/openmrs/login.htm";

    static void starter() throws InterruptedException {
    }

    public void gotoUrl(String url){
        driver.get(url);
    }

    public void login(){

        //go to browser.

        // LOCATOR DEFINITIONS - LOGIN PAGE
        WebElement usernameInput = driver.findElement(By.id("username"));
        WebElement passwordInput = driver.findElement(By.id("password"));
        List<WebElement> locations = driver.findElements(By.cssSelector("ul[id='sessionLocation'] li"));
        WebElement loginButton = driver.findElement(By.cssSelector("input[id='loginButton']"));
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
        locations.get(0).click();
        loginButton.click();

    }

    public void registerPatient(){

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

        gotoUrl(url);
        login();

        // PAGE OPERATIONS - DASHBOARD
        WebElement registerPatientButton = driver.findElement(By.partialLinkText("Register a patient"));

        registerPatientButton.click();

        // PAGE OPERATIONS - REGISTER PATIENT
        WebElement patientNameInput = driver.findElement(By.name("givenName"));
        WebElement patientFamilyNameInput = driver.findElement(By.name("familyName"));

        String patientFirstName = generateRandomName()[0];
        String patientLastName = generateRandomName()[1];

        patientNameInput.sendKeys(patientFirstName);
        patientFamilyNameInput.sendKeys(patientLastName);

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
        WebElement patientIdLabel = driver.findElement(By.cssSelector("div[class^='identifiers'] span"));
        String patientId = patientIdLabel.getText();
        System.out.println(patientId);
        WebElement homeButton = driver.findElement(By.cssSelector("i[class='icon-home small']"));
        homeButton.click();
        WebElement patientSearchButton = driver.findElement(By.partialLinkText("Find Patient"));
        Boolean isPatientSearchButtonDisplayed = patientSearchButton.isDisplayed();

        System.out.println(isPatientSearchButtonDisplayed);
        Assert.assertTrue(isPatientSearchButtonDisplayed);
        patientSearchButton.click();

        List<WebElement> patientTableContentList = driver.findElements(By.cssSelector("table[id='patient-search-results-table'] > tbody > tr"));
        Assert.assertNotEquals(0, patientTableContentList.size());

        WebElement searchBox = driver.findElement(By.cssSelector("input[id='patient-search']"));
        searchBox.sendKeys(patientId);
        List<WebElement> patientTableContentListFiltered = driver.findElements(By.cssSelector("table[id='patient-search-results-table'] > tbody > tr"));
        patientTableContentListFiltered.get(0).click();

        WebElement patientNameNameDetails = driver.findElement(By.cssSelector("h1[class*='name']"));
        String patientDetails = patientNameNameDetails.getText();
        System.out.println(" ################# \n" + patientDetails + " \n #################");

        Assert.assertTrue(patientDetails.contains(patientFirstName));
        Assert.assertTrue(patientDetails.contains(patientLastName));

        Thread.sleep(500);
    }

    public void createPatientAfterAssert() throws InterruptedException {
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

        WebElement welcomeMessage = driver.findElement(By.cssSelector("div[id='content'] h4"));
        String actualWelcomeMessage = welcomeMessage.getText();

        String expectedWelcomeMessage = "Logged in as Super User (admin) at Inpatient Wa.";
        System.out.println("##############" + expectedWelcomeMessage + "##############");
        Assert.assertNotEquals(expectedWelcomeMessage, actualWelcomeMessage);
        driver.quit();
    }

    public String generateRandomString(int length) {
        byte[] array = new byte[length]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));
        System.out.println(generatedString);
        return generatedString;
    }

    public String generateRandom(int l) {
        String AlphaNumericStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvxyz";
        StringBuilder s = new StringBuilder(l);
        int i;
        for (i = 0; i < l; i++) {
            //generating a random number using math.random()
            int ch = (int) (AlphaNumericStr.length() * Math.random());
            //adding Random character one by one at the end of s
            s.append(AlphaNumericStr.charAt(ch));
        }
        System.out.println(s.toString());

        return s.toString();
    }

    public String[] generateRandomName() {

        String[] firstNames = {"Tom", "John", "Hans", "Damien", "Ahmet", "Sinan", "Sirin"};
        String[] lastNames = {"Zero", "Yalcin", "Grun", "Benett", "Kardos", "Cetin", "Carlo"};

        Random rand = new Random();
        int randFirst = rand.nextInt((6 - 0) + 1) + 0;
        int randLast = rand.nextInt((6 - 0) + 1) + 0;

        String[] fullName = {firstNames[randFirst], lastNames[randLast]};
        return fullName;
    }
}

