package com.altran.ci.fitnesse.suite;

import org.junit.Before;
import org.junit.Test;

import fitnesse.junit.JUnitHelper;
import fitnesse.junit.JUnitXMLTestListener;

public class ContinousIntegrationIT {
	private JUnitHelper helper;
	private JUnitXMLTestListener resultListener;

	@Before
	public void prepare() {
		resultListener = new JUnitXMLTestListener("target/failsafe-reports");
		helper = new JUnitHelper(".", "target/fitnesse-reports", resultListener);	
	}

	@Test
	public void assertTestPasses_RunsATestThroughFitNesseAndWeCanInspectTheResultUsingJavaFormatter()
			throws Exception {
		helper.assertTestPasses("ContinousIntegration.AddPlayer");
	}

}
