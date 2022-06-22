package escapefromuniversity;

import escapefromuniversity.utilities.OSFixes;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class WriteFile {

	private final String fileName;
	private final BufferedWriter writer;
	private ArrayList<String> list;

	public WriteFile(String folderName, String fileName) throws IOException {
		this.fileName = OSFixes.getLocation(folderName, fileName);
		this.writer = new BufferedWriter(new FileWriter(this.fileName));
	}

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

	public void close() throws IOException {
		this.writer.close();
	}

}
