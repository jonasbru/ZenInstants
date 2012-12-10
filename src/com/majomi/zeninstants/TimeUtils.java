package com.majomi.zeninstants;


public class TimeUtils {
	
	/**
	 * noisyWait return between minTime and minTime+noise milliseconds
	 * @param minTime :minimum time to wait in milliseconds
	 * @param noise: time during which the noisyWait must wakeUp 
	 */
	public void noisyWait(Integer minTime, Integer noise){
		synchronized (this){
			try {
				wait(minTime + Math.round (noise * Math.random()));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void noisyWait(Integer min){
			
		noisyWait(min, 1/3 * min);
	}
}
