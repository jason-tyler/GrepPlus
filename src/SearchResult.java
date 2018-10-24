/**
 * Represents a search result and identifies that matches associated with a key.
 */
class SearchResult {
    private String key;
    private Matches matches = new Matches();

    /**
     * Default constructor.
     * @param key The search term.
     */
    SearchResult(String key){
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    public Matches getMatches() {
        return matches;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public void setMatches(Matches matches) {
        this.matches = matches;
    }
}
