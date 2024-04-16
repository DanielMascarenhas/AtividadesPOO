package Atividade;

import java.util.ArrayList;
import java.util.List;

public class Quarto {
	List<Hospede> hospedes = new ArrayList<>();
	List<Serviço> serviços = new ArrayList<>();
	String numero;
	Cliente cliente;
	Funcionario funcionario;
	Categoria categoria;
	String dataReserva;
	String dataHospedagem;
	
	
	
	public Quarto(String numero, Cliente cliente, Funcionario funcionario, Categoria categoria, String dataReserva, String dataHospedagem) {
		this.numero = numero;
		this.cliente = cliente;
		this.funcionario = funcionario;
		this.categoria = categoria;
		this.dataReserva = dataReserva;
		this.dataHospedagem = dataHospedagem;
	}

	public void diaria() {
		
	}
	
	public void fecharQuarto() {
		
	}
	
	
	
}
