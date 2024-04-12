package Atividade;

public class ContaCorrente implements Conta_bancaria{
	double saldo;
	
	public ContaCorrente() {
		saldo = 0;
	}
	public ContaCorrente(double saldo) {
		this.saldo = saldo;
	}

	@Override
	public void sacar(double valor) {
		saldo -= valor;
	}
	@Override
	public void depositar(double valor) {
		saldo += valor;
	}
	@Override
	public void rendimento() {
		saldo += ( 0.01/100 * saldo);
	}
}
