package com.zerobank.stepdefinitions;

import com.zerobank.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;


public class Hooks {
        @Before
        public void setUp(){
            //System.out.println("\tthis is coming from before hook");
            Driver.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        }

        @After
        public void tearDown(Scenario scenario) {
            if (scenario.isFailed()) {
                final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
                scenario.attach(screenshot, "image/png", "screenshot");
            }

            //Driver.closeDriver();
        }
//        @Before("@db")
//        public void setUp1(){
//            System.out.println("\t\tconnecting to database...");
//        }
//
//        @After("@db")
//        public void tearDown1(){
//            System.out.println("\t\tdisconnecting from database...");
//        }

    }

