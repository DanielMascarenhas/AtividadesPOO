package Atividade;

import java.util.ArrayList;
import java.util.List;

public class Quarto {
	
	private int codigo;
	private Categoria categoria;
	private String status;
	public Quarto(int codigo, Categoria categoria, String status) {
		this.codigo = codigo;
		this.categoria = categoria;
		this.status = status;
	}
	
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
public boolean cadastrar(Quarto Q) {
		
		return true;
	}
	
	public boolean editar(Quarto Q) {
		
		return true;
	}
	public Quarto consultar(Quarto Q) {
		return Q;
	}
	
	public ArrayList<Quarto> listar(){
		List<Quarto> quartos = new ArrayList<>();
		return null;
	}
	
	
}
