package code;

import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		Marcador marcador = new Marcador();
		
		final MyThreadFactory threadFactory = new MyThreadFactory("MyThreadFactory");
		List<Thread> threads = new ArrayList<>();
		
		for(int i = 0; i < 3; i++) {
			Thread thread = threadFactory.newThread(new Dice(marcador));
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
		
		marcador.showResults();
		
	}

}
