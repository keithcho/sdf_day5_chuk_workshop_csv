public class CategoryData {
    private String categoryName;
    private Double totalRating;
    private String highestRatedName;
    private Double highestRating;
    private String lowestRatedName;
    private Double lowestRating;
    private Integer categoryCount = 1;
    private Integer discardedCount = 0;
    private Integer categoryLines = 1;

    public CategoryData(String categoryName) {
        this.categoryName = categoryName;
    }

    public Double getTotalRating() {
        return totalRating;
    }

    public void setTotalRating(Double totalRating) {
        this.totalRating = totalRating;
    }

    public String getHighestRatedName() {
        return highestRatedName;
    }

    public void setHighestRatedName(String highestRatedName) {
        this.highestRatedName = highestRatedName;
    }

    public Double getHighestRating() {
        return highestRating;
    }

    public void setHighestRating(Double highestRating) {
        this.highestRating = highestRating;
    }

    public String getLowestRatedName() {
        return lowestRatedName;
    }

    public void setLowestRatedName(String lowestRatedName) {
        this.lowestRatedName = lowestRatedName;
    }

    public Double getLowestRating() {
        return lowestRating;
    }

    public void setLowestRating(Double lowestRating) {
        this.lowestRating = lowestRating;
    }

    public Integer getCategoryCount() {
        return categoryCount;
    }

    public void setCategoryCount(Integer categoryCount) {
        this.categoryCount = categoryCount;
    }

    public Integer getDiscardedCount() {
        return discardedCount;
    }

    public void setDiscardedCount(Integer discardedCount) {
        this.discardedCount = discardedCount;
    }

    public Integer getCategoryLines() {
        return categoryLines;
    }

    public void setCategoryLines(Integer categoryLines) {
        this.categoryLines = categoryLines;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }


}
