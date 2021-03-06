package escapefromuniversity;

import escapefromuniversity.utilities.OSFixes;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;

/**
 * A utility class to write into a file.
 */
public class WriteFile {

    private final String fileName;
    private final BufferedWriter writer;
    private ArrayList<String> list;

    /**
     * Instantiates the object.
     * @param folderName the folder of the file to write into.
     * @param fileName the name of the file to write into.
     * @throws IOException
     */
    public WriteFile(final String folderName, final String fileName) throws IOException {
        this.fileName = OSFixes.getExternalLocation(folderName, fileName);
        this.writer = new BufferedWriter(new FileWriter(this.fileName));
    }

    /**
     * Reads a file, writes a new line into it and sorts its lines.
     * @param newLine a line to write into the file.
     * @throws IOException
     */
    public void writeNewLine(final String newLine) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(this.fileName));
        this.list = new ArrayList<>();
        String line;
        while ((line = reader.readLine()) != null) {
            this.list.add(line);
        }
        this.list.add(newLine);
        this.list.sort(Collections.reverseOrder());
        FileWriter writer = new FileWriter(OSFixes.getLocation("EscapeFromUniversity", "score.txt"));
        for (String s: this.list) {
            writer.write(s);
            writer.write("\r\n");
        }
        reader.close();
    }

    /**
     * Closes the buffered writer.
     * @throws IOException
     */
    public void close() throws IOException {
        this.writer.close();
    }

}
