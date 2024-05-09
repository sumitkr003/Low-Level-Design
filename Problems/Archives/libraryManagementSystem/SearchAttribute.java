package libraryManagementSystem;

public enum SearchAttribute {
    BOOK_ID("book_id"),
    AUTHOR_ID("author_id");

    private String attributeName;

    SearchAttribute(String attributeName) {
        this.attributeName = attributeName;
    }

    public static SearchAttribute getSearchAttribute(String attributeName) {
        for(SearchAttribute searchAttribute : SearchAttribute.values()) {
            if(searchAttribute.attributeName.equals(attributeName)) {
                return searchAttribute;
            }
        }
        return null;
    }
}
