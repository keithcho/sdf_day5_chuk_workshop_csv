
import java.io.*;

public class Main {
    public static void main(String[] args) {

        if (args.length <= 0) {
            System.err.println("No file provided, exiting program");
            System.exit(1);
         }

        try {
            Reader reader = new FileReader(args[0]);
            FileParser fp = new FileParser(reader);
            fp.readFile();
        } catch (Exception e) {
        }   

    }
}