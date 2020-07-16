package lilieyun.study.thread0;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		 HelloThread t = new HelloThread();
	        t.start();
	        Thread.sleep(100);
	        t.running = false; // 标志位置为false

	}

}
