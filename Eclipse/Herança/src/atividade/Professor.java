package atividade;

public class Professor extends Pessoa{
	int matricula;
	String centro;
	
	public void darAula() {
		System.out.println("Dando aula");
	}
	public void terminarAula() {
		System.out.println("Aula terminada");
	}
	
	public void receberSalario() {
		System.out.println("Salario pago");
	}
}
