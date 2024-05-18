package Atividade;

import java.util.ArrayList;
import java.util.List;

public class Consumo {
	private Item item;
	private Categoria categoria;
	private int quantidade;
	public Consumo(Item item, Categoria categoria, int quantidade) {
		this.item = item;
		this.categoria = categoria;
		this.quantidade = quantidade;
	}
	
	public Item getItem() {
		return item;
	}
	public void setItem(Item item) {
		this.item = item;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	
	public boolean cadastrar(Consumo C) {
		return true;
	}
	
	public boolean editar(Consumo C) {
		return true;
	}
	
	public Consumo consultar(Consumo C) {
		return C;
	}
	
	public ArrayList<Consumo> listar(){
		List<Consumo> consumos = new ArrayList<>();
		return null;
	}
	
}
