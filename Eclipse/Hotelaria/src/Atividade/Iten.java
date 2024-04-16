package Atividade;

public class Iten {
	
	String nome;
	double preço;
	
	public Iten(String nome, double preço) {
		this.nome = nome;
		this.preço = preço;
	}
	
	public void Mostrar(){
		System.out.println("ITEN:");
		System.out.println("nome: " + nome);
		System.out.println("preço: " + preço);
	}
}
