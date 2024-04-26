package Atividade;

import java.io.IOException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws IOException{
		String string;
		String path = "C:\\Users\\alunok14\\Documents\\daniel\\AtividadesPOO\\Arquivo.txt";
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Digite o que é para escrever: ");
		string = scan.nextLine();
		scan.close();
		
		AlteradorArquivo file = new AlteradorArquivo(path);
		file.escrever(string);		
		file.mostrar();
		

	}

}
