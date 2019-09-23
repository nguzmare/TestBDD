package com.everis.bdd.testbch.mapping;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MappingElements {
	public final static Logger log = LogManager.getLogger(MappingElements.class);
	public static Properties mapping;

	static {
		mapping = new Properties();
		try {
			mapping.load(new FileInputStream(new File("mapping/ElementMapping.properties").getAbsoluteFile()));
		} catch (Exception e) {
			log.info("Erron on Startup. " + e.getMessage(), e);
		}
	}
}
