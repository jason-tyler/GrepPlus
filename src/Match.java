/**
 * Represents a single match.
 */
class Match {
    private int lineNumber;
    private int location;

    Match(){}

    Match(int lineNumber, int location){
        this.lineNumber = lineNumber;
        this.location = location;
    }

    void setLineNumber(int lineNumber) {
        this.lineNumber = lineNumber;
    }

    void setLocation(int location) {
        this.location = location;
    }

    int getLineNumber() {
        return lineNumber;
    }

    int getLocation() {
        return location;
    }
}
