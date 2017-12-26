package lab08;

/*@author
 * Samuel Luna
 * Matheus Rodrigues
 * Ivandro Rodrigues 
 */

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Produto {

	protected HashMap<Integer, String> status;
	static final int MAX = 140;

	Scanner in = new Scanner(System.in);

	public Produto() {
		status = new HashMap<Integer, String>();
	}

	public void avaliar() {

		int nota = 0;
		String coment = null;

		System.out.println("digite uma nota entre: ");
		System.out.println("-2 *\n-1 **\n0  ***\n1  ****\n2  *****");

		nota = in.nextInt();

		if (nota > 3) {
			nota = 2;
		}
		if (nota < -3) {
			nota = -2;
		}

		coment = this.comentario();
		System.out.println("digite valores validos!");

		status.put(nota, coment);
	}

	private String comentario() {
		System.out.println("digite o comentario: ");
		String coment = in.next();

		if (coment.length() <= MAX) {
			coment = coment;
		} else {
			coment = coment.substring(0, MAX);
		}
		return coment;
	}

	public void status() {
		System.out.println("estrategia simples >> 1\n estrategia sanzonal >> 2: ");
		Scanner in = new Scanner(System.in);
		int resp = in.nextInt();
		if (resp == 1) {
			estrategiaSimples();
		} else
			estrategiaSanzonal();
	}

	private void estrategiaSimples() {
		try {
			Integer maior = (Integer) status.keySet().toArray()[0];

			for (int i = 0; i < status.size(); i++) {
				if ((Integer) status.keySet().toArray()[i] > maior) {
					maior = (Integer) status.keySet().toArray()[i];
				}
			}

			System.out.println("media do produto: " + media());
			String valor = status.get(maior);
			System.out.println("comentario mais relevante: " + valor);
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ainda nao existem opinioes sobre estes produtos!");
		}
	}

	private void estrategiaSanzonal() {
		try {
			int size = status.size();

			System.out.println("media do produto: " + status.keySet().toArray()[size - 1]);
			System.out.println("comentario mais relevante: " + status.get(size));
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ainda ao existem opinioes sobre estes produtos!");
		}
	}

	private int media() {
		Integer nota = 0;
		int media = 0;

		for (int i = 0; i < status.size(); i++) {
			nota += (Integer) status.keySet().toArray()[i];
		}

		media = nota / status.size();
		return media;
	}
}
