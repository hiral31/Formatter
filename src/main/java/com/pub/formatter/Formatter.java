package com.pub.formatter;

import java.util.Scanner;

//Main Class 
public class Formatter {

	public static void main(String[] args) {

		// Check the inputs
		if (args.length < 2) {
			System.out.println("Please provide inputs for text alignment and width");
			System.exit(1);
		}
		// get input
		Scanner scan = new Scanner(System.in);
		System.out.println("Please provide Text you want to align");
		String textAlign = scan.nextLine();
		// call TextAlignUtils class for formating output
		TextAlignUtils textAlignUtils = new TextAlignUtils(args[0], Integer.parseInt(args[1]));
		System.out.println(textAlignUtils.format(textAlign));

	}

	public static String format(Alignment align, int lineWidth, String textToAlign) {
		String formatedText = "";
		TextAlignUtils textAlignUtils;
		switch (align) {
		case LEFT:
			textAlignUtils = new TextAlignUtils("LEFT", lineWidth);
			formatedText = textAlignUtils.format(textToAlign);
			break;
		case RIGHT:
			textAlignUtils = new TextAlignUtils("RIGHT", lineWidth);
			formatedText = textAlignUtils.format(textToAlign);
			break;
		case CENTER:
			textAlignUtils = new TextAlignUtils("CENTER", lineWidth);
			formatedText = textAlignUtils.format(textToAlign);
			break;
		default:
			throw new IllegalArgumentException("invalid justification arg.");

		}
		return formatedText;
	}
}
