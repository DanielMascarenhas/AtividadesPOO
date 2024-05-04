package Atividade;

public class Main {

	public static void main(String[] args) {
		Funcionario f1 = new Funcionario("Davi", "123454785", 1000.0);
		Presidente p1 = new Presidente("diego", "87654387", 1000.0, 50);
		
		System.out.println(f1.bonus());

		System.out.println(p1.bonus());

		

	}

}
