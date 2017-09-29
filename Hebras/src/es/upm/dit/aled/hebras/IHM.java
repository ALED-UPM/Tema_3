package es.upm.dit.aled.hebras;

import java.util.Date;
import java.util.Scanner;

public class IHM {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		while (true) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			sc.nextLine();
			
			System.out.println(new Date());
		}
	}

}
