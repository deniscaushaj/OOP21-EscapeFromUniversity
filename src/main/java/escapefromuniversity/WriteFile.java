package escapefromuniversity;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import escapefromuniversity.model.OSFixes;

public class WriteFile {
	
	private final String fileName;
	private BufferedWriter w;
	
	public WriteFile(String folderName, String fileName) throws IOException {
		this.fileName = OSFixes.getLocation(folderName, fileName);
		this.w = new BufferedWriter(
				new FileWriter(this.fileName));
		
	}
	
	public void writeNewLine(String line) throws IOException {
		w.write(line);
	}
	
	public void close() throws IOException {
		w.close();
	}

}
