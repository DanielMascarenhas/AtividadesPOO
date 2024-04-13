package Atividade;

public class Email {
	String nome;
	String email;
	String senha;
	
	
	public Email(String nome, String email, String senha) {
		this.nome = nome;
		this.email = email;
		this.senha = senha;
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
