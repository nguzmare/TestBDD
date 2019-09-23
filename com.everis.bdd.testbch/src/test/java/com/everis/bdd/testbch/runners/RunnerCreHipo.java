package com.everis.bdd.testbch.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(features = "features/funtionalTestingCreHipo.feature", glue="com.everis.bdd.testbch.definitions")
public class RunnerCreHipo {

}
