package Atividade;

import java.util.ArrayList;
import java.util.List;

public class Servico {
	
	private int codigo;
	private String descricao;
	private double valor;
	public Servico(int codigo, String descricao, double valor) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.valor = valor;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	
	public boolean cadastrar(Servico S) {
		return true;
	}
	
	public boolean editar(Servico S) {
		return true;
	}
	
	public Servico consultar(Servico S) {
		return S;
	}
	
	public ArrayList<Servico> listar(){
		List<Servico> servicos = new ArrayList<>();
		return null;
	}
	
	
}
