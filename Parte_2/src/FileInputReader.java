import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;

/**
 * This class FileInputReader is a class that will read the files that we will
 * use in the program
 *
 * @author Bernardo e Tiago
 * @version June 2023
 */
public class FileInputReader {
    // attributes to help ignore both commas and semicolons in the files
    public static final String DISCARDEDCHAR_COMMA = ",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";
    public static final String DISCARDEDCHAR_SEMICOLON = ";(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)";

    /**
     * Method that reads files
     *
     * @param filepath file location address of the infos
     * @return all the lines in the file inside a List (ArrayList)
     */
    public static ArrayList<String> readCsv(String filepath) {
        ArrayList<String> info = new ArrayList<>();
        try {
            FileInputStream fis = new FileInputStream(filepath);
            InputStreamReader isr = new InputStreamReader(fis, StandardCharsets.ISO_8859_1);
            BufferedReader br = new BufferedReader(isr);
            br.readLine();
            String line;
            while ((line = br.readLine()) != null) {
                info.add(line);
            }
            br.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return info;
    }

}
