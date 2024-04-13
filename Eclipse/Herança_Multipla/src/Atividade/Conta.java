package Atividade;

public class Conta {
	String cpf;
	String senha;
	Double saldo;
	
	Conta(String cpf, String senha, Double saldo) {
			this.cpf = cpf;
			this.senha = senha;
			this.saldo = saldo;
		}
	
	void sacar(Double valor, String senha) {
		
	}
	
	void depositar(Double valor, String senha) {
		
	}

	boolean verificaSenha(String senha){
		if(this.senha == senha) {
			mensagemSucesso();
			return true;
		}
		mensagemFracasso();
		return false;
		
	}
	
	void mensagemSucesso() {
		System.out.println("Sucesso");
	}
	
	void mensagemFracasso() {
		System.out.println("Fracasso");
	}
	
	
}
