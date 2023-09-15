import java.io.File;
import java.util.Scanner;

/**
 * File to read in all the commands
 * 
 * @author mikehanson
 * @version 9/15/23
 */
public class CommandFileParser {
    private String filename;

    /**
     * COnstructor for the parser
     * 
     * @param filename file to read from
     */
    public CommandFileParser(String filename) {
        this.filename = filename;
    }

    public String readCommands() throws Exception {
        String ret = "";
        File file = new File(filename);
        Scanner reader = new Scanner(file);

        while (reader.hasNextLine()) {
            String currentCommand = reader.nextLine().trim();

            if(currentCommand.startsWith("insert")) {

            }
            else if(currentCommand.startsWith("search")) {

            }
            else if(currentCommand.startsWith("delete")) {

            }
            else if(currentCommand.startsWith("print")) {

            }
        }

        reader.close();
        return ret;
    }
}