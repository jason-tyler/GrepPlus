/**
 * Represents a single match.
 */
public class Match {
    private int lineNumber;
    private int location;

    /**
     * Default constructor.
     */
    Match(){}

    /**
     *
     * @param lineNumber The line number that contains a match.
     * @param location The character index of the match.
     */
    Match(int lineNumber, int location){
        this.lineNumber = lineNumber;
        this.location = location;
    }

    /**
     * Sets the line number.
     * @param lineNumber Line Number.
     */
    void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    /**
     * Sets the location.
     * @param location Location.
     */
    void setLocation(int location) {
        this.location = location;
    }

    /**
     * Gets the line number.
     * @return Integer value of the line that contains the match.
     */
    int getLineNumber() {
        return lineNumber;
    }

    /**
     * Gets the location number.
     * @return Integer value of the index of the match.
     */
    int getLocation() {
        return location;
    }
}
