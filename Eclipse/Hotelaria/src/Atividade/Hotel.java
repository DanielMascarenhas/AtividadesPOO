package Atividade;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

	String nome;
	List<Quarto> quartos = new ArrayList<>();
	List<Cliente> clientes = new ArrayList<>();
	List<Funcionario> funcionarios = new ArrayList<>();
	List<Serviço> serviços = new ArrayList<>();
	
	public Hotel(String nome) {
		this.nome = nome;
	}
	
	public void adicionarCliente(Cliente cliente) {
		clientes.add(cliente);
	}

	public void adicionarFuncionario(Funcionario funcionario) {
		funcionarios.add(funcionario);
	}
	
	public void adicionarServiços(Serviço serviço) {
		serviços.add(serviço);
	}

	public void alugarQuarto() {
		
	}

}
