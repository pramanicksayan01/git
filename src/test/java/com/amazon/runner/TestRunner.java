package com.amazon.runner;

import org.junit.runner.RunWith;

//import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features="src/test/resources/features",tags="@Tags",
glue="com.amazon.steps")
public class TestRunner {

}
