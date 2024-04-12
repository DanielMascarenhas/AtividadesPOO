package Atividade;

public class ContaPoupança implements Conta_bancaria{

	double saldo;
	
	public ContaPoupança() {
		saldo = 0;
	}
	public ContaPoupança(double saldo) {
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
		saldo += ( 0.01 * saldo);
	}
	
}
