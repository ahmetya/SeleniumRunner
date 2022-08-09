package com.bootcamp;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Helper {
    public static void starter() throws InterruptedException {

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

        Dimension dimension = new Dimension(1200,200);
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


}
