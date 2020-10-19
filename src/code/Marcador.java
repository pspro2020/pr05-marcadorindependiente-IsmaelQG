package code;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

public class Marcador {
	
	private int[] marcador = new int[6];
	private Object[] diceLock = new Object[6];
	
	public Marcador(int n) {
		final MyThreadFactory threadFactory = new MyThreadFactory("MyThreadFactory");
		ArrayList<Thread> threads = new ArrayList<>();
		
		for(int i = 0; i <= 5; i++) {
			diceLock[i] = new Object();
		}
		
		for(int i = 0; i < n; i++) {
			Thread thread = threadFactory.newThread(new Dice(this));
			threads.add(thread);
			thread.start();
		}
		
		for (Thread thread : threads) {
            try {
                thread.join();
            }
            catch (InterruptedException exception) {
                return;
            }
		}
		
		int total = 0;
				
		for(int m: marcador) {
			total += m;
		}
		
		System.out.print("Número 1: " + marcador[0] +
						 "\nNúmero 2: " + marcador[1] +
						 "\nNúmero 3: " + marcador[2] +
						 "\nNúmero 4: " + marcador[3] +
						 "\nNúmero 5: " + marcador[4] +
						 "\nNúmero 6: " + marcador[5]);
		
		System.out.printf("\n\nTotal de veces: %d + %d + %d + %d + %d + %d = %d", marcador[0], marcador[1], marcador[2], marcador[3], marcador[4], marcador[5], total);
	}
	
	public void increment() {
		switch(ThreadLocalRandom.current().nextInt(1,7)) {
		case 1:
			synchronized(diceLock[0]){
				marcador[0]++;
			}
			break;
		case 2:
			synchronized(diceLock[1]){
				marcador[1]++;
			}
			break;
		case 3:
			synchronized(diceLock[2]){
				marcador[2]++;
			}
			break;
		case 4:
			synchronized(diceLock[3]){
				marcador[3]++;
			}
			break;
		case 5:
			synchronized(diceLock[4]){
				marcador[4]++;
			}
			break;
		case 6:
			synchronized(diceLock[5]){
				marcador[5]++;
			}
			break;
		}
	}

}
