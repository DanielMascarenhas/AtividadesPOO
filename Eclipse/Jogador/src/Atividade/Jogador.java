package Atividade;

public abstract class Jogador {
	String nome;
	
	public Jogador(String nome) {
		this.nome = nome;
	}

	public void defender(){
		System.out.println("Ok");
	}
}
