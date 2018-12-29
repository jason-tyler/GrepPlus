/**
 * Represents a search result and identifies that matches associated with a key.
 */
public class SearchResult {
    private String key;
    private Matches matches = new Matches();

    /**
     * Default constructor.
     * @param key The search term.
     */
    SearchResult(String key){
        this.key = key;
    }

    /**
     * Gets the search key.
     * @return String value of the key.
     */
    public String getKey() {
        return key;
    }

    /**
     * Gets a collection of search matches.
     * @return Instance of Matches object.
     */
    public Matches getMatches() {
        return matches;
    }

    /**
     * Sets a search key.
     * @param key String value of the key.
     */
    public void setKey(String key) {
        this.key = key;
    }

    /**
     * Sets a collection of search matches.
     * @param matches Instance of a Matches object.
     */
    public void setMatches(Matches matches) {
        this.matches = matches;
    }
}
