package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Pedido;
import entities.Produto;

public class Program {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		List<Pedido> listaPedido = new ArrayList<>();
		Double totalPedido = 0.00;

		System.out.println("ENTRE COM O CAMINHO DO ARQUIVO FONTE: ");
		String filePath = sc.nextLine();

		try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
			String linha = br.readLine();

			while (linha != null) {
				String[] vetor = linha.split(",");
				String nomeProd = vetor[0];
				Double precoUnit = Double.parseDouble(vetor[1]);
				Integer qtd = Integer.parseInt(vetor[2]);
				Produto produto = new Produto(nomeProd, precoUnit);
				Pedido pedido = new Pedido(qtd, produto);
				listaPedido.add(pedido);
				totalPedido += pedido.subTotal();
				linha = br.readLine();
			}

		} catch (IOException e) {
			System.out.println("ERRO: " + e.getMessage());
		}

		try (BufferedWriter bw = new BufferedWriter(new FileWriter("c:\\temp\\resumo.txt"))) {
			for (Pedido pedido : listaPedido) {
				bw.write(pedido.toString());
				bw.newLine();
			}

			bw.write("VALOR TOTAL DO PEDIDO:" + totalPedido.toString());

		} catch (IOException e) {
			System.out.println("ERRO: " + e.getMessage());
		}

		sc.close();

	}

}
