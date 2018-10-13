package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Pedido;
import services.Leitor;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Pedido> listaPedido = new ArrayList<>();

		System.out.println("ENTRE COM O CAMINHO DO ARQUIVO FONTE: ");
		String filePath = sc.nextLine();
		Leitor.lerArq(filePath, listaPedido);

		sc.close();

	}

}
