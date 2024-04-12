package App;

import java.util.Scanner;

import teste.*;

public class Main {
	public static void main(String[] args) {
	//	Scanner scan = new Scanner(System.in);

//		char a = 4000;
//		int div1 = 20 / 3;
//		Double div2 = 20.0 / 3.0;
//		System.out.println(div1 + " , " + div2);

//		System.out.print("Digite um Numero qualquer:");
//		int Num1 = scan.nextInt();
//		System.out.println(Num1 + " + 2 = " + (Num1 + 2));

		Liquidificador	l1 = new Liquidificador();
		//l1.marca = "arno";
		l1.setMarca("arno");
		//l1.cor = "prata";	
		l1.setCor("prata");
		//l1.velocidade = 3;
		l1.setVelocidade(3);
		//l1.tampado = false;
		l1.setTampado(false);
		
		Liquidificador l2 = new Liquidificador(); 
				//l2.marca = "tramontina";
		l2.setMarca("tramontina");
		       // l2.cor = "preto";
		l2.setCor("preto");
		       // l2.velocidade = 4;
		l2.setVelocidade(4);
		       // l2.tampado = true;
		l2.setTampado(true);
		Liquidificador l3 = new Liquidificador ("arno","prata",3,false);
		/*
		l1.tampar();     
		l1.liquificar();
		l2.liquificar();
		l2.status();
		*/
		Loja Amazon = new Loja("Amazon",1980,l1);
		Loja Saraiva = new Loja("Saraiva",1985,l2);
		
		System.out.println("Escrevendo Status amazon: ");
		Amazon.status();
		System.out.println("\r\nEscrevendo Status Saraiva ");
		Saraiva.status();
		
		System.out.println("\r\nAdicionando l2 em Amazon");
		Amazon.adicionarLiquidificador(l2);
		
		System.out.println("\r\nListando liquidificadores em Amazon: ");
		Amazon.listarLiquidificadores();
		
		System.out.println("\r\nMostranho tamanho de Liquidificadores em Amazon: ");
		int T= Amazon.tamanhoLiquidificadores();
		System.out.println("Tamanho lista: "+ T);
		
		System.out.println("\r\nRemovendo Liquidificador índice zero Amazon");
		Amazon.removerLiquidificador(0);
		
		System.out.println("\r\nListando Liquidificadores Amazon: ");
		Amazon.listarLiquidificadores();
		T= Amazon.tamanhoLiquidificadores();
		System.out.println("Tamanho lista: "+ T);
		
		
		
		 
		  
		  
	}
}
