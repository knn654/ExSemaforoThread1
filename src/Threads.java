import java.util.concurrent.Semaphore;

public class Threads extends Thread{
	
	private int ID;
	private Semaphore semaforo;
	private Semaphore semaforo2;
	private Semaphore semaforo3;
	
	public Threads(int ID, Semaphore semaforo, Semaphore semaforo2, Semaphore semaforo3) {
		this.ID = ID;
		this.semaforo = semaforo;
		this.semaforo2 = semaforo2;
		this.semaforo3 = semaforo3;
	}

	public void run() {
		System.out.println("Iniciando multiprocessamento - ID #" + ID);
		int valor = ID % 3;
		switch (valor) {
			case 0 :
				calculoResto0();
				break;
			case 1:
				calculoResto1();
				break;
			case 2:
				calculoResto2();
				break;
			default:
				System.out.println("Erro!");
				break;
		}
	}
	
	public void calculoResto0() {
		System.out.println("Iniciando cálculo da transação ID #" + ID);
		int tempo = (int) (Math.random() * 1001) + 1000;
		try {
			Thread.sleep(tempo);
			System.out.println("Cálculo da transação #" + ID + " finalizada.");
			semaforo.acquire();
			transacaoResto0();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}

	public void calculoResto1() {
		System.out.println("Iniciando cálculo da transação ID #" + ID);
		int tempo = (int) (Math.random() * 981) + 20;
		try {
			Thread.sleep(tempo);
			System.out.println("Cálculo da transação #" + ID + " finalizada.");
			semaforo2.acquire();
			transacaoResto1();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			semaforo2.release();
		}
	}
	
	public void calculoResto2() {
		System.out.println("Iniciando cálculo da transação ID #" + ID);
		int tempo = (int) (Math.random() * 1001) + 500;
		try {
			Thread.sleep(tempo);
			System.out.println("Cálculo da transação #" + ID + " finalizada.");
			semaforo3.acquire();
			transacaoResto2();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			semaforo3.release();
		}
		
	}
	
	public void transacaoResto0() {
		System.out.println("Iniciando transação ID #" + ID + " no banco de dados");
		int tempo = 1500;
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Transação #" + ID + " finalizada.");
	}

	public void transacaoResto1() {
		System.out.println("Iniciando transação ID #" + ID + " no banco de dados");
		int tempo = 1000;
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Transação #" + ID + " finalizada.");
	}
	
	public void transacaoResto2() {
		System.out.println("Iniciando transação ID #" + ID + " no banco de dados");
		int tempo = 1500;
		try {
			Thread.sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Transação #" + ID + " finalizada.");
	}
	
}
