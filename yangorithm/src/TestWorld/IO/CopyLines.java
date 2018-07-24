package TestWorld.IO;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CopyLines {
	public static void main(String[] args) throws IOException {
		BufferedReader inputStream = null;
		PrintWriter outputStream = null;
		
		try {
			inputStream = new BufferedReader(new FileReader("testio.txt"));
			outputStream = new PrintWriter(new FileWriter("characteroutput.txt"));
			
			String l;
			while(( l = inputStream.readLine()) != null) {
				System.out.println(l);
				outputStream.println(l);
			}
		} finally {
			if(inputStream != null) inputStream.close();
			if(outputStream != null) outputStream.close();
		}
	}

}
