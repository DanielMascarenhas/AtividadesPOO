package Atividade;

public class Bixo_preguiça extends Animal{
	protected boolean escala;

	public Bixo_preguiça(String nome, int idade, boolean escala) {
		super(nome, idade);
		this.escala = escala;
	}

	public boolean isEscala() {
		return escala;
	}

	public void setEscala(boolean escala) {
		this.escala = escala;
	}
	
	public void som() {
		System.out.println("(Sons que um bixo preguiça deveria fazer) ");
	}
	
}
