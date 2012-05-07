package com.advancementbureau.encrypt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class EncryptShift {
	public static void main(String args[]) throws FileNotFoundException {
		File inputFile = new File("inputTest.txt");
		Scanner in = new Scanner(inputFile);
		PrintWriter out = new PrintWriter("output.txt");
		int shiftEnd = 0;
		int shiftMid = 0;
		int spaceCount = 0;
		
		while (in.hasNextLine()) {
			String inLine = in.nextLine();
			char[] inLinePieces = inLine.toCharArray();
			char[] outLinePieces = new char[inLinePieces.length];
			for (int i = 0; i < inLinePieces.length; i++) {
				
				char outChar = ' ';
				char inChar = inLinePieces[i];
				if (inChar == ' ') {
					if (spaceCount % 3 == 0) {
						outChar = '~';
					} if (spaceCount % 3 == 1) {
						outChar = '^';
					} if (spaceCount % 3 == 2) {
						outChar = '`';
					}
					spaceCount++;
				} else {
					outChar = (char) (inChar + 3);
				}
				outLinePieces[i] = outChar;
			}
			String outLine = new String(outLinePieces);
			shiftEnd = outLine.length()/8;
			shiftMid = outLine.length()/2;
			outLine = outLine.substring(shiftMid, outLine.length()) + outLine.substring(shiftEnd, shiftMid) + outLine.substring(0, shiftEnd);
			out.println(outLine);
		}
		
		in.close();
		out.close();
	}
}
