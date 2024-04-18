package Atividade;

import java.util.ArrayList;
import java.util.List;

public class Quarto {
	List<Hospede> hospedes = new ArrayList<>();	
	List<Reserva> reservas = new ArrayList<>();
	String numero;
	Funcionario funcionario;
	Categoria categoria;
	
	public Quarto(String numero, Funcionario funcionario, Categoria categoria) {
		this.numero = numero;
		this.funcionario = funcionario;
		this.categoria = categoria;
	}
	
	public void diaria() {
		reservas.get(0).cliente.fatura += categoria.custoQuarto;
		System.out.println("Diaria Paga Pelo Cliente Cadastrado Na Reserva");
	}

	public void diaria(Cliente cliente) {
		cliente.fatura += categoria.custoQuarto;
		System.out.println("Diaria Paga Pelo Cliente Cadastrado Na Reserva");
	}
	
	public void reservar(Reserva reserva) {
		reservas.add(reserva);
	}
	
	public void serviço(Serviço serviço, Cliente cliente) {
		cliente.fatura += serviço.executarServiço();
		System.out.println("Serviço " + serviço.nome + " Executado");
	}
	
	
	public void fecharQuarto() {
		reservas.get(0).cliente.fatura += categoria.frigobar.registroConsumo;
		System.out.println("Fatura de " + reservas.get(0).cliente.nome + " é de " + reservas.get(0).cliente.fatura);
		reservas.remove(0);
	}
	
	public void fecharQuarto(Cliente cliente) {
		cliente.fatura += categoria.frigobar.registroConsumo;
		System.out.println("Fatura de " + reservas.get(0).cliente.nome + " é de " + reservas.get(0).cliente.fatura);
		reservas.remove(0);
	}
	
	
	
}
