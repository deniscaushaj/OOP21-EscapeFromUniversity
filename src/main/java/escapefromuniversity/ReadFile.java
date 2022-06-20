package escapefromuniversity;

import escapefromuniversity.utilities.OSFixes;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class ReadFile {

	private final String fileName;
	private final BufferedReader reader;
	
	public ReadFile(String folderName, String fileName) throws IOException {
		this.fileName = OSFixes.getLocation(folderName, fileName);
		this.reader = new BufferedReader(new FileReader(this.fileName));
	}
	
	public String newLine() throws IOException {
		return reader.readLine();
	}
	
	public void close() throws IOException {
		reader.close();
	}

}
