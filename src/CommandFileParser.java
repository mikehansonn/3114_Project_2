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
    private SemSearch search;

    /**
     * Constructor for the parser
     * 
     * @param filename file to read from
     * @param search   the semSearch class
     */
    public CommandFileParser(String filename, SemSearch search) {
        this.filename = filename;
        this.search = search;
    }

    /**
     * Reads in the commands off of the file
     * 
     * @throws Exception filenotfound
     */
    public void readCommands() throws Exception {
        File file = new File(filename);
        Scanner reader = new Scanner(file);

        while (reader.hasNextLine()) {
            String currentCommand = reader.nextLine().trim();

            if (currentCommand.startsWith("insert")) {
                String[] splitStrings = currentCommand.split("\\s+");
                int idin = Integer.parseInt(splitStrings[1]);

                String tin = reader.nextLine().trim();

                String[] data = reader.nextLine().trim().split("\\s+");
                String datein = data[0];
                int lin = Integer.parseInt(data[1]);
                short xin = Short.parseShort(data[2]);
                short yin = Short.parseShort(data[3]);
                int cin = Integer.parseInt(data[4]);

                String[] kin = reader.nextLine().trim().split("\\s+");
                String descin = reader.nextLine().trim();

                Seminar seminar = new Seminar(
                        idin, tin, datein, lin, xin, yin, cin, kin, descin);
                search.insertSeminar(seminar, idin);
            } 
            else if (currentCommand.startsWith("search")) {
                String[] splitStrings = currentCommand.split("\\s+");
                search.searchSeminar(splitStrings);
            } 
            else if (currentCommand.startsWith("delete")) {
                String[] splitStrings = currentCommand.split("\\s+");
                search.deleteSeminar(Integer.parseInt(splitStrings[1]));
            } 
            else if (currentCommand.startsWith("print")) {
                String[] splitStrings = currentCommand.split("\\s+");
                search.printSeminar(splitStrings[1]);
            }
        }

        reader.close();
    }
}