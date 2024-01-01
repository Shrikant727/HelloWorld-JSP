/**
 * 
 */
package com.practice.firstassignment;

import java.io.*;
/**
 * @author Shrikant_Bhadgaonkar
 * 12. File Read Write
 */
public class FileHandlingPractice {

	public static void main(String[] args) throws IOException {
		String fileName="XMLPractice.xml";
//		Writing to a file
		FileWriter f=new FileWriter(fileName);
		String statement="<Zoo>\n\t<Animal>\n\t<Lion>Leo<\\Lion>\n\t<\\Animal>\n<\\Zoo>";
		for(int i=0;i<statement.length();i++) {
			f.write(statement.charAt(i));
		}
		f.close();
//		Reading from a file
		int ch;
		try(FileReader fr= new FileReader(fileName)){
			while((ch=fr.read())!=-1)System.out.print((char)ch);
		}
		catch(IOException e) {
			e.printStackTrace();
		}

	}

}
