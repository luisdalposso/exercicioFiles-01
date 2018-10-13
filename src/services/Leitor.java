package services;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import entities.Pedido;
import entities.Produto;

public class Leitor {
	public static void lerArq(String filePath, List<Pedido> listaPedido) {
		Double totalPedido = 0.00;

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

		Escritor.escreverArq(listaPedido, totalPedido);

	}
}