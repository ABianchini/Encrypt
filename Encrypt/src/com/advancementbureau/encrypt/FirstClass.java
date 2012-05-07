package com.advancementbureau.encrypt;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class FirstClass {
	public static void main(String args[]) throws FileNotFoundException {
		PrintWriter out = new PrintWriter("output.txt");
		out.println("test");
		out.close();
	}
}
