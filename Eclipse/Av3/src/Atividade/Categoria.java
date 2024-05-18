package Atividade;

import java.util.ArrayList;
import java.util.List;

public class Categoria {
	
	private int codigo;
	private String descricao;
	private double valor;
	public Categoria(int codigo, String descricao, double valor) {
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
	
public boolean cadastrar(Categoria C) {
		
		return true;
	}
	
	public boolean editar(Categoria C) {
		
		return true;
	}
	public Categoria consultar(Categoria C) {
		return C;
	}
	
	public ArrayList<Categoria> listar(){
		List<Categoria> categorias = new ArrayList<>();
		return null;
	}
	
	
	
}
