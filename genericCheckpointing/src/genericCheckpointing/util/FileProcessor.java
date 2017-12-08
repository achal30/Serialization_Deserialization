package genericCheckpointing.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.IOException;

/**
 * 
 * @author Achal
 *
 */
public class FileProcessor {

	private BufferedReader br;
	private BufferedWriter bw;

	/**
	 * 
	 * @param input
	 * @param output
	 */
	public FileProcessor(BufferedReader brIn) {
		br = brIn;

	}

	public FileProcessor(BufferedWriter bwIn) {
		bw = bwIn;

	}

	/**
	 * reads line from the file
	 * 
	 * @return
	 * @throws IOException
	 */
	public String readLine() throws IOException {
		return br.readLine();
	}

	/**
	 * writes a line to the file
	 * 
	 * @param line
	 * @throws IOException
	 */
	public void write(String line) throws IOException {
		bw.write(line + "\n");
		// System.out.println(line);
	}
	
	/**
	 * closes the file
	 * 
	 * @throws IOException
	 */
	public void close() throws IOException {
		if (br != null)
			br.close();
		if (bw != null)
			bw.close();
	}
}
