package questao2;
import java.util.List;
import java.util.ArrayList;

public class Empresa {
	List<Funcionario> Funcionarios = new ArrayList<>();
	String nome;
	String cnpj;
	
	public Empresa(String nome, String cnpj) {
		this.nome = nome;
		this.cnpj = cnpj;
	}
	public void adicionarFuncionario(Funcionario funcionario) {
		Funcionarios.add(funcionario);
	}
	public void removerFuncionario(Funcionario funcinario) {
		Funcionarios.remove(funcinario);
	}
	
	public void mostrarFuncionarios() {
		for(int i = 0; i < Funcionarios.size() ; i++ ) {
			Funcionarios.get(i).mostrar();
		}
	}

}
