package Atividade;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Consumo {
	private Item item;
	private Categoria categoria;
	private int quantidade;
	
	public static final String FILE_PATH = "Consumos.txt";
	
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
	
	public boolean cadastrar(Consumo consumo) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(consumo.toString());
            writer.newLine();
            System.out.println("Informação cadastrada com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
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
	
	@Override
    public String toString() {
        return item.getCodigo() + "," + categoria.getCodigo() + "," + quantidade;
    }
	

    public static Consumo fromString(String linha) {
    	String[] partes = linha.split(",");
        int item = Integer.parseInt(partes[0]);
        int categoria = Integer.parseInt(partes[1]);
        int quantidade = Integer.parseInt(partes[2]);
        
        Item itemPegar = new Item(item,"", 0.0 );
        
        itemPegar = itemPegar.consultar(itemPegar);
        
        if(itemPegar == null) {
        	System.out.println("Erro, Item nao existe!");
        	return null;
        }
        
        Categoria categoriaPegar = new Categoria(categoria,"", 0.0 );
        
        categoriaPegar = categoriaPegar.consultar(categoriaPegar);
        
        if(categoriaPegar == null) {
        	System.out.println("Erro, Categoria nao existe!");
        	return null;
        }

       
        return new Consumo(itemPegar, categoriaPegar, quantidade);
    }
	
}
