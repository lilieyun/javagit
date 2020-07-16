package lilieyun.study.thread2;

public class HelloThread extends Thread {
	public void run() {
		int n=0;
		while(!isInterrupted()) {
			n++;
			System.out.println(n+" hello!");
			try {
				Thread.sleep(100);
			} catch (InterruptedException e) {
				break;
			}			
		}
	}

}
