package lilieyun.study.thread1;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Thread t = new MyThread();
		t.start();
		long beginTime = System.currentTimeMillis();
		Thread.sleep(100);
		long endTime = System.currentTimeMillis();
		System.out.println("sleepÊ±¼äÎª:" + (endTime - beginTime));
		t.interrupt();
		t.join();
		System.out.println("end");
	}

}
