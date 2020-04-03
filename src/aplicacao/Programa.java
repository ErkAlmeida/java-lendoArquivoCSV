/*
 * Fazer um programa para ler o caminho de um arquivo .csv 
 *contendo os dados de itens vendidos. Cada item possui um 
 *nome, preço unitário e quantidade, separados por vírgula. 
 *Você deve gerar um novo arquivo chamado "summary.csv", localizado 
 *em uma subpasta chamada "out" a partir da pasta original do 
 *arquivo de origem, contendo apenas o nome e o valor total para 
 *aquele item (preço unitário multiplicado pela quantidade),
 */

package aplicacao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import model.entidades.Itens;

public class Programa 
{
	public static void main(String[] args)
	{
		Locale.setDefault(Locale.US);
		
		Scanner sc = new Scanner(System.in);
		
		String lerArquivo = "C:\\WorkSpace\\eclipse\\LendoArquivoCSV\\arquivos\\in.csv";
		
		List<Itens> listItens = new ArrayList<>();
		
		try (BufferedReader br = new BufferedReader(new FileReader(lerArquivo)))
		{
			String line = br.readLine();
			while(line != null)
			{
				String item[] = line.split(",");
				
				String nome = item[0];
				double preco = Double.parseDouble(item[1]);
				int quantidade = Integer.parseInt(item[2]);
				
				listItens.add(new Itens(nome, preco, quantidade));
				
				System.out.println(line);
				line = br.readLine();
			}
		}
		catch(IOException erro)
		{
			System.out.println("Erro: "+ erro.getMessage());
		}
		
		
						
		//sc.close();
	}
}
