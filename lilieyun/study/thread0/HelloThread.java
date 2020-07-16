package lilieyun.study.thread0;

public class HelloThread extends Thread {
	public volatile boolean running = true;
	int n = 0;

	public void run() {
		while (running) {
			n++;
			System.out.println(n + " hello!");
		}
		System.out.println("end!");
	}

}
