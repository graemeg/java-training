/*
 * Compile: javac -sourcepath src -d target src/playground/concurrency/SemaphoreDemo.java
 * Run: java -cp target playground.concurrency.SemaphoreDemo
 */
package playground.concurrency;

import java.util.concurrent.Semaphore;

/**
 * An example of using the {@code java.util.concurrent.Semaphore} class.
 * <p>
 * Example output:
 *
 * <pre>
Starting thread - A
Acquiring permit - A
Permit acquired - A
Starting thread - B
Acquiring permit - B
Share value increase to 6 - A
Share value increase to 7 - A
Share value increase to 8 - A
Share value increase to 9 - A
Share value increase to 10 - A
Releasing permit - A
Stopping thread - A
Permit acquired - B
Share value decreased to 9 - B
Share value decreased to 8 - B
Share value decreased to 7 - B
Share value decreased to 6 - B
Share value decreased to 5 - B
Releasing permit - B
Stopping thread - B
 * </pre>
 */

public class SemaphoreDemo {

	public static void main(String[] args) {
		Semaphore sem = new Semaphore(1);
		new IncThread(sem, "A");
		new DecThread(sem, "B");
	}

}

/**
 * This is an example shared resource
 */
class Shared {
	static int value = 5;

	private Shared() {
		// simply hides it from the world
	}

}

/**
 * Abstract worker thread to reduce code duplication
 */
abstract class WorkerThread implements Runnable {

	protected Semaphore semaphore;
	protected String threadName;

	protected WorkerThread(Semaphore sem, String threadName) {
		super();
		semaphore = sem;
		this.threadName = threadName;
		new Thread(null, this, threadName).start();
	}

	protected abstract void doWork();

	public void run() {
		System.out.println("Starting thread - " + threadName);
		System.out.println("Acquiring permit - " + threadName);
		try {
			semaphore.acquire();
		} catch (InterruptedException e) {
			System.out.println(String.format("Thread %s interrupted", threadName));
		}
		System.out.println("Permit acquired - " + threadName);

		doWork();

		System.out.println("Releasing permit - " + threadName);
		semaphore.release();
		System.out.println("Stopping thread - " + threadName);
	}

}

/**
 * Worker thread that will increase the value of the shared resource.
 **/
class IncThread extends WorkerThread {

	public IncThread(Semaphore sem, String threadName) {
		super(sem, threadName);
	}

	@Override
	protected void doWork() {
		for (int i = 0; i < 5; i++) {
			Shared.value++;
			System.out.println("Share value increase to " + Shared.value + " - " + threadName);
		}
	}

}

/**
 * Worker thread that will decrease the value of the shared resource.
 **/
class DecThread extends WorkerThread {

	public DecThread(Semaphore sem, String threadName) {
		super(sem, threadName);
	}

	@Override
	protected void doWork() {
		for (int i = 0; i < 5; i++) {
			Shared.value--;
			System.out.println("Share value decreased to " + Shared.value + " - " + threadName);
		}
	}

}

// jedit settings :elasticTabstops=true:encoding=UTF-8:
