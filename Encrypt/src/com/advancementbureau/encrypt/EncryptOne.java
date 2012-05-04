package com.advancementbureau.encrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class EncryptOne {
	public static void main(String args[]) throws FileNotFoundException {
		File inputFile = new File("inputTest.txt");
		Scanner in = new Scanner(inputFile);
		PrintWriter out = new PrintWriter("output.txt");
		String codeWord = "Four score and seven years ago our fathers brought forth on this continent a new nation, conceived in liberty, and dedicated to the proposition that all men are created equal.";
		int spaceCount = 0;
		
		while (in.hasNextLine()) {
			String inLine = in.nextLine();
			char[] inLinePieces = inLine.toCharArray();
			char[] outLinePieces = new char[inLinePieces.length];
			for (int i = 0; i < inLinePieces.length; i++) {
				
				char outChar;
				char inChar = inLinePieces[i];
				if (inChar == ' ') {
					outChar = codeWord.charAt(spaceCount);
					spaceCount++;
				} else {
					outChar = (char) (inChar + 1);
				}
				outLinePieces[i] = outChar;
			}
			String outLine = new String(outLinePieces);
			out.println(outLine);
		}
		
		in.close();
		out.close();
	}
}
