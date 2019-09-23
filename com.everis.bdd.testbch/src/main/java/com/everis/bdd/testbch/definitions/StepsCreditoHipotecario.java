package com.everis.bdd.testbch.definitions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

import com.everis.bdd.testbch.mapping.MappingElements;
import com.everis.teslink.integration.Testlink;
import com.everis.utom.Element;
import com.everis.utom.ElementBuilder;
import com.everis.utom.Utom;
import com.everis.utom.UtomBuilder;
import com.everis.utom.enums.Action;
import com.everis.utom.exceptions.AutomataException;

import io.cucumber.core.api.Scenario;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class StepsCreditoHipotecario {

	Utom utom;
	

	public final static Logger log = LogManager.getLogger(StepsCreditoHipotecario.class);

	@Before
	public void before(Scenario escenario) throws AutomataException {
		   Testlink integration = new Testlink();
	       integration.DEV_KEY = "0df314b5ac37b3a71c1b07e71aa53800";
	       integration.URL = "http://127.0.0.1/testlink";
	       integration.TestProject = "BCH_PRUEBAS";
	       integration.Platform =  "Plataforma";
	       integration.TestBuild = "Build";
	       integration.TestPlanName = "GestionPlanPrueba";
	       integration.TestCaseName = "CasoPrueba_1";
	       integration.testSuiteName = "TestSuite";
	       integration.user = "admin";
	       integration.setEnable(true);
	       utom = new UtomBuilder(escenario.getName()).setChromeDriver().enableTeslinkIntegration(integration).build();
	       utom.getDriver().manage().window().maximize();
	
		
	}

	@After
	public void after() throws AutomataException {
		utom.shutDown();
		utom.generateReport();
	}
	
	/**
	 * Scenario 1: Credito Hipotecario con Tasa Mixta
	 */
	
	
	
	@Given("ingresar URL {string}")
	public void ingresarUrl(String url) throws AutomataException {
		log.info("1 Ingresar a la URL del Banco de Chile");
		utom.execute(Action.NAVIGATE, MappingElements.mapping.getProperty(url, url));
	}

	@When("click opcion {string}")
	public void clickOpcion(String simuladores) throws AutomataException {
		log.info("Ir a la pesta�a de Simuladores");
		Element btnSimuladores = new ElementBuilder().byXpath(MappingElements.mapping.getProperty(simuladores, simuladores)).build();
		utom.execute(Action.CLICK, btnSimuladores);
	}

	@When("ingresar dato {string} en campo {string}")
	public void ingresar_dato_en_campo(String dato, String xpath) throws AutomataException {
		Element elemento = new ElementBuilder().byXpath(MappingElements.mapping.getProperty(xpath, xpath)).build();
		utom.execute(Action.SENDKEYS, elemento, MappingElements.mapping.getProperty(dato,dato) + Keys.TAB);
	}				
	
	
	@Then("obtener resultado {string}")
	public void datosSimulacionCredito(String obtenerResultadoSimulacionCredito) throws AutomataException {
		log.info("Visualizar el Detalle del Credito Hipotecario");
		Element btnSimularCredito = new ElementBuilder().byXpath(MappingElements.mapping.getProperty(obtenerResultadoSimulacionCredito, obtenerResultadoSimulacionCredito)).build();
		utom.execute(Action.GET_TEXT, btnSimularCredito);
	}
	
	
}
