import java.io.*;
import java.util.*;

public class FileParser {
    private Reader reader;
    private Map<String, ArrayList<Object>> cellData;
    private Integer lowestRating;
    private Integer highestRating;

    public FileParser(Reader reader) {
        this.reader = reader;
        this.cellData = new HashMap<>();
    }

    public void readFile() throws IOException {
        BufferedReader br = new BufferedReader(reader);
        String line;
        int linesRead = 0;

        // Allocate first line to headers
        String[] cellHeader = br.readLine().split(",");
        linesRead += 1;

        while ((line = br.readLine()) != null) {
            ArrayList<String>
            String[] cellRow = line.split(",");
            // cellRow[0] = name, cellRow[1] = category, cellRow[2] = rating
            String[] categoryData = {cellRow[0], cellRow[2]};
            if (cellData.containsKey(cellRow[0])) {

            }
            // cellData.put(cellRow[1], categoryData);
            linesRead += 1;
        }

        System.out.println(Arrays.toString(cellHeader));
        System.out.printf("Total lines in file: %d", linesRead); 

    }

    public void printCategory(String category) {
        System.out.printf("Category: %s", category);
    }
}
