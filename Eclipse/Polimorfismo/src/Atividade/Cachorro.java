package Atividade;

public class Cachorro extends Animal{
	protected boolean corre;

	public Cachorro(String nome, int idade, boolean corre) {
		super(nome, idade);
		this.corre = corre;
	}

	public boolean isCorre() {
		return corre;
	}

	public void setCorre(boolean corre) {
		this.corre = corre;
	}
	
	public void som() {
		System.out.println("AU AU");
	}
}
