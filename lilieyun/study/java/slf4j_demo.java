package lilieyun.study.java;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

public class slf4j_demo {

	public static void main(String[] args) {
		Logger log = LoggerFactory.getLogger(slf4j_demo.class);
		/*String strA="A";
		String strB="B";
		logger.debug("{},{}",strA,strB);
	    logger.info("hellow slf4j");*/
		
		log.trace("======trace");  
        log.debug("======debug");  
        log.info("======info");  
        log.warn("======warn");  
        log.error("======error");  

	}

}
