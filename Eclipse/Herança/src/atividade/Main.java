package atividade;

public class Main {

	public static void main(String[] args) {
		Professor professor = new Professor();
		
		professor.idade = 20;
		professor.fazerAniversario();
		System.out.println(professor.idade);
		
		professor.receberSalario();
		
	
	}

}
