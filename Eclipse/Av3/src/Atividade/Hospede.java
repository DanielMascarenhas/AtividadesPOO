package Atividade;

import java.util.ArrayList;
import java.util.List;

public class Hospede extends Pessoa{
	
	private String enderecoCompleto;

	public Hospede(String cpf, String nome, String email, String senha, String enderecoCompleto) {
		super(cpf, nome, email, senha);
		this.enderecoCompleto = enderecoCompleto;
	}

	public String getEnderecoCompleto() {
		return enderecoCompleto;
	}

	public void setEnderecoCompleto(String enderecoCompleto) {
		this.enderecoCompleto = enderecoCompleto;
	}
	
	public boolean cadastrar(Hospede H) {
		
		return true;
	}
	
	public boolean editar(Hospede H) {
		
		return true;
	}
	public Hospede consultar(Hospede H) {
		return H;
	}
	
	public ArrayList<Hospede> listar(){
		List<Hospede> hospedes = new ArrayList<>();
		return null;
	}
	
	
	
	
}
