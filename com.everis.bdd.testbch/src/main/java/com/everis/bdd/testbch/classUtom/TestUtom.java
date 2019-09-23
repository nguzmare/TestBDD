package com.everis.bdd.testbch.classUtom;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.everis.utom.Utom;
import com.everis.utom.UtomBuilder;

import io.cucumber.core.api.Scenario;


public class TestUtom {
	
	public final static Logger log = LogManager.getLogger(TestUtom.class);
	public static Utom utom;
	public static Scenario escena;
	
	static {
		try {
			utom = new UtomBuilder(escena.getName()).setChromeDriver().build();
		} catch (Exception e) {
			log.info("Erron on Startup. " + e.getMessage(), e);
		}
	}
	
}
