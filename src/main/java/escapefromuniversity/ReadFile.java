package escapefromuniversity;

import escapefromuniversity.utilities.OSFixes;

import java.awt.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

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

	public void bho() throws IOException {
		String[] sep = newLine().split(" ");
		String ciao = sep[1];
	}
	
	

}
