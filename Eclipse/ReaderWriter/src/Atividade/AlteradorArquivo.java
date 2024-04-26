package Atividade;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class AlteradorArquivo {
	String path;

		public AlteradorArquivo(String path) {
		this.path = path;
	}
		
		public void escrever(String dado) throws IOException{
			String linha;
			
			FileWriter fileWriter = new FileWriter(path,true);
			BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
			
			FileReader fileReader = new FileReader(path); 
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			
			
			while(true) {
				linha = bufferedReader.readLine();
				if(linha == null) {
					bufferedWriter.write(dado);
					bufferedWriter.close();
					break;
				}
				bufferedWriter.newLine();
			}	
			bufferedReader.close();

			
		}
		
		public void mostrar() throws IOException {
			FileReader fileReader = new FileReader(path); 
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			String linha = bufferedReader.readLine();
			
			while(linha != null) {
				System.out.println(linha);
				linha = bufferedReader.readLine();
			}
				
			
			
			bufferedReader.close();
		}
		
	
	
}
