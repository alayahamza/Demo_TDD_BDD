package com.demo.cucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = "src/test/resources/feature/validate_minimum_balance.feature", glue = "com.demo.cucumber.stepDefs")
public class RunMinBalanceValidation {

}