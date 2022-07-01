package escapefromuniversity;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import escapefromuniversity.utilities.OSFixes;



/**
 * A utility class to read a file.
 */
public class ReadFile {

    private final String fileName;
    private final BufferedReader reader;

    /**
     * Instantiates the object.
     * @param folderName the folder of the file to read.
     * @param fileName the name of the file to read.
     * @throws IOException
     */
    public ReadFile(final String folderName, final String fileName) throws IOException {
        this.fileName = OSFixes.getExternalLocation(folderName, fileName);
        this.reader = new BufferedReader(new FileReader(this.fileName));
    }

    /**
     * The buffered reader reads the file and returns the next line.
     * @return the next line from the file.
     * @throws IOException
     */
    public String newLine() throws IOException {
        return this.reader.readLine();
    }

    /**
     * Closes the buffered reader.
     * @throws IOException
     */
    public void close() throws IOException {
        this.reader.close();
    }

}
