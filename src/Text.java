import java.util.Scanner;
import java.util.ArrayList;

/**
 * The text class stores the content provided by standard in and allows a client to search the text using keywords.
 */
public class Text {
    private ArrayList<String> text;

    /**
     * Gets the text.
     *
     * @return The local text.
     */
    String getText() {
        String buffer = new String();

        for (String line : this.text){
            buffer = buffer + line + '\n';
        }

        return buffer;
    }

    /**
     * Search an individual line for a key at a starting position.
     *
     * @param lineNumber Line number to search.
     * @param key Key to search.
     * @param position Starting position in the line.
     * @return If a match is made, it will identify the match.
     */
    private Match search(int lineNumber, String key, int position){

        int index = this.text.get(lineNumber).indexOf(key, position);

        if (index >= 0)
            return new Match(lineNumber+1, index+1);
        else
            return null;
    }

    /**
     * Search an individual line for a key.
     * @param lineNumber Line number to search.
     * @param key Key to search.
     * @return Returns a collection of matches.
     */
    private Matches search(int lineNumber, String key){
        Matches matches = new Matches();
        Match match = null;
        int position = 0;

        do{
            match = this.search(lineNumber, key, position);

            if (match != null) {
                matches.add(match);
                position = match.getLocation() + 1;
            }
        } while (match != null);

        return matches;
    }

    /**
     * Searches the text for a single key.
     *
     * @param key Key to search.
     * @return Returns a result.
     */
    private SearchResult search(String key){
        SearchResult result = new SearchResult(key);
        Matches matches = null;

        // For each line of text.
        for (int i = 0; i < this.text.size(); i++) {
            matches = search(i, key);

            if (matches != null)
                result.getMatches().addAll(matches);
        }

        return result;
    }

    /**
     * Searches the text for a collection of keys.
     *
     * @param keys Collection of keys.
     * @return A collection of search results.
     */
    SearchResults search(SearchKeys keys) {
        if (keys == null || keys.size() == 0)
            throw new IllegalArgumentException("Keys cannot be null or empty.");

        SearchResults results = new SearchResults();
        SearchResult result = null;

        // For each individual key in the collection, execute a search.
        for (String key : keys) {
            result = search(key);
            results.add(result);
        }

        return results;
    }

    /**
     * Reads text from standard input.
     *
     * @return Text from standard input.
     */
    void read() {
        // Init the text.
        this.text = new ArrayList<String>();

        Scanner scanner = new Scanner(System.in);

        // Loop through the contents of the standard input by line until the end of the stream is reached.
        while (scanner.hasNext() == true) {
            this.text.add(scanner.nextLine());
        }
    }
}
