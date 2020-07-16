package lilieyun.study.thread2;

public class MyThread extends Thread {
	public void run() {
		Thread hello = new HelloThread();
		hello.start();
		try {
			hello.join();
		} catch (InterruptedException e) {
			// TODO: handle exception
			System.out.println("interrupted!");
		}
		//hello.interrupt();
	}
}
