package Atividade;

import java.util.ArrayList;
import java.util.List;

public class CategoriaItem {
	private Item item;
	private Categoria categoria;
	private int quantidade;
	
	public CategoriaItem(Item item, Categoria categoria, int quantidade) {
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
	
	public boolean cadastrar(CategoriaItem C) {
		return true;
	}
	
	public boolean editar(CategoriaItem C) {
		return true;
	}
	
	public CategoriaItem consultar(CategoriaItem C) {
		return C;
	}
	
	public ArrayList<CategoriaItem> listar(){
		List<CategoriaItem> categoriaItems = new ArrayList<>();
		return null;
	}
	
}
