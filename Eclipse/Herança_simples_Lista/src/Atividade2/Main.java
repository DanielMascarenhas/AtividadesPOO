package Atividade2;

public class Main {

	public static void main(String[] args) {
		Estudante e1 = new Estudante("45678876", 2020, "Engenharia");
		Bolsista b1 = new Bolsista("466543", 2019, "ADS", 1000.0);
		
		System.out.println(e1.copia(10));
		System.out.println(b1.copia(10));
		
		System.out.println(b1.copiasDisponveis());
		
		

	}

}
