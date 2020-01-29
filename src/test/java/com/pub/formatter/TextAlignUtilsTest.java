package com.pub.formatter;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TextAlignUtilsTest extends TestCase {

	public TextAlignUtilsTest(String testName) {
		super(testName);
	}

	public static Test suite() {
		return new TestSuite(TextAlignUtilsTest.class);
	}

	String actual = "Spring Data is an umbrella project consisting of independent projects with, in principle, different release cadences. To manage the portfolio, a BOM (Bill of Materials - see this example) is published with a curated set of dependencies on the individual project. The release trains have names, not versions.";

	public void testTextLeftAlign_true() {

		StringBuffer expected = new StringBuffer();

		expected.append("Spring Data is an umbrella project consisting of i\n");
		expected.append("ndependent projects with, in principle, different \n");
		expected.append("release cadences. To manage the portfolio, a BOM (\n");
		expected.append("Bill of Materials - see this example) is published\n");
		expected.append(" with a curated set of dependencies on the individ\n");
		expected.append("ual project. The release trains have names, not ve\n");
		expected.append("rsions.                                           \n");

		TextAlignUtils textAlignUtils = new TextAlignUtils("LEFT", 50);

		assertEquals(expected.toString(), textAlignUtils.format(actual));

	}

	public void testTextRightAlign_true() {

		StringBuffer expected = new StringBuffer();

		expected.append("Spring Data is an umbrella project consisting of i\n");
		expected.append("ndependent projects with, in principle, different \n");
		expected.append("release cadences. To manage the portfolio, a BOM (\n");
		expected.append("Bill of Materials - see this example) is published\n");
		expected.append(" with a curated set of dependencies on the individ\n");
		expected.append("ual project. The release trains have names, not ve\n");
		expected.append("                                           rsions.\n");

		TextAlignUtils textAlignUtils = new TextAlignUtils("RIGHT", 50);

		assertEquals(expected.toString(), textAlignUtils.format(actual));

	}

	public void testTextCenterAlign_true() {

		StringBuffer expected = new StringBuffer();

		expected.append("Spring Data is an umbrella project consisting of i\n");
		expected.append("ndependent projects with, in principle, different \n");
		expected.append("release cadences. To manage the portfolio, a BOM (\n");
		expected.append("Bill of Materials - see this example) is published\n");
		expected.append(" with a curated set of dependencies on the individ\n");
		expected.append("ual project. The release trains have names, not ve\n");
		expected.append("                     rsions.                      \n");

		TextAlignUtils textAlignUtils = new TextAlignUtils("CENTER", 50);

		assertEquals(expected.toString(), textAlignUtils.format(actual));

	}

}
