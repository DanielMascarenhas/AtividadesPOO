package Atividade;

public class Serviço {
	String nome;
	double custo;
	
	public Serviço(String nome, double custo) {
		this.nome = nome;
		this.custo = custo;
	}

	public double executarServiço() {
		return custo;
	}
}
