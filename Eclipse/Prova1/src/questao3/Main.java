package questao3;
import questao2.*;

public class Main {

	public static void main(String[] args) {

		Cargo cargo1 = new Cargo("0001", 20.0);
		Cargo cargo2 = new Cargo("0002", 30.0);
		Cargo cargo3 = new Cargo("0003", 40.0);
		
		Funcionario f1 = new Funcionario(cargo1, 'M', 8);
		Funcionario f2 = new Funcionario(cargo1, 'F', 8);
		
		Empresa e1 = new Empresa("e1","000");
		e1.adicionarFuncionario(f1);
		
		//e1.adicionarFuncionario(f2);
		//e1.removerFuncionario(f1);
		//e1.mostrarFuncionarios();
		
		System.out.println(f2.salario());

		
		
		
		
		//System.out.println("Salario do homem: " + f1.salario());
		//System.out.println("Salario da mulher: " + f2.salario());
		
	}

}
