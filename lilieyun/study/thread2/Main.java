package lilieyun.study.thread2;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Thread t = new MyThread();
		t.start();
		Thread.sleep(1000);
		t.interrupt();
		t.join();
		System.out.print("end");

	}

}
