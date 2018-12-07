package RobotFile;

public class Wheel implements Runnable {
	
	private Spark FirstWheel;
	
		public Wheel(int channel) {
		FirstWheel = new Spark(channel);
		startWheel();
	}


	private boolean running = false;
	
	
	
	private void startWheel() {
		
		synchronized (this) {
			
			if (running) {
				
				return;
			}
			
			running = true;
			
			/*
			 * This code below creates a thread.
			 * 
			 * The first parameter, "this" is basically Wheel.java
			 * 
			 * The second parameter, "wheelThread", is a string which is the the thread's name
			 */
			
			new Thread(this, "wheelThread").start();
		}
	}
		
		@Override
		public void run() {
			while (running) {
				/*
				 * This code is where the code interacts with Spark.
				 */
				FirstWheel.set(0.6);
				
				
			}
			
			try {
					Thread.sleep(1000);
			}
			catch (InterruptedException w) {
					w.printStackTrace();
			}
		}
	
	public boolean getRunning() {
		return running;
	}
	
	public void stop() {
		FirstWheel.set(0);
	}
}
