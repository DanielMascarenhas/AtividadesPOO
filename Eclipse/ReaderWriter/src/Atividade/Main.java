package Atividade;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class Main {

	public static void main(String[] args) throws IOException{
		String linha = "1";
		String path = "C:\\Users\\alunok14\\Documents\\daniel\\AtividadesPOO\\Arquivo.txt";
		
		FileWriter fileWriter = new FileWriter(path);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
		
		FileReader fileReader = new FileReader(path); 
		BufferedReader bufferedReader = new BufferedReader(fileReader); 
		
		Pessoa p1 = new Pessoa("Daniel Mascarenhas", "234.567.833-08", 24);
		
		
		while(true) {
			if(linha == null) {
				linha = bufferedReader.readLine();
				bufferedWriter.write(p1.nome+ ", " +p1.cpf+ ", " +p1.idade + "\n" );		
				break;
			}
			
		}
		
		linha = "1";
		
		
		
		//FileReader fileReader = new FileReader(path); 
		//BufferedReader bufferedReader = new BufferedReader(fileReader); 
		
		while (linha != null){
			linha = bufferedReader.readLine();
			if(linha != null){
				System.out.print(linha + "\n");
			}
			
			bufferedReader.close();
			
		}
		
		bufferedReader.close();

	}

}
