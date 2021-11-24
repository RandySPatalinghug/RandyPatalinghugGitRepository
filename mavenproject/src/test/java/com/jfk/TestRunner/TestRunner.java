package com.jfk.TestRunner;

import org.junit.runner.RunWith;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;


@RunWith(Cucumber.class)
 
@CucumberOptions(features = {
        "src/test/resources/features/jfkTest.feature" },
		plugin = "pretty",
		glue = "com.jfk.mavenproject")
public class TestRunner {
 
}