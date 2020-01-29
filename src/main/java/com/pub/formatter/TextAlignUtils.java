package com.pub.formatter;

import java.text.FieldPosition;
import java.text.Format;
import java.text.ParsePosition;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

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
		List<String> inputTextList = splitInputString(text);
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
		return format(s, new StringBuffer(), null).toString();
	}

	@Override
	public Object parseObject(String source, ParsePosition pos) {
		return source;
	}

	//split strings in the given width
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

}
