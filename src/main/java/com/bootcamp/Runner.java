package com.bootcamp;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

public class Runner {
    private static List<WebElement> userInputFields;

    public static void main(String[] args) throws InterruptedException {

        Helper help = new Helper();
        // help.callTest();
        help.createPatient();



    }
}