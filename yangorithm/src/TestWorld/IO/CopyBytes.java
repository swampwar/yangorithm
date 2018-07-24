package TestWorld.IO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyBytes {
	public static void main(String[] args) throws IOException{
		FileInputStream in = null;
		FileOutputStream out = null;
		
		try {
			in = new FileInputStream("testio.txt");
			out = new FileOutputStream("outagain.txt");
			int c;
			
			System.out.println("COPY START");
			while((c = in.read()) != -1) {
				System.out.println(c);
				out.write(c);
			}
		} finally {
			if(in != null) in.close();
			if(out != null) out.close();
		}
	}
}
