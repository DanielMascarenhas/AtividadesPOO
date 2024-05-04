package Atividade2;

public class Bolsista extends Estudante{
	protected double valor_bolsa;

	public Bolsista(String matricula, int ano_ingresso, String curso, double valor_bolsa) {
		super(matricula, ano_ingresso, curso);
		this.valor_bolsa = valor_bolsa;
	}
	
	@Override
	public double copia(int numero_de_paginas) {
		return numero_de_paginas*(0.07);
	}
	
	public double copiasDisponveis() {
		return valor_bolsa/(0.07);
	}
	
}
