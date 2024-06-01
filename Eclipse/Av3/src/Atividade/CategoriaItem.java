package Atividade;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class CategoriaItem {
	private Item item;
	private Categoria categoria;
	private int quantidade;
	
	private static final String FILE_PATH = "CategoriasItens.txt";
	
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

	public boolean cadastrar(CategoriaItem CategoriasItens) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_PATH, true))) {
            writer.write(CategoriasItens.toString());
            writer.newLine();
            System.out.println("Categoria do Item cadastrada com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
	
	public boolean editar(CategoriaItem C) {
		return true;
	}
	
	public CategoriaItem consultar(CategoriaItem C) {
		
		
		return C;
	}
	
	
	public static ArrayList<CategoriaItem> listar() {
	ArrayList<CategoriaItem> categoriasItens = new ArrayList<>();

    try (BufferedReader reader = new BufferedReader(new FileReader(FILE_PATH))) {
        String linha;
        while ((linha = reader.readLine()) != null) {
        	CategoriaItem categoriaItem = CategoriaItem.fromString(linha);
            categoriasItens.add(categoriaItem);
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

    return categoriasItens;
	}
	
	@Override
    public String toString() {
        return getItem().getCodigo() + "," + getCategoria().getCodigo() + "," + getQuantidade();
    }

    public static CategoriaItem fromString(String linha) {
    	
        String[] partes = linha.split(",");
        int item = Integer.parseInt(partes[0]);
        int categoria = Integer.parseInt(partes[1]);
        int quantidade = Integer.parseInt(partes[2]);
        
        ArrayList<Item> itemArray = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("Itens.txt"))) {
            String linha2;
            while ((linha2 = reader.readLine()) != null) {
            	Item itemArquivo = Item.fromString(linha2);
            	itemArray.add(itemArquivo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        ArrayList<Categoria> categoriaArray = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("Categorias.txt"))) {
            String linha3;
            while ((linha3 = reader.readLine()) != null) {
            	Categoria categoriaArquivo = Categoria.fromString(linha3);
                categoriaArray.add(categoriaArquivo);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        
        
        Item itemPegar = null;
        boolean achou = false;
        
        for(Item itemAchar : itemArray) {
        	if( item == itemAchar.getCodigo()) {
        		itemPegar = itemAchar;
        		achou = true;
        	}
        }
        
         if(!achou) {
        	System.out.println("Erro, Item nao existe!");
         	return null;
         }
    	
        for(Categoria categoriaAchar : categoriaArray) {
        	if( categoria == categoriaAchar.getCodigo()) {
        		return new CategoriaItem(itemPegar, categoriaAchar, quantidade);
        	}
        }
        
        System.out.println("Erro, Categoria nao existe!");
        return null;
        
    }
    
}
