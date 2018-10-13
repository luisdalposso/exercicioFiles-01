package services;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import entities.Pedido;

public class Escritor {
	public static void escreverArq(List<Pedido> listaPedido, Double totalPedido) {

		try (BufferedWriter bw = new BufferedWriter(new FileWriter("c:\\temp\\resumo.txt"))) {
			for (Pedido pedido : listaPedido) {
				bw.write(pedido.toString());
				bw.newLine();
			}

			bw.write("VALOR TOTAL DO PEDIDO:" + totalPedido.toString());

		} catch (IOException e) {
			System.out.println("ERRO: " + e.getMessage());
		}

	}
}
