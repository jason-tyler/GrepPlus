/**
 * GrepPlus is an application that accepts multiple key words that can be used to search a string of text provided
 * by standard input. If a match is found, GrepPlus will print the line number and location of the match.
 *
 * @author Jason Tyler
 */
public class GrepPlus {

    // App constants.
    private static byte APP_CODE_ERROR = 1;
    private static byte APP_CODE_SUCCESS = 0;
    private static String ARG_HELP = "--help";
    private static String ARG_KEY = "--key";

    /**
     * The entrypoint to the application is the main method. The application is expected to take arguments in the
     * format of --key value format.
     * @param args Program arguments.
     */
    public static void main(String[] args){
        /*
         * Validate the program arguments.
         */
        // Were any arguments provided?
        if (args == null || args.length == 0){
            printNoArgumentsMessage();
            exit(APP_CODE_ERROR);
        }

        // Was the help (--help) argument provided?
        if (args[0] != null && args[0].equals(ARG_HELP)){
            printHelpMessage();
            exit(APP_CODE_SUCCESS);
        }

        // Get the search keys that have been provided by program arguments.
        SearchKeys keys = getKeys(args);

        // Instantiate a Text object to read from standard input and begin the search.
        Text text = new Text();

        // Read the standard input into the object.
        text.read();

        // Execute the search.
        SearchResults results = text.search(keys);

        // Print the results of the search.
        printSearchResults(results);

        // Exit the program with a success code.
        exit(APP_CODE_SUCCESS);
    }

    /**
     * Prints an individual search result.
     * @param result The result of a single keyword search.
     */
    private static void printSearchResult(SearchResult result){
        System.out.println("Key: " + result.getKey() + " - " + result.getMatches().size() + " match(es)");

        for (Match match : result.getMatches()){
            System.out.println("\tLine: " + match.getLineNumber() + " Char: " + match.getLocation());
        }
    }

    /**
     * Prints all search results to standard out.
     * @param results Collection of search results.
     */
    private static void printSearchResults(SearchResults results){
        for (SearchResult result : results){
            if (result.getMatches().size() > 0){
                printSearchResult(result);
            }
        }
    }

    /**
     * Gets the search terms from the arguments.
     * @param arguments Program arguments.
     * @return An array of search terms.
     */
    private static SearchKeys getKeys(String [] arguments){
        if (arguments == null)
            throw new IllegalArgumentException("arguments is required.");

        SearchKeys keys = new SearchKeys();

        for (int i = 0; i<arguments.length; i++){
            if (arguments[i].equals(ARG_KEY) && i+1 < arguments.length && arguments[i+1].equals(ARG_KEY) == false){
                keys.add(arguments[i+1]);
            }
        }

        return keys;
    }

    /**
     * Exits the application with the provided error code.
     * @param code The exit code.
     */
    private static void exit(byte code){
        System.exit(code);
    }

    /**
     * Prints a message to the standard error stream.
     * @param msg The message to be printed.
     */
    private static void printError(String msg){
        System.err.println(msg);
    }

    /**
     * Prints a message to the output stream.
     * @param msg The message to be printed.
     */
    private static void printMessage(String msg){
        System.out.println(msg);
    }

    /**
     * Prints a message for when no arguments have been provided to GrepPlus.
     */
    private static void printNoArgumentsMessage(){
        String msg = "Usage: GrepPlus --key VALUE\n" +
                "Try 'GrepPlus --help' for more information.\n";
        printError(msg);
    }

    /**
     * Prints a help message when a user provides the --help argument.
     */
    private static void printHelpMessage(){
        printMessage("GrepPlus is an application that accepts multiple key words that can be used to search " +
                "a string of text provided by standard input. If a match is found, GrepPlus will print the line " +
                "number and location of the match.\n"+
                "Usage: GrepPlus --key VALUE [--key VALUE]");
    }

    /**
     * Prings a message because no text was received from standard input.
     */
    private static void printNoInputMessage(){
        String msg = "GrepPlus requires text to be provided by standard input.";
        printError(msg);
    }
}
