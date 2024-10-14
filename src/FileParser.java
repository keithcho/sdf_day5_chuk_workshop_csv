import java.io.*;
import java.util.*;

public class FileParser {
    private Reader reader;
    private Map<String, String[]> cellData;

    public FileParser(Reader reader) {
        this.reader = reader;
        this.cellData = new HashMap<>();
    }

    public void readFile() throws IOException {
        BufferedReader br = new BufferedReader(reader);
        String header;
        String line;
        int linesRead = 0;

        String[] cellHeader = br.readLine().split(",");
        linesRead += 1;

        while ((line = br.readLine()) != null) {
            String[] cellRow = line.split(",");
            String[] appData = {cellRow[1], cellRow[2]};
            cellData.put(cellRow[0], appData);
            linesRead += 1;
        }

        System.out.println(Arrays.toString(cellHeader));
        System.out.printf("Total lines in file: %d", linesRead); 

    }

    public void printCategory(String category) {
        System.out.printf("Category: %s", category);
    }
}
