package questao3;

import java.util.ArrayList;
import java.util.List;


public class Empresa {
		List<Funcionario> funcionarios = new ArrayList<>();
		String nome;
		String cnpj;
		
		public Empresa(String nome, String cnpj) {
			this.nome = nome;
			this.cnpj = cnpj;
		}
		public void adicionarFuncionario(Funcionario funcionario) {
			funcionarios.add(funcionario);
		}
		public void removerFuncionario(Funcionario funcionario) {
			funcionarios.remove(funcionario);
		}
		
		public void mostrarFuncionarios() {
			//for(int i = 0; i < funcionarios.size() ; i++ ) {
			//	Funcionarios.get(i).mostrar();
			//}
		
			//Equivalente à:
			for(Funcionario func: funcionarios) { 
				func.mostrar();
			}
		}
}
