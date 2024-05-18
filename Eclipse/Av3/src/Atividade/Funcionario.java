package Atividade;

import java.util.ArrayList;
import java.util.List;

public class Funcionario {
	
	private String setor;

	public Funcionario(String setor) {
		super();
		this.setor = setor;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}
	
	public boolean cadastrar(Funcionario F) {
		
		return true;
	}
	
	public boolean editar(Funcionario F) {
		
		return true;
	}
	public Funcionario consultar(Funcionario F) {
		return F;
	}
	
	public ArrayList<Funcionario> listar(){
		List<Funcionario> funcionarios = new ArrayList<>();
		return null;
	}
	
}
