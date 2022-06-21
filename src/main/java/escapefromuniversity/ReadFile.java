package escapefromuniversity;

import escapefromuniversity.utilities.OSFixes;

import java.io.*;

public class ReadFile {

	private final String fileName;
	private final BufferedReader reader;
	
	public ReadFile(String folderName, String fileName) throws IOException {
		this.fileName = OSFixes.getLocation(folderName, fileName);
		this.reader = new BufferedReader(new FileReader(this.fileName));
	}
	
	public String newLine() throws IOException {
		return this.reader.readLine();
	}
	
	public void close() throws IOException {
		this.reader.close();
	}

}
