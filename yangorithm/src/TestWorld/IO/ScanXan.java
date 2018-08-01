package TestWorld.IO;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ScanXan {
	public static void main(String[] args) throws IOException {
		Scanner s = null;
		
		try {
			s = new Scanner(new FileReader("testio.txt"));
			s.useDelimiter(",\\s*");

			while(s.hasNext()) {
				System.out.println(s.next());
			}
		} finally {
			if(s != null) s.close();
		}
		
		
	}

}
