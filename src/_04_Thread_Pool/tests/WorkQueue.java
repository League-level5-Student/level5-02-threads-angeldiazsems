package _04_Thread_Pool.tests;

import java.lang.Thread.State;
import java.util.ArrayDeque;

public class WorkQueue implements Runnable {
	private Thread[] threat;
	private volatile boolean isRunning = false;
	private ArrayDeque<Job> jobQueue = new ArrayDeque<Job>();

	public WorkQueue() {
		int totalThreads = Runtime.getRuntime().availableProcessors() - 1;
		threat = new Thread[totalThreads];
		for (int i = 0; i < threat.length; i++) {
			threat[i] = new Thread(this);
			threat[i].start();
		}

	}

	public int getThreadCount() {
		return threat.length;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (isRunning) {
			if(!preformJob()) {
				
			
			synchronized (jobQueue) {
				try {
					jobQueue.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}

		}
		}

	}

	public void addJob(Job j) {

		synchronized (jobQueue) {
			jobQueue.add(j);
			jobQueue.notify();

		}

	}

	public void shutdown() {
		completeAllJobs();
		isRunning = false;
		synchronized (jobQueue) {
			jobQueue.notifyAll();
		}
	}

	public boolean preformJob() {
		Job j = null;
		synchronized (jobQueue) {
			if (!jobQueue.isEmpty()) {
				j = jobQueue.remove();

			}
			if (j != null) {
				j.preform();
				return true;
			} else {
				return false;
			}

		}
	}
	public void completeAllJobs() {
		while(!jobQueue.isEmpty()) {
			preformJob();
		}
		
		for(int i = 0 ; i < threat.length; i++) {
			if(threat[i].getState() != State.WAITING) {
				i = -1;
			}
		}
		
		
		
	}
}
