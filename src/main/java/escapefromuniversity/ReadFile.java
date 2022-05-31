package escapefromuniversity;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import escapefromuniversity.model.OSFixes;

public class ReadFile {
	
	private final String fileName;
	private BufferedReader r;
	
	public ReadFile(String folderName, String fileName) {
		this.fileName = OSFixes.getLocation(folderName, fileName);
		try {
			this.r = new BufferedReader(
					new FileReader(this.fileName));
		} catch (FileNotFoundException e) {
			this.r = null;
			e.printStackTrace();
		}
	}
	
	

}
