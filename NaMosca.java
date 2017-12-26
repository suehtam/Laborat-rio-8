package lab08;
/*@author
 * Samuel Luna
 * Matheus Rodrigues
 * Ivandro Rodrigues 
 */


import java.util.InputMismatchException;
import java.util.Scanner;

public class NaMosca {

	private Produto p1, p2, p3, p4;
	private int prodt;

	public NaMosca() {
		this.p1 = new Produto();
		this.p2 = new Produto();
		this.p3 = new Produto();
		this.p4 = new Produto();
	}

	private int menu() {
		System.out.println("produtos disponiveis para a avaliacao: ");
		System.out.println("-------------------------------------------");
		System.out.println("[1] ---- produto1\n[2] ---- produto2\n[3] ---- produto3\n[4] ---- produto4");
		
		try {
			Scanner in = new Scanner(System.in);
			prodt = in.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("valores invalidos na escolha!");
		}
		return prodt;
	}

	public void opinar() {

		int prod = menu();

		switch (prod) {
		case 1:
			p1.avaliar();
			System.out.println("avaliado com sucesso!");
			retorno();
			break;

		case 2:
			p2.avaliar();
			System.out.println("avaliado com sucesso!");
			retorno();
			break;

		case 3:
			p3.avaliar();
			System.out.println("avaliado com sucesso!");
			retorno();
			break;

		case 4:
			p4.avaliar();
			System.out.println("avaliado com sucesso!");
			retorno();
			break;
		default:
			System.out.println("este produto nao existe!");
			break;
		}
	}

	public void visualizarInformacoesDoProduto() {
		System.out.println("escolha o produto a avaliar:");
		System.out.println("[1] ---- produto1\n[2] ---- produto2\n[3] ---- produto3\n[4] ---- produto4");
		System.out.println("----------------------------------------------------------------------------");
		Scanner in = new Scanner(System.in);
		int resp = in.nextInt();

		switch (resp) {
		case 1:
			p1.status();
			break;

		case 2:
			p2.status();

			break;

		case 3:
			p3.status();

			break;

		case 4:
			p4.status();

			break;
		default:
			System.out.println("este produto nao existe!");
			break;
		}
	}

	private void retorno() {
		System.out.println("deseja avaliar novamente? sim >>> [1] || nao >>> [2]");
		System.out.println("------------------------------------------------------");
		Scanner in = new Scanner(System.in);
		int resp = in.nextInt();
		if (resp == 1) {
			opinar();
		}
		System.out.println("");
	}
}
