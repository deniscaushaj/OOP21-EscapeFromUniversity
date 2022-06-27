package escapefromuniversity;

import escapefromuniversity.utilities.OSFixes;

import java.io.*;
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
	public WriteFile(String folderName, String fileName) throws IOException {
		this.fileName = OSFixes.getLocation(folderName, fileName);
		this.writer = new BufferedWriter(new FileWriter(this.fileName));
	}

	/**
	 * Reads a file, writes a new line into it and sorts its lines.
	 * @param newLine a line to write into the file.
	 * @throws IOException
	 */
	public void writeNewLine(String newLine) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(this.fileName));
		this.list = new ArrayList<>();
		String line;
		while((line=reader.readLine())!=null) {
			this.list.add(line);
		}
		this.list.add(newLine);
		this.list.sort(Collections.reverseOrder());
		FileWriter writer = new FileWriter(OSFixes.getLocation("score", "score.txt"));
		for(String s: this.list){
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
