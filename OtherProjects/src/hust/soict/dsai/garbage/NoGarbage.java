package hust.soict.dsai.garbage;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Random;

public class NoGarbage {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		String filename = "test.exe";
		byte[] inputBytes = { 0 };
		long startTime, endTime;
		
		inputBytes = Files.readAllBytes(Paths.get(filename));
		startTime = System.currentTimeMillis();
		String outputString = "";
		for (byte b : inputBytes) {
			outputString += (char)b;
		}
		
//		StringBuilder outputStringBuilder = new StringBuilder();
//		for (byte b : inputBytes) {
//			outputStringBuilder.append((char)b);
//		}
		
		endTime = System.currentTimeMillis();
		System.out.println(endTime - startTime);
	}

}
