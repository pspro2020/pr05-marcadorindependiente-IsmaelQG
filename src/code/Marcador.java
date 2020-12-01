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
		
		System.out.print("Número 1: " + marcador[0] +
						 "\nNúmero 2: " + marcador[1] +
						 "\nNúmero 3: " + marcador[2] +
						 "\nNúmero 4: " + marcador[3] +
						 "\nNúmero 5: " + marcador[4] +
						 "\nNúmero 6: " + marcador[5]);
		
		System.out.printf("\n\nTotal de veces: %d + %d + %d + %d + %d + %d = %d", marcador[0], marcador[1], marcador[2], marcador[3], marcador[4], marcador[5], total);
	}
	
	public void increment() {
		int random = ThreadLocalRandom.current().nextInt(0,6);
		synchronized(diceLock[random]) {
			marcador[random]++;
		}
	}

}
