package Atividade;

public class Cliente extends Pessoa {
	String cartão;
	double fatura;

	public Cliente(String nome, String cpf, String cartão) {
		super(nome, cpf);
		this.cartão = cartão;
		fatura = 0;
	}
	
	
}
