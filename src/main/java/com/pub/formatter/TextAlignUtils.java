package com.pub.formatter;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//Used Format class for formatting text
public class TextAlignUtils extends Format {

	private static final long serialVersionUID = 1L;

	private String currentAlignment;
	private int width;

	public TextAlignUtils(String align, int width) {

		this.currentAlignment = align;
		if (width < 0) {
			throw new IllegalArgumentException("Width must be positive.");
		}
		this.width = width;
	}

	@Override
	public StringBuffer format(Object inputText, StringBuffer toAppendTo, FieldPosition pos) {

		String text = inputText.toString();
		// List<String> inputTextList = splitInputString(text);
		List<String> inputTextList = splitString(text, width);
		ListIterator<String> textListItr = inputTextList.listIterator();

		while (textListItr.hasNext()) {

			String numberOfText = textListItr.next();

			if (currentAlignment.equals("LEFT")) {
				toAppendTo.append(numberOfText);
				padding(toAppendTo, width - numberOfText.length());
			}

			if (currentAlignment.equals("RIGHT")) {
				padding(toAppendTo, width - numberOfText.length());
				toAppendTo.append(numberOfText);

			}
			if (currentAlignment.equals("CENTER")) {
				int toAdd = width - numberOfText.length();
				padding(toAppendTo, toAdd / 2);
				toAppendTo.append(numberOfText);
				padding(toAppendTo, toAdd - toAdd / 2);

			}
			toAppendTo.append("\n");
		}
		return toAppendTo;
	}

	String format(String s) {
		if(s!=null && s.length()>0 && !s.equalsIgnoreCase(" ")) {
			String finalString = format(s, new StringBuffer(), null).toString();

			return finalString.substring(0, finalString.length() - 1);
			}
		else {
			return s;
		}
	}

	@Override
	public Object parseObject(String source, ParsePosition pos) {
		return source;
	}

	// split strings in the given width
	private List<String> splitInputString(String inputText) {

		List<String> listText = new ArrayList<String>();

		int endIndex;
		if (inputText == null) {
			return listText;
		}

		for (int i = 0; i < inputText.length(); i = i + width) {
			endIndex = Math.min(i + width, inputText.length());
			listText.add(inputText.substring(i, endIndex));
		}

		return listText;
	}

	protected final void padding(StringBuffer toAppend, int numberOfText) {

		for (int i = 0; i < numberOfText; i++) {
			toAppend.append(' ');
		}
	}

	// Create new function for split line in a way that whole word consider and
	// extra space will be removed
	public List<String> splitString(String text, int lineSize) {
		List<String> textList = new ArrayList<String>();

		Pattern p = Pattern.compile("\\b.{1," + (lineSize - 1) + "}\\b\\W?");
		Matcher m = p.matcher(text.trim().replaceAll(" +", " "));

		while (m.find()) {
			textList.add(m.group().trim());
		}
		return textList;
	}

}
