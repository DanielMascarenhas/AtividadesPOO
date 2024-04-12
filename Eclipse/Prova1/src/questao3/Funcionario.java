package questao3;

public class Funcionario {
	Cargo cargo;
	char sexo;
	int horasTrabalhadas;
	public Funcionario(Cargo cargo, char sexo, int horasTrabalhadas) {
		this.cargo = cargo;
		this.sexo = sexo;
		this.horasTrabalhadas = horasTrabalhadas;
	}
	

	public double salario() {
		if(sexo == 'F' || sexo == 'f') {
			double salario = horasTrabalhadas * cargo.valorHora;
			salario *= 1.2;
			return salario; 
		}
		return horasTrabalhadas * cargo.valorHora;
	}
	
	public void mostrar() {
		System.out.println("Sexo: " + sexo);
		cargo.mostrar();
		System.out.println("Horas Trabalhadas: " + horasTrabalhadas);
	}
	
	
}
