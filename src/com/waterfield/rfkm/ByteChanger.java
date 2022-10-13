package com.waterfield.rfkm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ByteChanger {
public static void main(String[] args) {

		File ifile = new File("C:\\Users\\RobertMartin\\eclipse-workspace\\ByteChanger.zip");
		File ofile = new File("C:\\Users\\RobertMartin\\eclipse-workspace\\ByteChanger.piz");
		FileOutputStream fos = null;
		FileInputStream fis = null;
		try {
			// create FileInputStream object
			fis = new FileInputStream(ifile);
			fos = new FileOutputStream(ofile);
			byte inContent[] = new byte[(int)ifile.length()];
			byte outContent[] = new byte[(int)ifile.length()];

			// Reads up to certain bytes of data from this input stream into an array of bytes.
			fis.read(inContent);
			//create string from byte array
			int i = 0;
			for (byte b : inContent) {
				byte a = (byte) (0xff-b);
				outContent[i++]=a;
			}
			fos.write(outContent);
		}
		catch (FileNotFoundException e) {
			System.out.println("FileNotFound: " + e);
		}
		catch (IOException e) {
			System.out.println("IOException while reading: " + e);
		}
		finally {
			// close the streams using close method
			try {
				if (fis != null) {
					fis.close();
				}
				if (fos != null) {
					fos.close();
				}
			}
			catch (IOException e) {
				System.out.println("IOException while closing: " + e);
			}
		}
	}
}
