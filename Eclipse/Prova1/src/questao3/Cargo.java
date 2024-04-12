package questao3;

public class Cargo {
	String numero;
	double valorHora;
	
	public Cargo(String numero, double valorHora) {
		this.numero = numero;
		this.valorHora = valorHora;
	}
	
	public void mostrar() {
		System.out.println("Numero do cargo: " + numero);
		System.out.println("Valor da hora do cargo: " + valorHora);
	}

	
}
