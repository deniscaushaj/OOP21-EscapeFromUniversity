package escapefromuniversity;

import escapefromuniversity.utilities.OSFixes;

import java.io.*;
import java.nio.Buffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

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

//	public void prependPrefix(String newLine) throws IOException {
//		Path oldFile = Paths.get(OSFixes.getLocation("score", "score.txt"));
//		Path tempFile = Files.createTempFile(Path.of(OSFixes.getLocation("score", "")), "score", ".txt");
//		try(BufferedReader r = Files.newBufferedReader(oldFile); PrintWriter w = new PrintWriter(Files.newBufferedWriter(tempFile))) {
//			w.write(newLine);
//			String line = null;
//			while((line=r.readLine())!=null) {
//				w.write(line);
//				w.write("\n");
//			}
//			Files.copy(tempFile, oldFile, StandardCopyOption.COPY_ATTRIBUTES);
//			Files.delete(tempFile);
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
//	}

}
