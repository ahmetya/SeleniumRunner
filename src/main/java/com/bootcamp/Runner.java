package com.bootcamp;

import org.openqa.selenium.*;
import java.util.List;

//new comment line
public class Runner {
    private static List<WebElement> userInputFields;

    public static void main(String[] args) throws InterruptedException {

        Helper help = new Helper();
        help.callTest();

        // Comment for this line ######## now changed
        // this line is just for bcl_ahmet branch

        help.createPatient();
        help.generateRandom(5);
        String[] fullName = help.generateRandomName();
        System.out.println(help.generateRandomName()[0] + " " + help.generateRandomName()[1]);
        Thread.sleep(500);

    }
}