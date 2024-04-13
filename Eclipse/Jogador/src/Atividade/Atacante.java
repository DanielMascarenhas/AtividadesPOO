package Atividade;

public class Atacante extends Jogador {
	
	public Atacante(String nome) {
		super(nome);
	}
	
	@Override
	public void defender() {
		System.out.println("teste");
	}
	
	public void defender(boolean comOsPes) {
		if(comOsPes) {
			System.out.println("Ok");
		}
		else {
			System.out.println("Falta");
		}
	}
}
