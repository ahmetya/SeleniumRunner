package com.bootcamp;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Runner {
    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.get("https://www.google.com");

        WebElement rejectButton = driver.findElement(By.cssSelector("#W0wltc > div"));
        WebElement searchField = driver.findElement(By.name("q"));
        WebElement searchButton = driver.findElement(By.cssSelector("div[class=\"FPdoLc lJ9FBc\"] > center > input[value=\"Google Search\"][role=\"button\"] "));

        rejectButton.click();
        searchField.sendKeys("Boston Coders Land");
        searchButton.click();


    }
}