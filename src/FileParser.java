import java.io.*;
import java.util.*;

public class FileParser {
    private Reader reader;
    private Map<String, CategoryData> cellData;
    private Integer totalLines = 0;

    public FileParser(Reader reader) {
        this.reader = reader;
        this.cellData = new HashMap<>();
    }

    public void readFile() throws IOException {
        BufferedReader br = new BufferedReader(reader);
        String line;

        // Allocate first line to headers
        String[] cellHeader = br.readLine().split(",");
        totalLines += 1;

        while ((line = br.readLine()) != null) {
            String[] cellRow = line.split(",");
            String appName = cellRow[0];
            String category = cellRow[1];
            double appRating;
            try {
                appRating = Double.parseDouble(cellRow[2]);
            } catch (NumberFormatException e) {
                appRating = -1;
            }
            // System.out.println(appName + ", " + category + ", " + appRating + ", " + cellRow[2]);
            // If cellData does not contain the category, create a new entry with the category
            if (!cellData.containsKey(category)) {
                if (appRating > 0 && appRating < 5) {
                    CategoryData categoryData = new CategoryData(category);
                    categoryData.setHighestRatedName(appName);
                    categoryData.setLowestRatedName(appName);
                    categoryData.setHighestRating(appRating);
                    categoryData.setLowestRating(appRating);
                    categoryData.setTotalRating(appRating);
                    cellData.put(category, categoryData);
                } else {
                    // Discard category line
                    CategoryData categoryData = new CategoryData(category);
                    categoryData.setDiscardedCount(categoryData.getDiscardedCount() + 1);
                }
            } else if (cellData.containsKey(category)) {
                // If cellData contains category and rating is valid, add to category
                if (appRating > 0 && appRating < 5) {
                    CategoryData categoryData = cellData.get(category);
                    if (appRating > categoryData.getHighestRating()) {
                        // Set new highest rating and name
                        categoryData.setHighestRating(appRating);
                        categoryData.setHighestRatedName(appName);
                    } else if (appRating < categoryData.getLowestRating()) {
                        // Set new lowest rating and name
                        categoryData.setLowestRating(appRating);
                        categoryData.setLowestRatedName(appName);
                    }
                    categoryData.setTotalRating(categoryData.getTotalRating() + appRating);
                    categoryData.setCategoryCount(categoryData.getCategoryCount() + 1);
                    categoryData.setCategoryLines(categoryData.getCategoryLines() + 1);
                } else {
                    // Discard category line
                    CategoryData categoryData = cellData.get(category);
                    categoryData.setDiscardedCount(categoryData.getDiscardedCount() + 1);
                }
            }
            totalLines += 1;
        }

        // System.out.println(Arrays.toString(cellHeader));
        // System.out.println(Arrays.asList(cellData));
        // cellData.forEach((key, value) -> System.out.println(key + " " + value));
        // System.out.printf("Total lines in file: %d", totalLines); 

    }

    public void printCategories() {
        for (String name: cellData.keySet()) {
            CategoryData categoryData = cellData.get(name);
            System.out.printf("Category: %s\n", name);
            System.out.printf("\tHighest: %s, %.2f\n", categoryData.getHighestRatedName(), categoryData.getHighestRating());
            System.out.printf("\tLowest: %s, %.2f\n", categoryData.getLowestRatedName(), categoryData.getLowestRating());
            System.out.printf("\tAverage: %.2f\n", categoryData.getTotalRating()/categoryData.getCategoryCount());
            System.out.printf("\tCount: %d\n", categoryData.getCategoryCount());
            System.out.printf("\tDiscarded: %d\n", categoryData.getDiscardedCount());
            System.out.println();
        }
        System.out.printf("Total lines in file: %d\n", totalLines);
    }
}
