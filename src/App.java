
import java.io.*;

public class App {
    public static void main(String[] args) {

        String fileName = "";
        if (args.length > 0) {
            fileName = args[0];
        } else {
            System.err.println("No file provided, exiting program");
            System.exit(0);
        }

        try {
            Reader reader = new FileReader(fileName);
            FileParser fp = new FileParser(reader);
            fp.readFile();
        } catch (Exception e) {
        }

    }
}