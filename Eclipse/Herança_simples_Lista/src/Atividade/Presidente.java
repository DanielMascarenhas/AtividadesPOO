package Atividade;

public class Presidente extends Funcionario {
	
	private int ações;

	public Presidente(String nome, String cpf, double salario, int ações) {
		super(nome, cpf, salario);
		this.ações = ações;
	}


	public int getAções() {
		return ações;
	}

	public void setAções(int ações) {
		this.ações = ações;
	}
	
	@Override
	public double bonus() {
		return salario*(1.1);
	}
	
	
}
