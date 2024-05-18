package Atividade;

import java.util.ArrayList;
import java.util.List;

public class Item {
	private int codigo;
	private String descricao;
	private double valor;
	
	public Item(int codigo, String descricao, double valor) {
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
	
	public boolean cadastrar(Item I) {
		return true;
	}
	
	public boolean editar(Item I) {
		return true;
	}
	
	public Item consultar(Item I) {
		return I;
	}
	
	public ArrayList<Item> listar(){
		List<Item> itens = new ArrayList<>();
		return null;
	}
}
