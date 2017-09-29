package es.upm.dit.aled.ex2017;

import java.util.Random;

public class GestorPPQTest {
		
	private static class P implements Runnable {
		private GestorPPQ gestor;
		
		protected P (GestorPPQ gestor) {
			this.gestor = gestor;
		}
		
		public void run() {
			while (true) {
				gestor.entraP();
				System.out.print("P");
				gestor.sale();
			}		
		}		
	}
	
	private static class Q implements Runnable {
		private GestorPPQ gestor;
		
		protected Q (GestorPPQ gestor) {
			this.gestor = gestor;
		}
		
		public void run() {
			while (true) {
				gestor.entraQ();
				System.out.print("Q");
				gestor.sale();
			}		
		}		
	}
	
	public static void main(String[] args) {
				
		GestorPPQ gestor = new GestorPPQ();
		new Thread(new P(gestor)).start();
		new Thread(new Q(gestor)).start();	
	
	}

}
