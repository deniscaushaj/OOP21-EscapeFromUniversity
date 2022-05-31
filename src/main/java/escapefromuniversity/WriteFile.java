package escapefromuniversity;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import escapefromuniversity.model.OSFixes;

public class WriteFile {
	
	private final String fileName;
	private BufferedReader r;
	
	public WriteFile(String folderName, String fileName) throws FileNotFoundException {
		this.fileName = OSFixes.getLocation(folderName, fileName);
		this.r = new BufferedReader(
				new FileReader(this.fileName));
		
	}

}
