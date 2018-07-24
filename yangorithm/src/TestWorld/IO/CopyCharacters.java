package TestWorld.IO;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class CopyCharacters {
	public static void main(String[] args) throws IOException {
		FileReader inputStream = null;
		FileWriter outputStream = null;

		try {
			inputStream = new FileReader("testio.txt");
			outputStream = new FileWriter("characteroutput.txt");
			
			int c;
			System.out.println("COPY START");
			while((c = inputStream.read()) != -1) {
				System.out.println(c);
				outputStream.write(c);
			}
		} finally {
			if(inputStream != null) inputStream.close();
			if(outputStream != null) outputStream.close();
		}
	}
}
