// Runnable

class MyRunnable implements Runnable {
	
	public void run() {
		go();
	}
	
	public void go() {
		// sleep throws InterruptedException
		try {
			Thread.sleep(1000);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
		
		doMore();
	}
	
	public void doMore() {
		System.out.println("top of the stack");
	}

	public static void main(String[] args) {
		Runnable threadJob = new MyRunnable();
		Thread myThread = new Thread(threadJob);
		
		myThread.start();
		
		System.out.println("back in main");
	}
}