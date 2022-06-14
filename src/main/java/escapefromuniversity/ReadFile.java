package escapefromuniversity;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import escapefromuniversity.utilities.OSFixes;

public class ReadFile {
	
	private final String fileName;
	private BufferedReader r;
	
	public ReadFile(String folderName, String fileName) throws FileNotFoundException {
		this.fileName = OSFixes.getLocation(folderName, fileName);
		this.r = new BufferedReader(
				new FileReader(this.fileName));
		
	}
	
	public String newLine() throws IOException {
		return r.readLine();
	}
	
	public void close() throws IOException {
		r.close();
	}
	
	

}
