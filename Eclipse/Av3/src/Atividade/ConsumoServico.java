package Atividade;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ConsumoServico {
	private Servico servico;
	private Categoria categoria;
	private Reserva reserva;
	private int quantidadeSolicitada;
	private Date dataServico;
	public ConsumoServico(Servico servico, Categoria categoria, Reserva reserva, int quantidadeSolicitada,
			Date dataServico) {
		super();
		this.servico = servico;
		this.categoria = categoria;
		this.reserva = reserva;
		this.quantidadeSolicitada = quantidadeSolicitada;
		this.dataServico = dataServico;
	}
	public Servico getServico() {
		return servico;
	}
	public void setServico(Servico servico) {
		this.servico = servico;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public Reserva getReserva() {
		return reserva;
	}
	public void setReserva(Reserva reserva) {
		this.reserva = reserva;
	}
	public int getQuantidadeSolicitada() {
		return quantidadeSolicitada;
	}
	public void setQuantidadeSolicitada(int quantidadeSolicitada) {
		this.quantidadeSolicitada = quantidadeSolicitada;
	}
	public Date getDataServico() {
		return dataServico;
	}
	public void setDataServico(Date dataServico) {
		this.dataServico = dataServico;
	}
	
	public boolean cadastrar(ConsumoServico C) {
		return true;
	}
	
	public boolean editar(ConsumoServico C) {
		return true;
	}
	
	public ConsumoServico consultar(ConsumoServico C) {
		return C;
	}
	
	public ArrayList<ConsumoServico> listar(){
		List<ConsumoServico> consumoServicos = new ArrayList<>();
		return null;
	}
}
