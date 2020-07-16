package lilieyun.study.java;

import java.io.File;

public class LibPath {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	  // String path=System.getProperty("java.library.path");
	  // System.out.println("java¿âµÄÂ·¾¶£º");
      //System.out.println(path);	
		 /*String fillUpProperty = System
	                .getProperty("ABC");*/
		String abcDir="abcDir\\test.txt";
		 System.out.println("abcDir");
		 File asciidata = new File(abcDir);
	        if (!asciidata.exists() && !asciidata.mkdirs()) {
	            System.out.println("Could not create logger directory: " + asciidata.getAbsolutePath());
	            // TODO: weitere Behandlung,
	        }

	}

}
