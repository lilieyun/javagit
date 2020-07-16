package lilieyun.study.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;


public class datalogger_log {
	private static void appendStrings(StringBuilder sb, String... s) {

		for (String element : s) {
			sb.append(element);
		}
	}
	
	/**
     * This method adds a string value up with blank spaces from left to right.
     * 
     * @param sb
     *            StringBuilder in wich the spaces will appended
     * @param number
     *            the number of spaces
     */
    public static void appendSpaces(StringBuilder sb, int number) {

        for (int i = 0; i < number; ++i) {
            sb.append(' ');
        }
    }

	public static void main(String[] args) throws IOException {
		// 1
		/*
		 * HashMap<List<Integer>, String> logIntervalGroups = new HashMap<>();
		 * List<Integer> intList1=Arrays.asList(1,11); List<Integer>
		 * intList2=Arrays.asList(2,22);
		 * 
		 * logIntervalGroups.put(intList1, "one"); if
		 * (logIntervalGroups.containsKey(intList1)) { System.out.println("intList1");
		 * 
		 * }; //logIntervalGroups.put(intList2, "two"); if
		 * (logIntervalGroups.containsKey(intList2)) { System.out.println("intList2");
		 * 
		 * }
		 */

		// 2
		/*
		 * StringBuilder sb=new StringBuilder(); appendStrings(sb,"one","two","three");
		 * System.out.println(sb.toString());
		 */
		// 3
		/*String filename = "test.dat";

		File file = new File(filename);
		// File actualFile = file;
		PrintStream out = null;

		try {
			if (file.exists()) {
				out = new PrintStream(new FileOutputStream(file, true), false, "UTF-8");
			} else {
				out = new PrintStream(new FileOutputStream(file, true), false, "US-ASCII");
				String headerString = "C1Äæ±äÆ÷";

				out.print(headerString);
				out.flush();
			}
		} catch (UnsupportedEncodingException e) {

		
		} catch (FileNotFoundException e) {

		}*/
		//4
		String filename = "test.dat";
		File file = new File(filename);
		try {
			String lastLogLine = "";
			RandomAccessFile raf =new RandomAccessFile(filename , "r");
			byte[] readedByte = new byte[1];
			long filePosition = file.length() - 2;
			String charString;
			while (lastLogLine.isEmpty() && filePosition > 0) {

				raf.seek(filePosition);
				int readedBytes = raf.read(readedByte);
				if (readedBytes == 1) {
					charString = new String(readedByte, "UTF-8");

					if (charString.equals("\n")) {
						lastLogLine = raf.readLine();
					} else {
						filePosition -= 1;
					}
				} else {
					filePosition = -1; // leave the while loop
				}
			}
			
			String lineArray[] = lastLogLine.split(Const.SEPARATOR);
			
			StringBuilder errorValues = new StringBuilder();
	        int arrayLength = lineArray.length;
	        int errorCodeLength = Const.ERROR.length() + 2;
	        int separatorLength = Const.SEPARATOR.length();
	        int length = 0;

	        for (int i = 3; i < arrayLength; ++i) {

	            length = lineArray[i].length(); //9
	            length -= errorCodeLength;      //4
	            if (i == arrayLength - 1) {
	                length -= separatorLength;
	            }
	            
	            System.out.println(length);
	            appendSpaces(errorValues, length);
	            errorValues.append(Const.ERROR);
	            errorValues.append("32");

	            if (i < arrayLength - 1) {
	                errorValues.append(Const.SEPARATOR);
	            }
	            
	        }
	        
	        

			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
