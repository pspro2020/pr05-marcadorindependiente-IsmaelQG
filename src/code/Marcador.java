package code;

import java.util.concurrent.ThreadLocalRandom;

public class Marcador {
	
	private int[] marcador = new int[6];
	private Object[] diceLock = new Object[6];
	int total = 0;
	
	public Marcador() {
		for(int i = 0; i <= 5; i++) {
			diceLock[i] = new Object();
		}
	}
	
	public void showResults() {
		for(int m: marcador) {
			total += m;
		}
		
		System.out.print("N�mero 1: " + marcador[0] +
						 "\nN�mero 2: " + marcador[1] +
						 "\nN�mero 3: " + marcador[2] +
						 "\nN�mero 4: " + marcador[3] +
						 "\nN�mero 5: " + marcador[4] +
						 "\nN�mero 6: " + marcador[5]);
		
		System.out.printf("\n\nTotal de veces: %d + %d + %d + %d + %d + %d = %d", marcador[0], marcador[1], marcador[2], marcador[3], marcador[4], marcador[5], total);
	}
	
	public void increment() {
		int random = ThreadLocalRandom.current().nextInt(0,6);
		synchronized(diceLock[random]) {
			marcador[random]++;
		}
	}

}
