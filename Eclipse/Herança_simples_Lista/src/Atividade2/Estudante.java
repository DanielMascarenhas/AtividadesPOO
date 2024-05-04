package Atividade2;

public class Estudante {
	protected String matricula;
	protected int ano_ingresso;
	protected String curso;
	
	public Estudante(String matricula, int ano_ingresso, String curso) {
		this.matricula = matricula;
		this.ano_ingresso = ano_ingresso;
		this.curso = curso;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public int getAno_ingresso() {
		return ano_ingresso;
	}

	public void setAno_ingresso(int ano_ingresso) {
		this.ano_ingresso = ano_ingresso;
	}

	public String getCurso() {
		return curso;
	}

	public void setCurso(String curso) {
		this.curso = curso;
	}
	 
	public double copia(int numero_de_paginas) {
		return numero_de_paginas*(0.1);
	}
	
	
	
}
