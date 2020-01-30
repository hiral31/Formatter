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
	public void testLeftAlign() {
		String textToFormat = "This   text should    be left  aligned ";
		int lineWidth = 10;
		String formattedText = Formatter.format(Alignment.LEFT, lineWidth, textToFormat);
		assertEquals("This text \nshould be \nleft      \naligned   ", formattedText);

		lineWidth = 20;
		formattedText = Formatter.format(Alignment.LEFT, lineWidth, textToFormat);
		assertEquals("This text should be \nleft aligned        ", formattedText);
	}

	public void testRightAlign() {
		String textToFormat = "This   text should    be right  aligned ";
		int lineWidth = 10;
		String formattedText = Formatter.format(Alignment.RIGHT, lineWidth, textToFormat);
		assertEquals(" This text\n should be\n     right\n   aligned", formattedText);

		lineWidth = 20;
		formattedText = Formatter.format(Alignment.RIGHT, lineWidth, textToFormat);
		assertEquals(" This text should be\n       right aligned", formattedText);

	}

	public void testCenterAlign() {
		String textToFormat = "This   text should    be center  aligned ";
		int lineWidth = 10;
		String formattedText = Formatter.format(Alignment.CENTER, lineWidth, textToFormat);
		assertEquals("This text \nshould be \n  center  \n aligned  ", formattedText);

		lineWidth = 20;
		formattedText = Formatter.format(Alignment.CENTER, lineWidth, textToFormat);
		assertEquals("This text should be \n   center aligned   ", formattedText);
	}
	
	public void testNullText() {
		String textToFormat = "";
		int lineWidth = 10;
		String formattedText = Formatter.format(Alignment.LEFT, lineWidth, textToFormat);
		assertEquals("", formattedText);
	}

}
