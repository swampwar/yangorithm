package lib.ApacheCommonsIO;

import org.apache.commons.io.IOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class UseIOUtils {

    public static void main(String[] args) {
        InputStream is1 = UseIOUtils.class.getResourceAsStream("/TextFileForTest.txt");
        InputStream is2 = UseIOUtils.class.getResourceAsStream("/TextFileForTest.txt");

        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(is1));
            String line = "";


            while((line = reader.readLine()) != null){
                System.out.println("읽는다! : " + line);
            }

            is1.close();


            System.out.print(IOUtils.toString(is2, StandardCharsets.UTF_8));


        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
