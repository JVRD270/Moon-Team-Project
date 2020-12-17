package tests;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = { "classpath:features" }, plugin = { "pretty", "json:target/cucumber/cucumber.json" }, glue = { "classpath:stepDefinitions" })

public class RunCucumberTest {

}