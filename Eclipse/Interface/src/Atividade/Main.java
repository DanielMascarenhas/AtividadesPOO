package Atividade;

public class Main {

	public static void main(String[] args) {
		ContaCorrente conta1 = new ContaCorrente(1000);
		ContaPoupança conta2 = new ContaPoupança(1000);
		
		conta1.rendimento();
		conta2.rendimento();
		
		System.out.println(conta1.saldo);
		System.out.println(conta2.saldo);

	}

}
