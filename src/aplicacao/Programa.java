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
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
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
				Double preco = Double.parseDouble(item[1]);
				Integer quantidade = Integer.parseInt(item[2]);
				
				listItens.add(new Itens(nome, preco, quantidade));
				
				
				line = br.readLine();
			}
			System.out.println(lerArquivo +" Arquivo lido com sucesso!");
			String escreverArquivo = "C:\\WorkSpace\\eclipse\\LendoArquivoCSV\\arquivos\\out.csv";
			
			try(BufferedWriter bw = new BufferedWriter(new FileWriter(escreverArquivo)))
			{
				for(Itens list: listItens) 
				{
					bw.write(list.getNome()+","+list.total());
					System.out.println(list.getNome()+","+list.total());
					bw.newLine();
				}
				System.out.println(escreverArquivo +" Arquivo Criado!");
			}catch(IOException erro) {
				System.out.println("Erro na Escrita: "+erro.getMessage());
			}
		}
		catch(IOException erro)
		{
			System.out.println("Erro na Leitura: "+ erro.getMessage());
		}
		
		
		//sc.close();
	}
}
