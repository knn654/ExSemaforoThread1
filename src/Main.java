import java.util.concurrent.Semaphore;


public class Main {
public static Semaphore semaforo;
public static Semaphore semaforo2;
public static Semaphore semaforo3;
	
	public static void main(String[] args) {
		
		int totalTransacoes = 21;
		int maxTransacoes = 1;
		semaforo = new Semaphore(maxTransacoes);
		semaforo2 = new Semaphore(maxTransacoes);
		semaforo3 = new Semaphore(maxTransacoes);
		
		for (int i = 0; i < totalTransacoes; i++) {
			Thread iniciarTransacoes = new Threads(i, semaforo, semaforo2, semaforo3);
			iniciarTransacoes.start();
		}
	}
}
