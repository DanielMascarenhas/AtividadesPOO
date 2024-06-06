package Atividade;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

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
	
	public Consumo consultar(Consumo consumo) {
		ArrayList<Consumo> consumos = consumo.listar();


        
        for(Consumo consumoProcurar : consumos) {
        	if(consumoProcurar.item.getCodigo() == consumoProcurar.item.getCodigo() && consumoProcurar.categoria.getCodigo() == consumoProcurar.categoria.getCodigo()) {
        		return consumoProcurar;
            }
        }
        return null;
	}
	
	public ArrayList<Consumo> listar(){
		ArrayList<Consumo> consumos = new ArrayList<>();
		
		try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
	        String linha;
	        while ((linha = reader.readLine()) != null) {
	        	Consumo consumo = Consumo.fromString(linha);
	        	consumos.add(consumo);
	        }
	    } catch (IOException e) {
	        e.printStackTrace();
	    }

	    return consumos;
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
        
        Categoria categoriaPegar = new Categoria(categoria,"", 0.0 );
        
        categoriaPegar = categoriaPegar.consultar(categoriaPegar);
       
        return new Consumo(itemPegar, categoriaPegar, quantidade);
    }
	
}
