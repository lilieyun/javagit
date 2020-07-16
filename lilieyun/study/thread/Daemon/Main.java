package lilieyun.study.thread.Daemon;

import java.util.concurrent.TimeUnit;

public class Main {

	public static void main(String[] args) throws InterruptedException {
		Runtime.getRuntime().addShutdownHook(new Thread(()->
			System.out.println("The JVM exit success !!!!")));
		Thread thread = new Thread(() -> {
			while (true) {
				try {
					TimeUnit.SECONDS.sleep(1);
					System.out.println("I am running...");
				} catch (Exception e) {
					// TODO: handle exception
				}
			}
		});
		thread.setDaemon(true);
		thread.start();
		TimeUnit.SECONDS.sleep(2);
		System.out.println("The main thread aready to exit...");	

	}

}
