package escapefromuniversity;

import escapefromuniversity.utilities.OSFixes;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

public class WriteFile {

	private final String fileName;
	private final BufferedWriter writer;

	public WriteFile(String folderName, String fileName) throws IOException {
		this.fileName = OSFixes.getLocation(folderName, fileName);
		this.writer = new BufferedWriter(new FileWriter(this.fileName));
		BufferedReader reader = new BufferedReader(new FileReader(this.fileName));
		ArrayList<String> list = new ArrayList<>();
		String line;
		while((line=reader.readLine())!=null) {
			list.add(line);
		}
		reader.close();
		list.sort(Collections.reverseOrder());
		FileWriter writer = new FileWriter(OSFixes.getLocation("score", "score.txt"));
		for(String s: list){
			writer.write(s);
			writer.write("\r\n");
		}
		writer.close();
	}

	public void writeNewLine(String line) throws IOException {
		writer.write(line);
	}

	public void close() throws IOException {
		writer.close();
	}

}
